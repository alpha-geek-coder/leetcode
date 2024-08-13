package com.training.leetcode;

import java.util.Arrays;

public class KradiusSubArray {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        int windowSize = 2 * k + 1;
        if(windowSize > n) return ans;

        long windowSum = 0;
        for(int i = 0; i < windowSize; ++i){
            windowSum += nums[i];
        }
        ans[k] = (int) (windowSum / windowSize);
        for(int i = windowSize; i < n; ++i){
            windowSum -= nums[i - windowSize];
            windowSum += nums[i];
            ans[i - k] = (int) (windowSum / windowSize);
        }


        return ans;
    }

    public static void main(String[] args) {
        int[] ans1 = new KradiusSubArray().getAverages(new int[]{7,4,3,9,1,8,5,2,6}, 3);
        display(ans1);
        int[] ans2 = new KradiusSubArray().getAverages(new int[]{1000}, 0);
        display(ans2);
    }

    public static void display(int[] nums){
        for(int n : nums){
            System.out.print(n + " ");
        }
        System.out.println("");
    }
}
