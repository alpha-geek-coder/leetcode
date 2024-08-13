package com.training.leetcode;

public class ReverseNodeInKGroups {
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode sentinel = new ListNode(0);
//        ListNode curr = head;
//        ListNode rev = sentinel;
//        Deque<ListNode> q = new ArrayDeque<>();
//
//
//        while(curr != null){
//            q.add(curr);
//            curr = curr.next;
//            if(q.size() == k){
//                while(!q.isEmpty()){
//                    rev.next = q.pollLast();
//                    rev = rev.next;
//                    rev.next = null;
//                }
//            }
//
//        }
//        while(!q.isEmpty()){
//            rev.next = q.pollFirst();
//            rev = rev.next;
//            rev.next = null;
//        }
//        return sentinel.next;
        sentinel.next = head;
        ListNode curr = sentinel;
        while(curr != null){
            ListNode node = curr;
            for(int i = 0; i < k && node != null; i++){
                node = node.next;
            }
            if(node == null) break;
            ListNode prev = null, currNode = curr.next, next = null;

            for(int i = 0; i < k; i++){
                next = currNode.next;
                currNode.next = prev;
                prev = currNode;
                currNode = next;
            }
            ListNode tail = curr.next;
            tail.next = currNode;
            curr.next = prev;
            curr = tail;

        }

        return sentinel.next;
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

        ListNode ans = new ReverseNodeInKGroups().reverseKGroup(sentinel.next, 3);
        while(ans != null){
            System.out.print(ans.val + " ");
            ans = ans.next;
        }
    }
}
