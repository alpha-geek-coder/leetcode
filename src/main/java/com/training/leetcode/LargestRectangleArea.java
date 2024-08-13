package com.training.leetcode;

import java.util.Stack;

public class LargestRectangleArea {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack();
        int max_area = 0, n = heights.length;
        for(int i = 0; i <= n; i++){
            while(!stack.isEmpty() && (i == n || heights[stack.peek()] >= heights[i])){
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1 ;
                max_area = Math.max(max_area, height * width);
            }
            stack.push(i);
        }
        return max_area;
    }

    public static void main(String[] args) {
        System.out.println(new LargestRectangleArea().largestRectangleArea(new int[]{2,1,5,6,2,3}));
        System.out.println(new LargestRectangleArea().largestRectangleArea(new int[]{3,2,1,1,2,4,2,1}));
    }
}
