package com.training.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionOfTwoArrays {
    public int[] intersect(int[] nums1, int[] nums2) {

        if(nums1.length < nums2.length) return intersect(nums2, nums1);

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0, j = 0;

        int m = nums1.length, n = nums2.length;

        List<Integer> list = new ArrayList();
        int start = 0, end = nums1.length - 1;
        while(i < n) {
            int target = nums2[i];
            int idx = binarySearch(start, end, nums1, target);
            if(idx != -1) {
                list.add(i);
                start = idx + 1;
            }
            i++;
        }

        int[] result = new int[list.size()];
        int idx = 0;

        for(int index : list) {
            result[idx++] = nums2[index];
        }
        return result;
    }

    public int binarySearch(int start, int end, int[] array, int target) {

        int idx = -1;
        while(start <= end){
            int pivot = start + (end - start) / 2;
            if(array[pivot] == target) {
                idx = pivot;
                end = pivot - 1;
            } else if(array[pivot] < target){
                start = pivot + 1;
            } else {
                end = pivot - 1;
            }
        }

        return idx;
    }

    public static void main(String[] args) {
        System.out.println(new IntersectionOfTwoArrays().intersect(new int[] {1,2,2,1}, new int[]{2,2}));
    }
}
