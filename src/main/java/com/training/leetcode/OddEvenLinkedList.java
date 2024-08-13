package com.training.leetcode;

public class OddEvenLinkedList {
    /*
    Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.

The first node is considered odd, and the second node is even, and so on.

Note that the relative order inside both the even and odd groups should remain as it was in the input.

You must solve the problem in O(1) extra space complexity and O(n) time complexity.
Example 1:

Input: head = [1,2,3,4,5]
Output: [1,3,5,2,4]
     */
    public ListNode oddEvenList(ListNode head) {
        if(head == null) return head;
        ListNode odd = head, even = head.next, evenHead = even;
        while(even != null && even.next != null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
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
        ListNode head1 = buildList(new int[]{1,2,3,4,5});
        ListNode res1 = new OddEvenLinkedList().oddEvenList(head1);
        printList(res1);

        ListNode head2 = buildList(new int[]{2,1,3,5,6,4,7});
        ListNode res2 = new OddEvenLinkedList().oddEvenList(head2);
        printList(res2);

    }
}
