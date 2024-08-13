package com.training.leetcode;

import java.util.Stack;

public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums){
        int n = nums.length;
//        Step 1: Replace out of range [1, n] elements with positive out of bound values
        for(int i = 0; i < n; i++){
            int num = nums[i];
            if(num <= 0 || num > n) nums[i] = n + 1;
        }
//        Step 2 : Place positive elements in their index position, ignore duplicates
        for(int i = 0; i < n; i++){
            int num = Math.abs(nums[i]);
            if(num > n) continue;
            if(nums[num - 1] > 0) nums[num - 1] *= -1;
        }
        for(int i = 0; i < n; i++){
            if(nums[i] >= 0) return i + 1;
        }

        return n + 1;
    }

    public static void main(String[] args) {
        System.out.println(new FirstMissingPositive().firstMissingPositive(new int[]{3,4,-1,1}));
        String num = "1432219"; int k = 3;
        Stack<Integer> stack = new Stack();
        int count = 0;
        for(int i = 0; i < num.length(); i++){
            int n = num.charAt(i) - '0';
            while(!stack.isEmpty() && stack.peek() > n && count < k ){
                stack.pop();
                count++;
            }
            stack.push(n);
        }
        while(count < k && !stack.isEmpty()){
            stack.pop();
            count++;
        }
        StringBuilder sb = new StringBuilder();

        while(!stack.isEmpty()){
            int n = stack.pop();
            sb.append(n);
        }

        while(sb.length() > 0 && sb.charAt(sb.length() - 1) == '0'){
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
