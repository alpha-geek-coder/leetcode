package com.training.leetcode;



public class SumOfSubarrayMinimums {
    public int sumSubarrayMins(int[] arr) {
        int MOD = 1000000007;
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            int min = arr[i];
            for(int j = i; j < arr.length; j++){
                min = Math.min(min, arr[j]) % MOD;
                sum += min;
                sum %= MOD;
            }

        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new SumOfSubarrayMinimums().sumSubarrayMins(new int[]{3,1,2,4}));
        System.out.println(new SumOfSubarrayMinimums().sumSubarrayMins(new int[]{11,81,94,43,3}));
        System.out.println(new SumOfSubarrayMinimums().sumSubarrayMins(new int[]{5,7,3,2,5}));
    }
}
