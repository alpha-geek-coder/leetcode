package com.training.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IncreasingSubsequence {
    Set<List<Integer>> set;
    int count;
    public List<List<Integer>> findSubsequences(int[] nums) {
        set = new HashSet();
        backtrack(nums, 0, new ArrayList());
        System.out.println(count);
        return new ArrayList<>(set);
    }

    public void backtrack(int[] nums, int idx, List<Integer> list){
        count++;
        if(list.size() >= 2){
            set.add(new ArrayList(list));
        }
        for(int i = idx; i < nums.length; i++){
            if(list.size() == 0 || (list.size() > 0 && list.get(list.size() - 1) <= nums[i])){
                list.add(nums[i]);
                backtrack(nums, i + 1, list);
                list.remove(list.size() - 1);
            }
        }

    }

    public static void main(String[] args) {
        System.out.println(new IncreasingSubsequence().findSubsequences(new int[] {4,6,7,7}));
        System.out.println(new IncreasingSubsequence().findSubsequences(new int[] {1,5,2,4,8,5,4,7,9}));
    }
}
