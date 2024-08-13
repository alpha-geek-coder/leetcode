package com.training.leetcode;

public class RemoveNthNodeFromEndofList {

    static class ListNode {

        int val;
        ListNode next;

        ListNode(int v, ListNode node) { val = v; next = node; }

        ListNode(int v) { val = v;}

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode slow = head, fast = head;

        for(int i = 0; i < n; i++) fast = fast.next;

        if(fast == null) return head.next;

        while(fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return head;
    }


    public static void main(String[] args) {

        int[] nodes = new int[]{1,2,3};

        ListNode sentinel = new RemoveNthNodeFromEndofList.ListNode(0), prev = null;

        for (int val : nodes) {
            ListNode node = new RemoveNthNodeFromEndofList.ListNode(val);;
            prev.next = node;
            prev = node;
        }



        ListNode n = new RemoveNthNodeFromEndofList().removeNthFromEnd(sentinel.next, 2);

        while (n != null) {
            System.out.print(n.val + " ");
            n = n.next;
        }
    }
}
