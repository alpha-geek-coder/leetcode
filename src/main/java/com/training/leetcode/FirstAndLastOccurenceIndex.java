package com.training.leetcode;



public class FirstAndLastOccurenceIndex {
    public int[] searchRange(int[] nums, int target) {
        int first_idx = binarySearch(nums, target, 0);
        int last_idx = binarySearch(nums, target, 1);

        return new int[]{first_idx, last_idx};
    }

    public int binarySearch(int[] nums, int target, int pos){
        int l = 0, r = nums.length - 1, target_idx = -1;
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(nums[mid] < target){
                l = mid + 1;
            } else if(nums[mid] > target){
                r = mid - 1;
            } else {
                target_idx = mid;
                if(pos == 0){
                    // find first occurence, scan in left space
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }

        return target_idx;
    }


    public static void main(String[] args) {
        int[] ans = new FirstAndLastOccurenceIndex().searchRange(new int[]{5,7,7,8,8,10}, 8);
        System.out.println(ans[0] + "," + ans[1]);
    }
}
