package com.training.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LinkedListCycleII {
    /*
    Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as a parameter.

Do not modify the linked list.


Example 1:
Input: head = [3,2,0,-4], pos = 1
Output: tail connects to node index 1
Explanation: There is a cycle in the linked list, where tail connects to the second node.

Example 2:
Input: head = [1,2], pos = 0
Output: tail connects to node index 0
Explanation: There is a cycle in the linked list, where tail connects to the first node.

Example 3:
Input: head = [1], pos = -1
Output: no cycle
Explanation: There is no cycle in the linked list.
     */

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode detectCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;

            if(slow == fast) break;
        }

        if(fast == null || fast.next == null) return null;
        slow = head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }

        return slow;

    }

    public static ListNode buildCycleList(int[] nodes){
        Map<Integer, ListNode> map = new HashMap<>();
        ListNode sentinel = new ListNode(0);
        ListNode node = sentinel;
        for(int n : nodes){
            if(map.containsKey(n)){
                node.next = map.get(n);
            } else {
                node.next = new ListNode(n);
                map.put(n, node.next);
            }

            node = node.next;
        }
        return sentinel.next;
    }

    public static void main(String[] args) {
        ListNode head = buildCycleList(new int[]{3,2,0,-4,2});
        System.out.println(new LinkedListCycleII().detectCycle(head).val);
        head = buildCycleList(new int[]{1,2,1});
        System.out.println(new LinkedListCycleII().detectCycle(head).val);
    }
}
