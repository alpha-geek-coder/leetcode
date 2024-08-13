package com.training.leetcode;

public class MergeKSortedList {
    /*
    You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.



Example 1:

Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6
Example 2:

Input: lists = []
Output: []
Example 3:

Input: lists = [[]]
Output: []


Constraints:

k == lists.length
0 <= k <= 104
0 <= lists[i].length <= 500
-104 <= lists[i][j] <= 104
lists[i] is sorted in ascending order.
The sum of lists[i].length will not exceed 104.
     */
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {

        int k = lists.length;
        if(k == 0) return null;

        ListNode sentinel = new ListNode(105);

        ListNode curr = sentinel;

        while(curr != null){

            ListNode min = null;
            int minPos = -1;
            for(int i = 0; i < k; i++){

                if(lists[i] != null){
                    if(min == null || lists[i].val < min.val){
                        min = lists[i];
                        minPos = i;
                    }
                }
            }
            if(minPos == -1) break; // none found
            curr.next = min;
            lists[minPos] = lists[minPos].next;
            curr = curr.next;
        }
        return sentinel.next;
    }

    public static void main(String[] args) {
        ListNode list1 = buildList(new int[]{1,4,5});
        ListNode list2 = buildList(new int[]{1,3,4});
        ListNode list3 = buildList(new int[]{2,6});
        System.out.println(new MergeKSortedList().mergeKLists(new ListNode[]{list1,list2, list3}));
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
