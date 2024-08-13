package com.training.leetcode;

public class SearchInRotatedArray {
    public int search(int[] nums, int target) {

        int leftIdx = 0, rightIdx = nums.length - 1;

//        if(nums[leftIdx] > nums[rightIdx]) {
//            while(nums[rightIdx] < nums[leftIdx]) {
//                rightIdx--;
//            }
//
//            if(target >= nums[leftIdx] && target <= nums[rightIdx]) {
//                return search(leftIdx, rightIdx, nums, target);
//            } else {
//                return search(rightIdx + 1, nums.length - 1, nums, target);
//            }
//        } else {
//            return search(leftIdx, rightIdx, nums, target);
//        }

        while(leftIdx <= rightIdx) {
            int pivotIdx = leftIdx + (rightIdx - leftIdx) / 2;

            if(nums[pivotIdx] == target) return pivotIdx;

            if(nums[leftIdx] <= nums[pivotIdx]) {
                if(nums[leftIdx] <= target && target <= nums[pivotIdx]) {
                    rightIdx = pivotIdx - 1;
                } else {
                    leftIdx = pivotIdx + 1;
                }
             } else if(nums[pivotIdx] <= target && target <= nums[rightIdx]) {
                    leftIdx = pivotIdx + 1;
                } else {
                    rightIdx = pivotIdx - 1;
                }
            }
        return -1;
    }

    public int search(int leftIdx, int rightIdx, int[] nums, int target) {

        while(leftIdx <= rightIdx) {
            int pivotIdx = leftIdx + (rightIdx - leftIdx) / 2;

            if(target < nums[pivotIdx]) {
                rightIdx = pivotIdx - 1;
            } else if(target > nums[pivotIdx]) {
                leftIdx = pivotIdx + 1;
            } else {
                return pivotIdx;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new SearchInRotatedArray().search(new int[] {3,1}, 1));
        int[] nums = new int[] {4,5,6,7,0,1,2};
        System.out.println(new SearchInRotatedArray().search(nums, 0));
        System.out.println(new SearchInRotatedArray().search(nums, 1));
        System.out.println(new SearchInRotatedArray().search(nums, 2));
        System.out.println(new SearchInRotatedArray().search(nums, 3));
        System.out.println(new SearchInRotatedArray().search(nums, 4));
        System.out.println(new SearchInRotatedArray().search(nums, 5));
        System.out.println(new SearchInRotatedArray().search(nums, 6));
        System.out.println(new SearchInRotatedArray().search(nums, 7));
        System.out.println(new SearchInRotatedArray().search(nums, 8));
        System.out.println(new SearchInRotatedArray().search(new int[] {0,1,2,4,5,6,7}, 0));
        System.out.println(new SearchInRotatedArray().search(new int[] {0,1,2,4,5,6,7}, 1));
        System.out.println(new SearchInRotatedArray().search(new int[] {0,1,2,4,5,6,7}, 2));
        System.out.println(new SearchInRotatedArray().search(new int[] {0,1,2,4,5,6,7}, 3));
        System.out.println(new SearchInRotatedArray().search(new int[] {0,1,2,4,5,6,7}, 4));
        System.out.println(new SearchInRotatedArray().search(new int[] {0,1,2,4,5,6,7}, 5));
        System.out.println(new SearchInRotatedArray().search(new int[] {0,1,2,4,5,6,7}, 6));
        System.out.println(new SearchInRotatedArray().search(new int[] {0,1,2,4,5,6,7}, 7));


    }
}
