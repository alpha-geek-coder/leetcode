package com.training.leetcode;

public class CountRangeOfSum {
    int[] arr;
    long[] prefixSum;
    int lower;
    int upper;
    int count = 0;

    public int countRangeSum(int[] nums, int lower, int upper) {
        arr = nums;
        int n = nums.length;
        prefixSum = new long[n + 1];
        this.lower = lower;
        this.upper = upper;
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = nums[i] + prefixSum[i];
        }
        mergeSort(0, n);
        return count;
    }

    public void mergeSort(int l, int r) {
        if (l >= r) return;
        int mid = l + (r - l) / 2;
        mergeSort(l, mid);
        mergeSort(mid + 1, r);
        int i = mid + 1, j = mid + 1;
        for (int k = l; k <= mid; k++) {
            while (i <= r && prefixSum[i] - prefixSum[k] < lower) i++;
            while (j <= r && prefixSum[j] - prefixSum[k] <= upper) j++;

            count += j - i;
        }
        merge(l, mid, r);
    }

    public void merge(int l, int mid, int r) {
            long[] left = new long[mid - l + 1];
            long[] right = new long[r - mid];
            for(int i = 0; i < left.length; i++){
                left[i] = prefixSum[l + i];
            }
            for(int j = 0; j < right.length; j++){
                right[j] = prefixSum[mid + 1 + j];
            }
            int i = 0, j = 0;
            int idx = l;
            while(i < left.length && j < right.length){
                if(left[i] < right[j]){
                    prefixSum[idx++] = left[i++];
                } else {
                    prefixSum[idx++] = right[j++];
                }
            }
            while(i < left.length) prefixSum[idx++] = left[i++];
            while(i < right.length) prefixSum[idx++] = left[j++];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 5, -1};
        int ans = new CountRangeOfSum().countRangeSum(nums, -2, 2);
        System.out.println(ans);
    }

}
