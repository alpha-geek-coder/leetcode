package com.training.leetcode;

/*
Given a binary array nums and an integer goal, return the number of non-empty subarrays with a sum goal.
A subarray is a contiguous part of the array.

Example 1:
Input: nums = [1,0,1,0,1], goal = 2
Output: 4
Explanation: The 4 subarrays are bolded and underlined below:
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]
Example 2:
Input: nums = [0,0,0,0,0], goal = 0
Output: 15
Constraints:
1 <= nums.length <= 3 * 104
nums[i] is either 0 or 1.
0 <= goal <= nums.length
 */
public class BinarySubarraysSum {
    public int numSubarraysWithSum(int[] nums, int goal) {

        int sum = 0, n = nums.length, ans = 0;
        int l = 0, r = 0, prefix_zeros = 0;
        while(r < n){
            sum += nums[r];
            while(l < r && (nums[l] == 0 || sum > goal)){
                if(nums[l] == 1) {
                    prefix_zeros = 0;
                } else {
                    prefix_zeros++;
                }
                sum -= nums[l++];
            }
            if(sum == goal){
                ans += 1 + prefix_zeros;
            }
            r++;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new BinarySubarraysSum().numSubarraysWithSum(new int[]{1,0,1,0,1}, 2));
        System.out.println(new BinarySubarraysSum().numSubarraysWithSum(new int[]{0,0,0,0,0}, 0));
    }
}
