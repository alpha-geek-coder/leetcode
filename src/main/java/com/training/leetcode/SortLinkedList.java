package com.training.leetcode;

public class SortLinkedList {

    static class ListNode {

        int val;
        ListNode next;

        ListNode(int v, ListNode node) {
            val = v;
            next = node;
        }

        ListNode(int v) {
            val = v;
        }
    }

    public ListNode sortList(ListNode head) {

        if(head == null || head.next == null) return head;

        ListNode prev = null, slow = head, fast = head;

        while(fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null; // delink end of first half from the rest.

        ListNode list1 = sortList(head);
        ListNode list2 = sortList(slow);

        return mergeList(list1, list2);
    }

    public ListNode mergeList(ListNode list1, ListNode list2) {

        ListNode sentinel = new ListNode(0), prev = sentinel, left = list1, right = list2;

        while(left != null && right != null) {
            if(left.val < right.val) {
                prev.next = left;
                left = left.next;
            } else {
                prev.next = right;
                right = right.next;
            }
            prev = prev.next;
        }

        if(left != null) {
            prev.next = left;
        }

        if(right != null) {
            prev.next = right;
        }

        return sentinel.next;
    }

    public static void main(String[] args) {
        int[] nodes = new int[] {-1,5,3,4,0};

        ListNode sentinel = new ListNode(0), prev = sentinel;

        for(int val : nodes) {
             ListNode node = new ListNode(val);
             prev.next = node;
             prev = node;
        }

        ListNode unSortedListHead = sentinel.next;

        ListNode sortedListHead = new SortLinkedList().sortList(unSortedListHead);

        ListNode node = sortedListHead;

        while(node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }
}
