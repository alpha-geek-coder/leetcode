package com.training.leetcode;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap();
        map.put(0, 1);

        int sum = 0, count = 0;
        for(int num : nums){
            sum += num;
            if(map.containsKey(sum - k)){

                count += map.get(sum - k);
            }
            map.put(sum - k, map.getOrDefault(sum , 0) + 1);

        }

        return count;

    }

    public static void main(String[] args) {
        System.out.println(new SubarraySumEqualsK().subarraySum(new int[]{1,-1,0}, 0));
    }
}
