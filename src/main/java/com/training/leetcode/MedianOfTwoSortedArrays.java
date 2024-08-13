package com.training.leetcode;

public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        if(m > n) return findMedianSortedArrays(nums2, nums1);

        int l = 0, r = m;
        while(l <= r){
            int a_mid = (l + r) / 2;
            int b_mid = ((m + n + 1) / 2) - a_mid;

            int a_left_max = a_mid == 0 ? Integer.MIN_VALUE : nums1[a_mid - 1];
            int a_right_min = a_mid == m ? Integer.MAX_VALUE : nums1[a_mid];

            int b_left_max = b_mid == 0 ? Integer.MIN_VALUE : nums2[b_mid - 1];
            int b_right_min = b_mid == n ? Integer.MAX_VALUE : nums2[b_mid];

            if(a_left_max <= b_right_min && b_left_max <= a_right_min){
                if( (m + n) % 2 == 0){
                    return (double) (Math.max(a_left_max, b_left_max) +
                            Math.min(a_right_min, b_right_min)) / 2;
                } else {
                    return (double) Math.max(a_left_max, b_left_max);
                }
            } else if(a_left_max > b_right_min){
                r = a_mid - 1;
            } else {
                l = a_mid + 1;
            }
        }

        return 0.0;
    }

    public static void main(String[] args) {
       // System.out.println(new MedianOfTwoSortedArrays().findMedianSortedArrays(new int[]{1,3}, new int[]{2}));
        System.out.println(new MedianOfTwoSortedArrays().findMedianSortedArrays(new int[]{1,2}, new int[]{3,4}));
    }
}
