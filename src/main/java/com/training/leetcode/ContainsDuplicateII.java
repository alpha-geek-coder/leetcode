package com.training.leetcode;

import java.util.HashSet;

public class ContainsDuplicateII {

    /*
    Given an integer array nums and an integer k, return true if
    there are two distinct indices i and j in the array such that
    nums[i] == nums[j] and abs(i - j) <= k.
     */

    public boolean containsNearbyDuplicate(int[] nums, int k) {

//         Map<Integer, Integer> map = new HashMap();

//         for(int i = 0; i < nums.length; i++){
//             if(map.containsKey(nums[i])){
//                 if(Math.abs(map.get(nums[i]) - i) <= k) return true;
//             }
//             map.put(nums[i], i);

//         }
//         return false;

        if (nums.length <= 1 || k == 0) {
            return false;
        }

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                set.remove(nums[i - k - 1]);
            }
            if (!set.add(nums[i])) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(new ContainsDuplicateII().containsNearbyDuplicate(new int[]{1,2,3,1}, 3));
        System.out.println(new ContainsDuplicateII().containsNearbyDuplicate(new int[]{1,0,1,1}, 1));
        System.out.println(new ContainsDuplicateII().containsNearbyDuplicate(new int[]{1,2,3,1,2,3}, 2));

    }
}
