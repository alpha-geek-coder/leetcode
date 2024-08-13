package com.training.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MinOperationsToMakeArrayContinuous {
    public int minOperations(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet();
        for(int num : nums) set.add(num);
        int[] new_nums = new int[set.size()];
        int idx = 0;
        for(int num : set) {
            new_nums[idx++] = num;
        }
        Arrays.sort(new_nums);
        int min_operations = n;
        for(int i = 0; i < new_nums.length; i++){
            int left = new_nums[i];
            int right = left + n - 1;
            int j = binarySearch(new_nums, right);
            int count = j - i;
            min_operations = Math.min(min_operations, n - count);
        }
        return min_operations;
    }
    public int binarySearch(int[] new_nums, int target){
        int l = 0, r = new_nums.length - 1;

        while(l < r){
            int mid = l + (r - l) / 2;
            if(new_nums[mid] < target){
                l = mid + 1;
            } else {
                r = mid;
            }
            // if(target < new_nums[mid]){
            //     r = mid;
            // } else {
            //     l = mid + 1;
            // }
        }
        return l < new_nums.length && new_nums[l] == target ? l + 1 : l;
    }

    public static void main(String[] args) {
        System.out.println(new MinOperationsToMakeArrayContinuous().minOperations(new int[]{4,2,5,3}));
    }
}
