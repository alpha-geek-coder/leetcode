package com.training.leetcode;

import java.util.Arrays;
import java.util.Stack;

public class SumofTotalStrength {
    int MOD = 1000000007;
    public int totalStrength(int[] strength) {

        int n = strength.length;
        long[] incl_prefix_sum = new long[n + 1];
        incl_prefix_sum[0] = 0;
        long sum = 0;
        for(int i = 1; i <= n; i++){
            sum += strength[i - 1];
            sum %= MOD;
            incl_prefix_sum[i] = (incl_prefix_sum[i - 1] + sum) % MOD;
        }

        int[] left = new int[n];
        Arrays.fill(left, -1);
        Stack<Integer> stack = new Stack();
        for(int i = n - 1; i >= 0; i--){
            while(!stack.isEmpty() && strength[stack.peek()] >= strength[i]){
                left[stack.pop()] = i;
            }
            stack.push(i);
        }

        int[] right = new int[n];
        Arrays.fill(right, n);
        stack = new Stack();
        for(int i = 0; i < n; i++){
            while(!stack.isEmpty() && strength[stack.peek()] > strength[i]){
                right[stack.pop()] = i;
            }

            stack.push(i);
        }
        long ans = 0;
        for(int i = 0; i < n; i++){
            int l = left[i];
            int r = right[i];
            long total = (i - l) * (incl_prefix_sum[r - 1 + 1] - incl_prefix_sum[i - 1 + 1]) % MOD + MOD -
                    (r - i) * (incl_prefix_sum[i - 1 + 1] - incl_prefix_sum[l - 1 + 1 < 0 ? 0 : l - 1 + 1]) % MOD;
            total = (total * strength[i]) % MOD;
            ans = (ans + total) % MOD;
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        System.out.println(new SumofTotalStrength().totalStrength(new int[]{2,4,5,6,3,6,4,1,5,7}));
    }
}
