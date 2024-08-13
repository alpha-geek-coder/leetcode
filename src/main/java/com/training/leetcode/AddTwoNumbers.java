package com.training.leetcode;

import java.util.Stack;

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack();
        Stack<Integer> stack2 = new Stack();

        ListNode curr1 = l1;

        while(curr1 != null){
            stack1.push(curr1.val);
            curr1 = curr1.next;
        }

        ListNode curr2 = l2;

        while(curr2 != null){
            stack2.push(curr2.val);
            curr2 = curr2.next;
        }

        int sum = 0, carry = 0;
        ListNode ans = new ListNode();

        while(!stack1.isEmpty() || !stack2.isEmpty()){
            if (!stack1.isEmpty()) sum += stack1.pop();
            if (!stack2.isEmpty()) sum += stack2.pop();
            ans.val = sum % 10;
            carry = sum / 10;
            ListNode head = new ListNode(carry);
            head.next = ans;
            ans = head;
            sum = carry;
        }


        return carry == 0 ? ans.next: ans;

    }

    static class ListNode{
        int val;
        ListNode next;
        ListNode() {};
        ListNode(int val) { this.val = val; }
    }

    public static void main(String[] args) {
        int[] list1 = new int[]{7,2,4,3};
        int[] list2 = new int[]{5,6,4};
        ListNode l1 = buildList(list1);
        ListNode l2 = buildList(list2);
        ListNode ans = new AddTwoNumbers().addTwoNumbers(l1, l2);

    }

    public static ListNode buildList(int[] list){
        ListNode sentinel = new ListNode(-1);
        ListNode curr = sentinel;
        for(int n : list){
            curr.next = new ListNode(n);
            curr = curr.next;
        }
        return sentinel.next;
    }

    public static void printList(ListNode list){
        ListNode curr = list;
        while(curr != null){
            System.out.print(curr.val + "->");
        }
        System.out.println("");
    }
}
