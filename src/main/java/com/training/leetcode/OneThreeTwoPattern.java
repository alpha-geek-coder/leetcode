package com.training.leetcode;

import java.util.Stack;

public class OneThreeTwoPattern {
    public boolean find132pattern(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        for(int i = 0; i < n; i++){
            int num = nums[i];
            if(stack.size() >= 2 && stack.peek() > num) return true;
            while(!stack.isEmpty() && stack.peek() >= num) stack.pop();

            stack.push(num);
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(new OneThreeTwoPattern().find132pattern(new int[]{3,1,4,2}));

    }
}
