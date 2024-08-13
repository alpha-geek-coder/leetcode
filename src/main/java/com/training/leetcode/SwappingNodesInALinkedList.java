package com.training.leetcode;

public class SwappingNodesInALinkedList {
    public ListNode swapNodes(ListNode head, int k) {

//        ListNode curr = head, first = null, second = null;
//        int n = 0;
//        while(curr != null){
//            n++;
//            if(n == k) first = curr;
//            curr = curr.next;
//        }
//        curr = head;
//        int counter = 0;
//        while(curr != null){
//            counter++;
//            if(counter == n - k + 1) second = curr;
//            curr = curr.next;
//        }
//        if(first != null && second != null){
//            int temp = first.val;
//            first.val = second.val;
//            second.val = temp;
//        }
        // Approach 2
//        ListNode first = null, second = null;
//        for(ListNode curr = head; curr != null; curr = curr.next){
//            second = second == null ? second : second.next;
//            if(--k == 0){
//                first = curr;
//                second = head;
//            }
//        }
//        if(first != null && second != null){
//            int temp = first.val;
//            first.val = second.val;
//            second.val = temp;
//        }

        //Approach 3
        ListNode fast = head;
        ListNode slow = head;
        ListNode first = head, second = head;
        // Put fast (k-1) nodes after slow
        for(int i = 0; i < k - 1; ++i)
            fast = fast.next;

        // Save the node for swapping
        first = fast;

        // Move until the end of the list
        while(fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // Save the second node for swapping
        // Note that the pointer second isn't necessary: we could use slow for swapping as well
        // However, having second improves readability
        second = slow;

        // Swap values
        int temp = first.val;
        first.val = second.val;
        second.val = temp;

        return head;
    }
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        int[] nodes = new int[] {1,2,3,4,5};

        ListNode sentinel = new ListNode(0), prev = sentinel;

        for(int val : nodes) {
            ListNode node = new ListNode(val);
            prev.next = node;
            prev = node;
        }

        ListNode ans1 = new SwappingNodesInALinkedList().swapNodes(sentinel.next, 2);

        while(ans1 != null){
            System.out.print(ans1.val +"->");
            ans1 = ans1.next;
        }
    }
}
