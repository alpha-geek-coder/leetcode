package com.training.leetcode;

import java.util.Arrays;


class SortArray{

    public int[] sort(int[] nums){
        
        return mergeSort(nums);
    }

    public int[] mergeSort(int[] nums){

        int n = nums.length;
        if(n == 0) return new int[0];
        if(n == 1) return nums;

        int[] left = Arrays.copyOfRange(nums, 0, n / 2);
        int[] right = Arrays.copyOfRange(nums, (n / 2), n);

        left = mergeSort(left);
        right = mergeSort(right);

        int[] sorted_array = new int[n];
        int idx = 0, l = 0, r = 0;

        while(l < left.length && r < right.length){
            if(left[l] <= right[r]){
                sorted_array[idx++] = left[l++];
            } else{
                sorted_array[idx++] = right[r++];
            }
        }
        while(l < left.length){
            sorted_array[idx++] = left[l++];
        }
        while(r < right.length){
            sorted_array[idx++] = right[r++];
        }

        return sorted_array;

    }

    public static void main(String[] args) {
        int[] ans = new SortArray().sort(new int[]{5,2,3,1,4});
        for(int n : ans) System.out.print(n + ",");
    }
}