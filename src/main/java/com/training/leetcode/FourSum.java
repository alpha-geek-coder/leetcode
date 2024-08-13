package com.training.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {

        Arrays.sort(nums);

        int k = 4; // because we want 4 sum
        int targetK = target; // target for k = 4

        return kSum(nums, 0, k, targetK);

    }

    public List<List<Integer>> kSum(int[] nums, int startIdx, int k, long targetK) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();

        // if we run out of numbers in array
        if(startIdx == nums.length) {
            return result;
        }

        // There are k remaining values to add to result.
        // The average of each of these values is at least target / 4
        long average_value = targetK / k;

        // We cannot obtain sum of target if the smallest value in nums
        // is greater than targetK / k or if the largest value in nums
        // is smaller than targetK / k
        if(nums[startIdx] > average_value || average_value > nums[nums.length - 1]) {
            return result;
        }

        if(k == 2){
            return twoSum(nums, startIdx, k, targetK);
        }

        for(int i = startIdx; i < nums.length; i++) {

            if(i == startIdx || nums[i - 1] != nums[i]){
                for(List<Integer> subset : kSum(nums, i + 1, k - 1, targetK - nums[i] )){
                    result.add(new ArrayList(Arrays.asList(nums[i])));
                    result.get(result.size() - 1).addAll(subset);
                }
            }
        }

        return result;
    }

    public List<List<Integer>> twoSum(int[] nums, int startIdx, int k , long targetK) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int left = startIdx, right = nums.length - 1;

        while(left < right) {
            int currSum = nums[left] + nums[right];

            if(currSum < targetK || (left > startIdx && nums[left] == nums[left - 1])){
                left++;
            } else if(currSum > targetK || (right < nums.length - 1 && nums[right] == nums[right + 1])){
                right--;
            } else {
                result.add(Arrays.asList(nums[left++], nums[right--]));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new FourSum().fourSum(new int[] {1,0,-1,0,-2,2}, 0));
    }
}
