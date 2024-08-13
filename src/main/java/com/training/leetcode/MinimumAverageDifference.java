package com.training.leetcode;

public class MinimumAverageDifference {
    public int minimumAverageDifference(int[] nums) {

        int n = nums.length;
        int[] prefixSum = new int[n];
        prefixSum[0] = nums[0];
        for(int i = 1; i < n; i++){
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }

        int min = Integer.MAX_VALUE, idx = -1;
        for(int i = 0; i < n; i++){
            int leftAvg = prefixSum[i] / (i + 1);
            int rightAvg = (n - i - 1) == 0 ? 0 : (prefixSum[n - 1] - prefixSum[i]) / (n - i - 1);
            int diff = Math.abs(leftAvg - rightAvg);
            if(diff < min){
                min = diff;
                idx = i;
            }
        }

        return idx;
    }

    public static void main(String[] args) {
        System.out.println(new MinimumAverageDifference().minimumAverageDifference(new int[]{2,5,3,9,5,3}));
    }
}
