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


//public static void main(String[] args) {
////    Lowest common Ancestor in Binary Search Tree
//    class Solution {
//        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//            int min = Math.min(p.val, q.val);
//            int max = Math.max(p.val, q.val);
//
//            if(min <= root.val && root.val <= max) return root;
//            if(max <= root.val) return lowestCommonAncestor(root.left, p, q);
//            return lowestCommonAncestor(root.right, p, q);
//        }
//    }
////    Binary Tree Level Order Traversal
//    class Pair {
//        TreeNode node;
//        int level;
//        public Pair(TreeNode node, int level) {
//            this.node = node;
//            this.level = level;
//        }
//    }
//
//
//    class Solution {
//        public List<List<Integer>> levelOrder(TreeNode root) {
//            List<List<Integer>> answer = new ArrayList<>();
//
//            if (root == null) {
//                return answer; // Handle the case of an empty tree
//            }
//
//            Queue<Pair> queue = new LinkedList<>();
//            queue.add(new Pair(root, 0));
//
//            while(!queue.isEmpty()) {
//                Pair pair = queue.poll();
//                TreeNode currentNode = pair.node;
//                int currentLevel = pair.level;
//
//                // If the current level is greater than or equal to the size of answer,
//                // it means we're encountering a new level, so add a new list.
//                if (currentLevel >= answer.size()) {
//                    answer.add(new ArrayList<>());
//                }
//
//                // Add the current node's value to the list corresponding to its level
//                answer.get(currentLevel).add(currentNode.val);
//
//                // Add left child to the queue
//                if (currentNode.left != null) {
//                    queue.add(new Pair(currentNode.left, currentLevel + 1));
//                }
//
//                // Add right child to the queue
//                if (currentNode.right != null) {
//                    queue.add(new Pair(currentNode.right, currentLevel + 1));
//                }
//            }
//            return answer;
//        }
//    }
//}