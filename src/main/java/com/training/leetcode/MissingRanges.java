package com.training.leetcode;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {
    List<String> ans;
    public List<String> findMissingRanges(int[] nums, int lower, int upper){
        int n = nums.length;
        long low = (long) lower;
        long high = (long) upper;
        ans = new ArrayList<>();
        if(n == 0) {
            searchRange(low, high + 1);
            return ans;
        }
        searchRange(low - 1, nums[0]);
        for(int i = 1; i < n; i++){
            searchRange(nums[i - 1], nums[i]);
        }
        searchRange(nums[n - 1], high + 1);

        return ans;

    }
    public void searchRange(long start, long end ){

        if(start == end){
            return;
        } else if(start + 1 == end){
            return;
        } else if(start + 1 == end - 1){
            ans.add(String.valueOf(start + 1));
        } else {
            ans.add(String.valueOf(start + 1) + "->" + String.valueOf(end - 1));
        }
    }

    public static void main(String[] args) {
        System.out.println(new MissingRanges().findMissingRanges(new int[]{0,1,3,50,75}, 0 , 99));
    }
}
