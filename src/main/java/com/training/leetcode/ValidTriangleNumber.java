package com.training.leetcode;

import java.util.Arrays;

public class ValidTriangleNumber {

    /*
        Given an integer array nums, return the number of triplets chosen from the array that can make triangles if we take them as side lengths of a triangle.

        Side lengths of a triangle must satisfy:
        a < b < c and a + b > c
     */

    public int triangleNumber(int[] nums) {

        // Step 1: Sort Array to simply a < b < c criteria
        Arrays.sort(nums);

        // Step 2: for-each a at index i -> nums[i]
        //                  b at index j = i + 1 to n - 1 -> nums[j]
        //                  c at index i + 2 to n - 1 -> nums[k]
        // find elements that satisfy a + b > c
        // Since array is sorted once we can stop at right limit where c (nums[k]) > a (nums[i]) + b (nums[j]) any element
        // between j + 1 and k - 1 will satisfy a + b > c
        // i.e. (k - 1) - (j + 1) + 1 = k - j - 1

        int n = nums.length, count = 0;
        for(int i = 0; i < n - 2; i++) {

            int k = i + 2;
            for(int j = i + 1; j < n - 1 && nums[i] != 0; j++) {


                while( k < n  && nums[i] + nums[j] > nums[k]) {
                    k++;
                }
                count += k - j - 1;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(new ValidTriangleNumber().triangleNumber(new int[]{1,3,5,8,9,10,11,11,13,20}));
    }
}
