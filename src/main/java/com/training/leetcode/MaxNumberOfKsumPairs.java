package com.training.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MaxNumberOfKsumPairs {

    /*
    You are given an integer array nums and an integer k.
    In one operation, you can pick two numbers from the array whose sum equals k and remove them from the array.
    Return the maximum number of operations you can perform on the array.

    Example 1:
    Input: nums = [1,2,3,4], k = 5
    Output: 2
    Explanation: Starting with nums = [1,2,3,4]:
    - Remove numbers 1 and 4, then nums = [2,3]
    - Remove numbers 2 and 3, then nums = []
    There are no more pairs that sum up to 5, hence a total of 2 operations.

    Example 2:
    Input: nums = [3,1,3,4,3], k = 6
    Output: 1
    Explanation: Starting with nums = [3,1,3,4,3]:
    - Remove the first two 3's, then nums = [1,4,3]
    There are no more pairs that sum up to 6, hence a total of 1 operation.
     */
    public int maxOperations(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap();
        int max = 0;
        for(int num : nums) {
            if(map.containsKey(k - num) && map.get(k - num) > 0) {
                max++;
                map.put(k - num, map.get(k - num) - 1);
            } else {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

        }


        return max;
    }

    public static void main(String[] args) {
        System.out.println(new MaxNumberOfKsumPairs().maxOperations(new int[]{3,1,3,4,3}, 5));
    }
}
