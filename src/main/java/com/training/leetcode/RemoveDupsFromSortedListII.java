package com.training.leetcode;



public class RemoveDupsFromSortedListII {

    /*
    Given an integer array nums sorted in non-decreasing order, remove some duplicates in-place such that each unique element appears at most twice. The relative order of the elements should be kept the same.

    Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.

    Return k after placing the final result in the first k slots of nums.

    Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.

    Input: nums = [1,1,1,2,2,3]
    Output: 5, nums = [1,1,2,2,3,_]
    Explanation: Your function should return k = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.
    It does not matter what you leave beyond the returned k (hence they are underscores).
     */
    public int removeDuplicates(int[] nums) {

//        int i = 1;
//
//        for(int j = 1; j < nums.length; j++) {
//
//            if(nums[j - 1] != nums[j]){
//                if(j > i && nums[i] == nums[j - 1]) {
//                    nums[i++] = nums[j - 1];
//                }
//                nums[i++] = nums[j];
//
//            }
//        }

//        int i = 2;
//
//        for(int j = 2; j < nums.length; j++){
//            if(nums[j] != nums[i - 2]){
//                nums[i++] = nums[j];
//            }
//        }
        int i = 1; int count = 1;
        for(int j = 1; j < nums.length; j++) {

            if(nums[j - 1] != nums[j]){
                count = 1;
                nums[i++] = nums[j];
            } else if(count < 2){
                nums[i++] = nums[j];
                count++;
            }
        }

        for(int num : nums) {
            System.out.print(num + ",");
        }
        System.out.println("");
            return i;
    }

    public static void main(String[] args) {
        System.out.println(new RemoveDupsFromSortedListII().removeDuplicates(new int[]{0,0,1,1,1,1,2,3,3}));
    }
}
