public static void main(String[] args) {
    // REVERSE LINKED LISTS
    public ListNode reverseList(ListNode head) {
        return reverseListRecursive(head, null);
    }
    private ListNode reverseListRecursive(ListNode currentNode, ListNode nextNode) {
        if(currentNode == null) return nextNode;
        ListNode oldNode = currentNode.next;
        current.next = nextNode;
        return reverseListRecursive(oldNode, currentNode);
    }

    // MERGE TWO SORTED LISTS
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        if(list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        }
        list2.next = mergeTwoLists(list1, list2.next);
        return list2;
    }

    // REVERSE LINKED LIST ||

    // REMOVE Nth NODE FROM END OF THE LIST
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // assume that we have a linked list like: n = 4
        // (0) -> (1) -> (2) -> (3) -> (4) -> (5) -> null
        // slow and fast (0) -> (1) -> (2) -> (3) -> (4) -> (5) -> null
        ListNode slow = head, fast = head;
        for(int i = 0; i < n; i++) {
            fast = fast.next;
        }
        // slow (0) -> (1) -> (2) -> (3) -> fast (4) -> (5) -> null
        // Now we need to move them one by one
        if(fast == null) {
            return head.next;
        }
        // here we delete our n integer form linked list
        while(fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    // ADD TWO NUMBERS

    // DESIGN BROWSER HISTORY
    
}