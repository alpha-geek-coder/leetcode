package com.training.leetcode;

public class MergeSort {
    int[] arr;
    public int[] sortArray(int[] nums){
        arr = nums;
        mergeSort(0, nums.length - 1);
        return nums;
    }

    public void mergeSort( int l, int r){
        if(l >= r) return;
        int mid = l + (r - l) / 2;
        mergeSort(l, mid);
        mergeSort(mid + 1, r);
        merge(l, mid, r);
    }
    public void merge(int l, int mid, int r){
        int[] left = new int[mid - l + 1];
        int[] right = new int[r - mid];
        for(int i = 0; i < left.length; i++){
            left[i] = arr[l + i];
        }
        for(int j = 0; j <= right.length; j++){
            right[j] = arr[mid + 1 + j];
        }
        int i = 0, j = 0;
        int idx = l;
        while(i < left.length && j < right.length){
            if(left[i] < right[j]){
                arr[idx++] = left[i++];
            } else {
                arr[idx++] = right[j++];
            }
        }
        while(i < left.length) arr[idx++] = left[i++];
        while(i < right.length) arr[idx++] = left[j++];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{38, 27, 43, 3, 9, 82, 10};
        int[] ans = new MergeSort().sortArray(nums);
        for(int num : ans){
            System.out.print(num + ",");
        }
    }

}
