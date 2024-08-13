package com.training.leetcode;

import java.util.Arrays;

public class ProductofArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, 1);
        for(int i = 1; i < n; i++){
            ans[i] = ans[i - 1] * nums[i - 1];
        }
        int running_prod = nums[n - 1];
        for(int i = n - 2; i >= 0; i--){
            ans[i] = running_prod * ans[i];
            running_prod *= nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new ProductofArrayExceptSelf().productExceptSelf(new int[]{1,2,3,4}));
        System.out.println(new ProductofArrayExceptSelf().productExceptSelf(new int[]{-1,1,0,-3,3}));
    }
}
