package com.training.leetcode;

public class RotateList {

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

      public ListNode rotateRight(ListNode head, int k) {

          // Step 1: Count nodes;
            ListNode curr = head;
            int count = 0;
            while(curr != null) {
                  count++;
                  curr = curr.next;
            }

            int shiftRight = k % count;

            if(shiftRight == 0) return head;

            ListNode slow = head, fast = head;
            for(int i = 0 ; i < shiftRight; i++) fast = fast.next;

            while(fast.next != null) {
                  slow = slow.next;
                  fast = fast.next;
            }
            ListNode newHead = slow.next;
            slow.next = null;
            fast.next = head;

            return newHead;

      }

      public static void main(String[] args) {
          RotateList obj = new RotateList();
          ListNode head1 = obj.buildList(new int[]{0,1,2});
          obj.rotateRight(head1, 4);
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
