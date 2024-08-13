package com.training.leetcode;



public class RemoveDupsFromSortedList {

    public class ListNode {
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

    public ListNode deleteDuplicates(ListNode head) {

        // Step 1: base case
//        if(head == null || head.next == null) return head;
//
//        Set<Integer> dups = new HashSet<Integer>();
//
//        ListNode sentinel = new ListNode(0);
//
//        sentinel.next = head;
//
//        ListNode prev2 = sentinel, prev1 = head, curr = head.next;
//
//        dups.add(prev1.val);
//
//        while(curr != null) {
//            if(dups.contains(curr.val)) {
//                ListNode next = prev1;
//                while(next != null && next.val == curr.val) {
//                    next = next.next;
//                }
//                if(next != null) {
//                    prev2.next = next;
//                    prev1 = next;
//                    dups.add(next.val);
//                    curr = next.next;
//                } else {
//                    prev2.next = next;
//                    curr = next;
//                }
//            } else {
//                dups.add(curr.val);
//                prev2 = prev1;
//                prev1 = curr;
//                curr = curr.next;
//            }
//
//        }
//        return sentinel.next;

        ListNode sentinel = new ListNode(0);
        ListNode prev = sentinel, curr = head;

        prev.next = curr;

        while(curr != null) {

            if(curr.next != null && curr.val == curr.next.val) {

                while(curr.next != null && curr.val == curr.next.val) {
                    curr = curr.next;
                }
                prev.next = curr.next;
            } else {
                prev = prev.next;
            }
            curr = curr.next;
        }

        return sentinel.next;
    }


    public static void main(String[] args) {
        RemoveDupsFromSortedList obj = new RemoveDupsFromSortedList();
        ListNode head1 = obj.buildList(new int[]{1,2,2});
        obj.deleteDuplicates(head1);
    }

    public ListNode buildList(int[] array) {

        ListNode sentinel = new ListNode(0);
        ListNode curr = sentinel;

        for(int num : array) {
            curr.next = new ListNode(num);
            curr = curr.next;
        }

        return sentinel.next;
    }
}
