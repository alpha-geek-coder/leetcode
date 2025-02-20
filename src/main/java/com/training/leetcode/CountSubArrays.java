package com.training.leetcode;



public class CountSubArrays {
    /*
    You are given an integer array nums and two integers minK and maxK.

A fixed-bound subarray of nums is a subarray that satisfies the following conditions:

The minimum value in the subarray is equal to minK.
The maximum value in the subarray is equal to maxK.
Return the number of fixed-bound subarrays.

A subarray is a contiguous part of an array.

Example 1:

Input: nums = [1,3,5,2,7,5], minK = 1, maxK = 5
Output: 2
Explanation: The fixed-bound subarrays are [1,3,5] and [1,3,5,2].
Example 2:

Input: nums = [1,1,1,1], minK = 1, maxK = 1
Output: 10
Explanation: Every subarray of nums is a fixed-bound subarray. There are 10 possible subarrays.
     */

    public long countSubarrays(int[] nums, int minK, int maxK) {

        long ans = 0;

//        for(int i = 0; i < nums.length; i++){
//            if(nums[i] == minK){
//                int j = i;
//                while(j< nums.length && nums[j] < maxK){
//                    j++;
//                }
//                for(; j < nums.length && nums[j] <= maxK; j++){
//                    ans++;
//                }
//            }
//        }
//
//        return ans;
        int n = nums.length;
        int leftBound = -1, minIdx = -1, maxIdx = -1;
        for(int i = 0 ; i < n; i++){
            int num = nums[i];

            if(num >= minK && num <= maxK){
                if(num == minK) minIdx = i;
                if(num == maxK) maxIdx = i;
                ans += Math.max(0, Math.min(minIdx, maxIdx) - leftBound);
            } else {
                leftBound = i;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new CountSubArrays().countSubarrays(new int[]{1,3,5,2,7,5}, 1, 5));
        System.out.println(new CountSubArrays().countSubarrays(new int[]{1,1,1,1}, 1, 1));
    }
}
