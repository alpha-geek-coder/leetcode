package com.training.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if (head == null) return head;
        ListNode leftSentinel = new ListNode(-1);
        ListNode rightSentinel = new ListNode(-1);
        ListNode left = leftSentinel, right = rightSentinel, curr = head;

        while (curr != null) {
            if (curr.val < x) {
                left.next = curr;
                left = left.next;
            } else {
                right.next = curr;
                right = right.next;
            }
            curr = curr.next;
        }
        left.next = null;
        right.next = null;
        left.next = rightSentinel.next;
        return leftSentinel.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int v) {
            val = v;
        }
    }

    public static ListNode buildList(int[] arr) {
        ListNode sentinel = new ListNode(-1);
        ListNode curr = sentinel;
        for (int e : arr) {
            curr.next = new ListNode(e);
            curr = curr.next;
        }
        return sentinel.next;
    }

    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + "->");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode ans1 = new PartitionList().partition(buildList(new int[]{1, 4, 3, 2, 5, 2}), 4);
        printList(ans1);
        ListNode ans2 = new PartitionList().partition(buildList(new int[]{1, 2}), 2);
        printList(ans2);
        //  int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        int[] nums = new int[]{1, -1};
        int n = nums.length, idx = 0, k = 1;
        int[] ans = new int[n - k + 1];
        Deque<Integer> q = new ArrayDeque();
        for (int i = 0; i < n; i++) {
            if (!q.isEmpty() && q.peekFirst() + k - 1 < i) {
                q.pollFirst();
            }
            while (!q.isEmpty() && nums[q.peekLast()] < nums[i]) {
                q.pollLast();
            }
            q.add(i);
            if (i >= k - 1) ans[idx++] = nums[q.peekFirst()];
        }

        int[] arr = new int[]{9, 12, 5, 10, 14, 3, 10};
        int pivot = 10;

        int l = 0, x = arr.length, r = x - 1;

        int i = 0;
        while (i <= r) {
            if (arr[i] == pivot) {
                i++;
            } else if (arr[i] < pivot) {
                swap(arr, i++, l++);

            } else {
                while(r >= 0 && arr[r] > pivot) r--;
                swap(arr, i, r--);
            }

        }
        for (int e : arr) {
            System.out.print(e + ",");
        }

    }

    public static void swap(int[] arr, int x, int y) {
        int z = arr[x];
        arr[x] = arr[y];
        arr[y] = z;
    }
}
