public class Recursion {
    public static void main(String[] args) {

    }

    // SWAP NODES IN PAIRS
    class Solution {
        public ListNode swapPairs(ListNode head) {
            if(head == null || head.next == null) return head;

            return recursive(head);
        }

        private ListNode recursive(ListNode head) {
            if(head == null || head.next == null) return head;

            ListNode firstNode = head; // 1
            ListNode secondNode = head.next; // 2

            firstNode.next = recursive(secondNode.next); // 3
            secondNode.next = firstNode; // 3

            return secondNode;
        }
    }

}