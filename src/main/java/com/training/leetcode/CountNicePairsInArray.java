package com.training.leetcode;

import java.util.*;

public class CountNicePairsInArray {
    public int countNicePairs(int[] nums) {
        int mod = (int) 1e9 + 7;
        int ans = 0;
        int[] arr = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            arr[i] = nums[i] - rev(nums[i]);
        }

        Map<Integer, Integer> map = new HashMap();
        for(int num : arr){
            ans = (ans + map.getOrDefault(num, 0)) % mod;
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return ans;
    }
    public int rev(int n){
        int num = 0;
        while(n > 0){
            num = num * 10 + (n % 10);
            n /= 10;
        }

        return num;
    }

    public static void main(String[] args) {
        System.out.println(new CountNicePairsInArray().countNicePairs(new int[]{42, 11, 1, 97}));

    }
}
