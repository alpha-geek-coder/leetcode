package com.training.leetcode;

import java.util.ArrayList;
import java.util.List;

public class MaximumAverageSubArray {
    public double findMaxAverage(int[] nums, int k) {
        List<Boolean> set = new ArrayList<>();
        set.set(100, true);
        int sum = 0;
        for(int i = 0; i < k; i++){
            sum += nums[i];
        }
        double maxAvg = (double) sum / k;

        for(int i = k; i < nums.length; i++){
            sum -= nums[i - k];
            sum += nums[i];
            double avg = (double) sum / k;
            maxAvg = Math.max(avg, maxAvg);
        }
        return maxAvg;
    }

    public static void main(String[] args) {
        System.out.println(new MaximumAverageSubArray().findMaxAverage(new int[]{-1}, 1));
        System.out.println(new MaximumAverageSubArray().findMaxAverage(new int[]{1,12,-5,-6,50,3}, 4));
    }
}
