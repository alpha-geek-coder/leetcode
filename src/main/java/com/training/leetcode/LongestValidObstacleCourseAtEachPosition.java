package com.training.leetcode;

public class LongestValidObstacleCourseAtEachPosition {
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int n = obstacles.length;
        int[] ans = new int[n];
        int[] longestIncreasingSubSequenceLength = new int[n];
        int longestLength = 0;
        for(int i = 0; i < n; i++){
            int height = obstacles[i];
            int idx = binarySearchRightMostIdx(longestIncreasingSubSequenceLength, height, longestLength);
            if(idx == longestLength){
                longestLength++;
            }
            longestIncreasingSubSequenceLength[idx] = height;
            ans[i] = idx + 1;
        }

        return ans;
    }

    public int binarySearchRightMostIdx(int[] longestIncreasingSubSequenceLength, int target, int right){

        if(right == 0) return right;

        int left = 0;

        while(left < right){
            int mid = left + (right - left) / 2;
            if(longestIncreasingSubSequenceLength[mid] <= target){
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;

    }

    public static void main(String[] args) {
        int[] ans1 = new LongestValidObstacleCourseAtEachPosition().longestObstacleCourseAtEachPosition(new int[]{1,4,5,2,3});

        for(int ans : ans1){
            System.out.print(ans + " ");
        }
        System.out.println();

        int[] ans2 = new LongestValidObstacleCourseAtEachPosition().longestObstacleCourseAtEachPosition(new int[]{3,1,5,6,4,2});

        for(int ans : ans2){
            System.out.print(ans + " ");
        }
        System.out.println();
    }
}
