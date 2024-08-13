package com.training.leetcode;

public class SortList {
    /*
    Given the head of a linked list, return the list after sorting it in ascending order.
Example 1:
Input: head = [4,2,1,3]
Output: [1,2,3,4]

Example 2:
Input: head = [-1,5,3,4,0]
Output: [-1,0,3,4,5]

Example 3:
Input: head = []
Output: []

Constraints:

The number of nodes in the list is in the range [0, 5 * 104].
-105 <= Node.val <= 105
     */
    public ListNode sortList(ListNode head) {

        if(head == null || head.next == null) return head;

        // Find middle node
        ListNode slow = head, fast = head.next;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode secondHead = slow.next;
        slow.next = null; // delink/split from middle node
        ListNode left = sortList(head);
        ListNode right = sortList(secondHead);

        return mergeList(left, right);
    }

    public ListNode mergeList(ListNode left, ListNode right){

        ListNode sentinel = new ListNode(0), curr = sentinel;
        ListNode p1 = left, p2 = right;
        while(p1 != null && p2 != null){
            if(p1.val < p2.val){
                curr.next = p1;
                p1 = p1.next;
            } else {
                curr.next = p2;
                p2 = p2.next;
            }
            curr = curr.next;
        }
        if(p1 != null) curr.next = p1;
        if(p2 != null) curr.next = p2;

        return sentinel.next;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode buildList(int[] nodes){

        ListNode sentinel = new ListNode(0);
        ListNode node = sentinel;
        for(int n : nodes){
            node.next = new ListNode(n);
            node = node.next;
        }
        return sentinel.next;
    }

    public static void printList(ListNode head){
        ListNode curr = head;
        while(curr != null){
            System.out.print(curr.val +"->");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head1 = buildList(new int[]{4,2,1,3});
        ListNode sortedList1 = new SortList().sortList(head1);
        printList(sortedList1);

        ListNode head2 = buildList(new int[]{10,1,60,30,5});
        ListNode sortedList2 = new SortList().sortList(head2);
        printList(sortedList2);


        ListNode head3 = buildList(new int[]{-1,5,3,4,0});
        ListNode sortedList3 = new SortList().sortList(head3);
        printList(sortedList3);

    }
}
