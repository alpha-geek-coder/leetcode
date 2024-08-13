package com.training.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;

public class NextGreaterElementIV {
    public int[] secondGreaterElement(int[] nums) {

        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        Stack<Integer> stack = new Stack();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> nums[a] - nums[b]);
        for(int i = 0; i < n; i++){
            while(!pq.isEmpty() &&  nums[pq.peek()] < nums[i]){
                ans[pq.poll()] = nums[i];
            }
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i]){
                pq.add(stack.pop());
            }
            stack.push(i);
        }


        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new NextGreaterElementIV().secondGreaterElement(new int[]{2,4,0,9,6}));
    }
}
