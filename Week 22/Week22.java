public static void main(String[] args) {
    // Reverse Linked List
    public ListNode reverseList(ListNode head) {
        return reverseListRecursive(head, null);
    }
    private ListNode reverseListRecursive(ListNode currentNode, ListNode nextNode) {
        if(currentNode == null) return nextNode;
        ListNode oldNode = currentNode.next;
        current.next = nextNode;
        return reverseListRecursive(oldNode, currentNode);
    }
}