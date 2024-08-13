package com.training.leetcode;

import java.util.Stack;

public class TrapRainWater {

    /*
    Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

    Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
    Output: 6
    Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
    In this case, 6 units of rain water (blue section) are being trapped.
     */

    public int trap(int[] height) {

//        int leftMax = 0, rightMax = 0, area = 0;
//        int n = height.length, left = 0, right = n - 1;
//
//        while(left < right) {
//
//            if(height[left] < height[right]){
//                if(leftMax < height[left]){
//                    leftMax = height[left];
//                } else {
//                    area += leftMax - height[left];
//                }
//                left++;
//            } else {
//                if(rightMax < height[right]){
//                    rightMax = height[right];
//                } else {
//                    area += rightMax - height[right];
//                }
//                right--;
//            }
//        }
//
//        return area;

        Stack<Integer> stack = new Stack();
        int ans = 0, begin = 0;
        while(begin < height.length && height[begin] == 0) begin++;
        for(int i = begin; i < height.length; i++){
            int curr = height[i];
            while(!stack.isEmpty() && curr > height[stack.peek()]){
                int valley = height[stack.pop()];
                if(!stack.isEmpty()){
                    ans += Math.min(curr, (height[stack.peek()] - valley) * (i - stack.peek() - 1));
                }
            }
            stack.push(i);
        }
        return ans;


    }

    public static void main(String[] args) {
        System.out.println(new TrapRainWater().trap(new int[]{4,3,2,1,0,1}));
        System.out.println(new TrapRainWater().trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
        System.out.println(new TrapRainWater().trap(new int[]{4,2,0,3,2,5}));
    }
}
