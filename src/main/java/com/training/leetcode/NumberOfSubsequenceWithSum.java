package com.training.leetcode;

import java.util.Arrays;

public class NumberOfSubsequenceWithSum {
    public int numSubseq(int[] nums, int target) {
        int ans = 0;
        Arrays.sort(nums);
        int mod = (int) Math.pow(10, 7);
        int n = nums.length;
        int[] power = new int[n];
        power[0] = 1;
        for(int i = 1; i < n; i++){
            power[i] = (power[i - 1] * 2) % mod;
        }
        int right = n - 1;
        for(int left = 0; left < n; left++){
            right = binarySearchRightMost(left, right, target - nums[left] - 1, nums);
            ans += power[right - left];
            ans %= mod;
        }

        return ans;
    }

    public int binarySearchRightMost(int left, int right, int target, int[] nums){
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] <= target){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    public static void main(String[] args) {
//        int[] nums1 = new int[]{3,4,5,5,9,10,12,14};
//        System.out.println(new NumberOfSubsequenceWithSum().numSubseq(nums1, 17));
//        int[] nums2 = new int[]{3,5,6,7};
//        System.out.println(new NumberOfSubsequenceWithSum().numSubseq(nums2, 9));
//        int[] nums3 = new int[]{3,3,6,8};
//        System.out.println(new NumberOfSubsequenceWithSum().numSubseq(nums3, 10));
        int[] nums4 = new int[]{2,3,3,4,6,7};
        System.out.println(new NumberOfSubsequenceWithSum().numSubseq(nums4, 12));
    }
}
