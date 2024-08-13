package com.training.leetcode;

import java.util.TreeMap;

public class MinXOROperationsEqualsToK {
    public int minOperations(int[] nums, int k) {

        int nums_xor = 0;
        for(int n : nums){
            nums_xor ^= n;
        }
        int final_xor = nums_xor ^ k;
        int flip_count = 0;
        while(final_xor > 0){
            flip_count += final_xor & 1;
            final_xor = final_xor >> 1;

        }

        return flip_count;
    }

    public static void main(String[] args) {
        System.out.println(new MinXOROperationsEqualsToK().minOperations(new int[]{2,1,3,4}, 1));
        TreeMap<Integer, Integer> map = new TreeMap();
        Integer num = map.higherKey(1);
    }
}
