package com.training.leetcode;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubArraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
////        Map<String, Boolean> map = new HashMap();
////        return rec(nums, 0, k, 0, 0, map);
//
//        for(int i = 0; i < nums.length; i++){
//            int sum = nums[i];
//            for(int j = i + 1; j < nums.length; j++){
//                sum += nums[j];
//                if(sum % k == 0) return true;
//            }
//        }
//        return false;
//    }
//
//    public boolean rec(int[] nums, int i, int k, int currSum, int size, Map<String, Boolean> map){
//        if(currSum % k == 0 && size > 1){
//        //    System.out.println(i);
//            return true;
//        }
//        if(i == nums.length){
//            return false;
//        }
//        String key1 = i + "-" + currSum + "-" + size ;
//        if(map.containsKey(key1)) return map.get(key1);
//
//        boolean x = rec(nums, i + 1, k,currSum + nums[i], size + 1, map);
//        if(x) return true;
//        String key2 = (i + 1) + "-" + currSum  + "-" + (size + 1);
//        map.put(key2, x);
//        boolean y = rec(nums, i+ 1, k, 0, 0, map);
//
//        return x || y;
//    }

            Map<Integer, Integer> map = new HashMap();
            map.put(0,0);
            int sum = 0;

            for(int i = 0; i < nums.length; i++){
                sum += nums[i];
                int rem = sum % k;
                if(!map.containsKey(rem)){
                    map.put(rem, i + 1);
                } else if(map.get(rem) < i){
                    return true;
                }
            }
            return false;
    }

    public static void main(String[] args) {
        System.out.println(new ContinuousSubArraySum().checkSubarraySum(new int[]{1,2,3}, 5));
        System.out.println(new ContinuousSubArraySum().checkSubarraySum(new int[]{23,2,6,4,7}, 11));

        System.out.println(new ContinuousSubArraySum().checkSubarraySum(new int[]{405,504,203,96,43,50,214,327,120,345,33,314,377,62,431,379,114,208,106,345,391,513,9,405,452,186,295,33,423,122,355,311,192,429,320,360,85,96,32,258,407,71,436,370,365,199,443,521,262,232,355,241,250,10,258,324,335,446,474,385,74,101,111,162,349,149,51,399,371,139,199,264,118,155,134,518,388,113,520,441,384,449,14,104,267,92,477,50,505,368,466,519,105,443,31,21,485,146,115,94}, 337));
    }
}
