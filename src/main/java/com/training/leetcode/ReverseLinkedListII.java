package com.training.leetcode;

import java.util.ArrayList;
import java.util.List;

public class ReverseLinkedListII {

    static class ListNode {

        int val;
        ListNode next;

        ListNode(int v, ListNode node) { val = v; next = node; }

        ListNode(int v) { val = v;}

    }

    public ListNode reverseBetween(ListNode head, int left, int right) {

        if(head == null || head.next == null) return head;

        //step 1: find start and end nodes

        ListNode prev = null, prevStart = null, afterEnd = null,
                curr = head, start = null, end = null;

        int i = 1;

        while(curr != null && i <= right) {

            if(i == left) {
                prevStart = prev;
                start = curr;
            }

            if(i == right) {
                end = curr;
                afterEnd = end.next;
            }

            prev = curr;
            curr = curr.next;

            i++;
        }

        //step 2: delink before and after
        if(prevStart != null) prevStart.next = null;
        if(end != null)end.next = null;

        //step 3: reverse start to end

        ListNode prev1 = null, current = start, next = null;

        while(current != null) {
            next = current.next;
            current.next = prev1;
            prev1 = current;
            current = next;
        }

        //step 4: link back
        if(prevStart != null) prevStart.next = prev1;
        start.next = afterEnd;

        return prevStart != null ? head : prev1 ;
    }

    public static void main(String[] args) {
        int[] nodes = new int[]{1,2,3};

        ListNode sentinel = new ListNode(0), prev = sentinel;

        for (int val : nodes) {
            ListNode node = new ListNode(val);
            prev.next = node;
            prev = node;
        }


        ListNode n = new ReverseLinkedListII().reverseBetween(sentinel.next, 1, 2);

        while (n != null) {
            System.out.print(n.val + " ");
            n = n.next;
        }

        List<List<Integer>> triangle = new ArrayList();
        for(int r = 0; r < 5; r++){
            List<Integer> curr = new ArrayList<Integer>();
            curr.add(1);
            for(int c = 1; c < r; c++){
                curr.add(c, triangle.get(r - 1).get(c - 1) + triangle.get(r - 1).get(c));
            }
            if(r > 0) curr.add(1);
            triangle.add(curr);
        }
    }
}
