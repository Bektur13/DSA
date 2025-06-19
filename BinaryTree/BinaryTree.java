public static void main(String[] args) {
//    Lowest common Ancestor in Binary Search Tree
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            int min = Math.min(p.val, q.val);
            int max = Math.max(p.val, q.val);

            if(min <= root.val && root.val <= max) return root;
            if(max <= root.val) return lowestCommonAncestor(root.left, p, q);
            return lowestCommonAncestor(root.right, p, q);
        }
    }
//    Binary Tree Level Order Traversal
    class Pair {
        TreeNode node;
        int level;
        public Pair(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }


    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> answer = new ArrayList<>();

            if (root == null) {
                return answer; // Handle the case of an empty tree
            }

            Queue<Pair> queue = new LinkedList<>();
            queue.add(new Pair(root, 0));

            while(!queue.isEmpty()) {
                Pair pair = queue.poll();
                TreeNode currentNode = pair.node;
                int currentLevel = pair.level;

                // If the current level is greater than or equal to the size of answer,
                // it means we're encountering a new level, so add a new list.
                if (currentLevel >= answer.size()) {
                    answer.add(new ArrayList<>());
                }

                // Add the current node's value to the list corresponding to its level
                answer.get(currentLevel).add(currentNode.val);

                // Add left child to the queue
                if (currentNode.left != null) {
                    queue.add(new Pair(currentNode.left, currentLevel + 1));
                }

                // Add right child to the queue
                if (currentNode.right != null) {
                    queue.add(new Pair(currentNode.right, currentLevel + 1));
                }
            }
            return answer;
        }
    }
}