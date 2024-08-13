package com.training.leetcode;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.HashSet;

public class KdiffPairs {
    /*
    Given an array of integers nums and an integer k, return the number of unique k-diff pairs in the array.

    A k-diff pair is an integer pair (nums[i], nums[j]), where the following are true:

    0 <= i, j < nums.length
    i != j
    nums[i] - nums[j] == k
    Notice that |val| denotes the absolute value of val.
     */

    public int findPairs(int[] nums, int k) {

        // Step 1 : Sort Array, since ouput is an input and not index specific
        Arrays.sort(nums);

        int n = nums.length;

        HashSet<Pair<Integer, Integer>> set = new HashSet();

        for(int i = 0; i < n - 1 ; i++) {
            // skip dup nums
            if(i > 0 && nums[i - 1] == nums[i]) continue;

            int otherIdx = binarySearch(nums, i + 1, nums[i] + k) ;

            if(nums[otherIdx] != nums[i] + k) continue;

            Pair<Integer, Integer> pair = new Pair(i, otherIdx);
            if(!set.contains(pair)) {
                set.add(pair);
            }
        }

        return set.size();
    }

    public int binarySearch(int[] nums, int leftIdx, int target) {

        int rightIdx = nums.length - 1;

        while(leftIdx < rightIdx) {

            int pivotIdx = leftIdx + (rightIdx - leftIdx) / 2;
            int pivot = nums[pivotIdx];

            if(pivot > target) {
                rightIdx = pivotIdx - 1;
            } else if(pivot < target) {
                leftIdx = pivotIdx + 1;
            } else {
                return pivotIdx;
            }
        }
        return leftIdx;
    }

    public static void main(String[] args) {
        System.out.println(new KdiffPairs().findPairs(new int[]{1,3,1,5,4}, 0));
    }
}
