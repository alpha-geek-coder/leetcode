package com.training.leetcode;

public class MinimumSwapsToGroupAllOnes {
    public int minSwaps(int[] nums) {
        // Calculate the minimum swaps needed to group all 1s or all 0s together
        int op1 = minSwapsHelper(nums, 0); // Grouping all 0s together
        int op2 = minSwapsHelper(nums, 1); // Grouping all 1s together
        return Math.min(op1, op2);
    }

    // Helper function to calculate the minimum swaps required to group all `val` together
    public int minSwapsHelper(int[] data, int val) {
        int length = data.length;
        int[] rightSuffixSum = new int[length + 1];

        // Construct the suffix sum array for counting opposite values (val ^ 1)
        for (int i = length - 1; i >= 0; i--) {
            rightSuffixSum[i] = rightSuffixSum[i + 1];
            if (data[i] == (val ^ 1)) rightSuffixSum[i]++;
        }
        // Total zeros in the array if `val` is 1 (or vice versa)
        int totalSwapsNeeded = rightSuffixSum[0];
        // Track current number of required swaps in the current segment
        int currentSwapCount = 0;
        int minimumSwaps =
            totalSwapsNeeded - rightSuffixSum[length - totalSwapsNeeded];

        // Iterate to find the minimum swaps by sliding the potential block of grouped `val`
        for (int i = 0; i < totalSwapsNeeded; i++) {
            if (data[i] == (val ^ 1)) currentSwapCount++;
            int remaining = (totalSwapsNeeded - i - 1);
            int requiredSwaps =
                ((i + 1) - currentSwapCount) +
                (remaining - rightSuffixSum[length - remaining]);
            minimumSwaps = Math.min(minimumSwaps, requiredSwaps);
        }
        return minimumSwaps;
    }

    public int minSwaps2(int[] nums) {
        int n = nums.length;
        int window_size = 0; // = no. of 1s in nums
        int[] nums2 = new int[n * 2];
        for(int i = 0; i < n; i++){
            window_size += nums[i];
            nums2[i] = nums[i];
            nums2[n + i] = nums[i];
        }
        int ans = Integer.MAX_VALUE;
        for(int l = 0, r = 0, total_ones = 0; r < nums2.length; r++ ){
            if(nums2[r] == 1) total_ones++;
            if(r - l + 1 == window_size){
                ans = Math.min(ans, window_size - total_ones);
                if(nums2[l] == 1){
                    total_ones--;
                }
                l++;
            }
        }
        
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public static void main(String[] args) {
        System.out.println(new MinimumSwapsToGroupAllOnes().minSwaps2(new int[]{1,1,0,0,1}));
    }
    
}
