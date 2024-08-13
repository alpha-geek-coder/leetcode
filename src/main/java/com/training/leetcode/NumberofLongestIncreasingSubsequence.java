package com.training.leetcode;

public class NumberofLongestIncreasingSubsequence {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] length = new int[n];
        int[] count = new int[n];

        for(int i = 0; i < n; i++){
            length[i] = 1;
            count[i] = 1;
        }

        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]){
                    if(length[j] + 1 > length[i]){
                        length[i] = length[j] + 1;
                        count[i] = 0;
                    }
                    if(length[j] + 1 == length[i]){
                        count[i] += count[j];
                    }
                }
            }
        }

        int maxLength = 0;
        int ans = 0;

        for(int len : length){
            maxLength = Math.max(maxLength, len);
        }

        for(int i = 0; i < n; i++){
            if(length[i] == maxLength) ans += count[i];
        }


        return ans;

    }

    public static void main(String[] args) {
        System.out.println(new NumberofLongestIncreasingSubsequence().findNumberOfLIS(new int[]{1,3,5,4,7}));
    }
}
