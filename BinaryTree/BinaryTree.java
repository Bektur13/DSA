// Definition of Binary Tree
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    // Constructors
    TreeNode () {}
    TreeNode(int val) { this.val = val }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

// Creating a Binary Tree
public class BinaryTreeExample {
    // Creating nodes
    TreeNode root = new TreeNode(1);
    TreeNode leftChild = new TreeNode(2);
    TreeNode rightChild = new TreeNode(3);
    TreeNode grandLeftChild = new TreeNode(4);
    TreeNode grandRightChild = new TreeNode(5);

    root.left = leftChild;
    root.right = righChild;
    leftChild.left = grandLeftChild;
    leftChild.right = grandRightChild;

    // Calculating Size of Binary Tree
    public static int getSize(TreeNode root) {
        if(root == null) return 0;

        return 1 + getSize(root.left) + getSize(root.right);
    }

    // Calculating Height of Binary Tree
    public static int getHeight(TreeNode root) {
        if(root == null) {
            return -1;
        }

        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }

    // Binary Tree Traversals
    // 1. Depth-First Search(DFS) Implementation Recursive
    // IN-ORDER TRAVERSAL
    // In in-order traversal, the left child is visited first, followed by the node itself, and then the right child.
    // This can be visualized as Left - Root - Right.
    public static void inOrderTraversal(TreeNode root) {
        if(root == null) return;

        inOrderTraversal(root.left);

        System.out.println(root.val + "");

        inOrderTraversal(root.right);
    }

    // PRE-ORDER TRAVERSAL
    // In pre-order traversal, the node is visited first, followed by its left child and then its right child.
    // This can be visualized as Root - Left - Right
    public static void preOrderTraversal(TreeNode root) {
        System.out.println(root.val + "");

        preOrderTraversal(root.left);

        preOrderTraversal(root.right);
    }

    // POST-ORDER TRAVERSAL
    // In post-order traversal, the left child is visited first, then the right child, and finally the node itself.
    // This can be visualized as Left - Right - Root.
    public static void postOrderTraversal(TreeNode root) {
        postOrderTraversal(root.left);

        postOrderTraversal(root.right);

        System.out.println(root.val + "");
    }

    // DFS Pre Order Traverse Iterative
    public static void preOrderTraversalIterative(TreeNode root) {
        if(root == null) return;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()) {
            TreeNode currentNode = stack.pop();

            if(root.right != null) {
                stack.push(currentNode.right);
            }

            if(root.left != null) {
                stack.push(currentNode.left);
            }
        }
    }

    // 2. Breadth-First Search(BFS) Traversal
    // LEVEL-ORDER TRAVERSAL
    public static void levelOrderTraversal(TreeNode root) {
        if(root == null) return;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            TreeNode current = q.poll();

            System.out.println(root.val + " ");
            if(current.left != null) {
                q.add(current.left);
            }
            if(current.right != null) {
                q.add(current.right);
            }
        }
    }
}


// LEETCODE PROBLEMS
class BinaryTreeProblems {
    public static void main(String[] args) {
        // INVERT BINARY TREE
        public TreeNode invertTree(TreeNode root) {
            if(root == null) return root;

            TreeNode temp = invertTree(root.right);
            root.right = invertTree(root.left);
            root.left = temp;

            return root;
        }

        //MAXIMUM DEPTH OF BINARY TREE
        public int maxDepth(TreeNode root) {
            if(root == null) return 0;

            return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
        }

    }
}