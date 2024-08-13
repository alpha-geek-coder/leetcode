package com.training.leetcode;

public class CountSubarrayScoreLessThanK {
    public long countSubarrays(int[] nums, long k) {
        int n = nums.length;
        long sum = 0;
        long ans = 0;
        int start = 0;
        for(int end = 0; end < n; end++){
            sum += nums[end];
            long prod = sum * (end - start + 1);

            while(prod >= k && start < end){
                sum -= nums[start++];
                prod = sum * (end - start + 1);
            }
            if(prod < k){
                ans += end - start + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new CountSubarrayScoreLessThanK().countSubarrays(new int[]{2,1,4,3,5}, 10));
    }
}
