package com.training.leetcode;

public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {

        if(head == null) return true;

        ListNode slow = head, fast = head;

        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode firstHalfEnd = slow;
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);

        ListNode p1 = head, p2 = secondHalfStart;
        boolean result = true;
        while(result && p2 != null){
            if(p1.val != p2.val) result = false;
            p1 = p1.next;
            p2 = p2.next;
        }

        firstHalfEnd.next = reverseList(secondHalfStart);

        return result;
    }

    public ListNode reverseList(ListNode head){

        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head1 = buildList(new int[]{1,2,2,1});
        System.out.println(new PalindromeLinkedList().isPalindrome(head1));

        ListNode head2 = buildList(new int[]{1,2});
        System.out.println(new PalindromeLinkedList().isPalindrome(head2));
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
}
