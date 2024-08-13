package com.training.leetcode;

public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int l = 0 , r = (m * n) - 1;
        while(l <= r){
            int mid = l + (r - l) / 2;
            int row = mid / n, col = mid % n;
            if(matrix[row][col] == target){
                return true;
            } else if(target < matrix[row][col] ){
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return false;
    }
    public int search(int[] nums, int target){
        int n = nums.length, l = 0, r = nums.length - 1;

        while(l <= r){
            int mid = l + (r - l) / 2;
            if(nums[mid] == target) return mid;
            if(nums[l] <= nums[mid]){
                if(nums[l] <= target && nums[mid] > target){
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }else if(nums[mid] <= target && nums[r] >= target) {
                l = mid + 1;
            }else {
                r = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new SearchMatrix().searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 3));
        //System.out.println(new SearchMatrix().search(new int[]{4,5,6,7,0,1,2}, 0));
        System.out.println(new SearchMatrix().search(new int[]{1,0,1,1,1}, 0));

    }
}
