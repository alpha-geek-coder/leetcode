package com.training.leetcode;

import java.util.Arrays;

public class MinimumArrowsShot {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int total = 1;
        int prevStart = points[0][0];
        int prevEnd = points[0][1];
        for(int i = 1; i < points.length; i++) {
            int currStart = points[i][0];
            int currEnd = points[i][1];
            if(currStart > prevEnd){
                total++;
                prevStart = currStart;
                prevEnd = currEnd;
            } else {
                prevStart = Math.min(prevStart, currStart);
                prevEnd = Math.min(prevEnd, currEnd);
            }
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(new MinimumArrowsShot().findMinArrowShots(new int[][] {{10,16},{2,8},{1,6},{7,12}}));
        System.out.println(new MinimumArrowsShot().findMinArrowShots(new int[][] {{1,2},{3,4},{5,6},{7,8}}));
        System.out.println(new MinimumArrowsShot().findMinArrowShots(new int[][] {{1,2},{2,3},{3,4},{4,5}}));

        int[] nums = new int[]{6,5,4,4};
        int increasing = 0;
        int decreasing = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i - 1] <= nums[i]){
                increasing++;
            }
            if(nums[i - 1] >= nums[i]){
                decreasing++;
            }
        }

        if(increasing == nums.length - 1){
            System.out.println(true);
        } else if(decreasing == nums.length - 1){
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }
}
