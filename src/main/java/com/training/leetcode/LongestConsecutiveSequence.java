package com.training.leetcode;


import java.util.HashSet;

public class LongestConsecutiveSequence {

    public static int longestConsecutive(int[] nums) {
        HashSet set = new HashSet();
        for(int i : nums){
            set.add(i);
        }
        int max = 0;
        for(int i : nums){
            if(!set.contains(i-1)){
                int count = i;
                while(set.contains(count)){
                    count++;
                }
                max = Math.max(count - i, max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
//        System.out.println(longestConsecutive(new int[] {100, 4, 200, 1, 3, 2}));

        System.out.println(longestConsecutive(new int[] {0,3,7,2,5,8,4,6,0,1}));
    }
}
