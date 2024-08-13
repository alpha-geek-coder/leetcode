package com.training.leetcode;



public class ReOrderList {

    static class ListNode {

        int val;
        ListNode next;

        ListNode(int v, ListNode node) { val = v; next = node; }

        ListNode(int v) { val = v;}
    }

    public void reorderList(ListNode head) {

        if(head == null || head.next == null) return;

        ListNode prev = null, slow = head, fast = head;

        while(fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        //step 1. reverse second half of list.
        ListNode prev1 = null, curr = slow;

        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev1;
            prev1 = curr;
            curr = next;
        }

        // step 2. Merge one by one

        ListNode node1 = head, node2 = prev1;

        while(node1 != null) {
            ListNode temp1 = node1.next;
            node1.next = node2;
            ListNode temp2= node2.next;
            if(temp1 == null) break;
            node2.next = temp1;
            node1 = temp1;
            node2 = temp2;
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

        new ReOrderList().reorderList(sentinel.next);

        ListNode n = sentinel.next;

        while(n != null) {
            System.out.print(n.val + " ");
            n = n.next;
        }
    }
}
