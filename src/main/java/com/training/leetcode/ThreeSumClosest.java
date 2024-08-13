package com.training.leetcode;

import java.util.Arrays;

public class ThreeSumClosest {

    /*
    Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.

Return the sum of the three integers.

You may assume that each input would have exactly one solution.

 Example 1:

Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

     */
    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);

        int n = nums.length, i = 0, j = 1, k = n - 1;
        int closest = nums[i] + nums[j] + nums[k];
        while(i < n - 2){
            int sum = nums[i] + nums[j] + nums[k];
            if(Math.abs(target - sum) < Math.abs(target - closest)){
                closest = sum;
            }
            if(sum < target){
                j++;
            } else {
                k--;
            }
            if(j >= k){
                i++;
                j = i + 1;
                k = n - 1;
            }

        }
        return closest;
    }

    public static void main(String[] args) {
        System.out.println(new ThreeSumClosest().threeSumClosest(new int[]{-1,2,1,-4}, 1));
        System.out.println(new ThreeSumClosest().threeSumClosest(new int[]{0,0,0}, 1));
    }
}
