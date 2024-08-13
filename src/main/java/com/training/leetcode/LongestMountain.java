package com.training.leetcode;

public class LongestMountain {

    public int longestMountain(int[] arr) {


        int mountainLength = 0, longestLength = 0, n = arr.length;

        for(int i = 1; i < n - 1; i++) {

            // Step 1: Find peak i.e. arr[i - 1] < arr[i] > arr[i + 1]

            int left = arr[i - 1], curr = arr[i], right = arr[ i + 1];

            if(left < curr && curr > right) {
                // find valley on the left side of the peak
                int leftIdx = i - 2;
                while(leftIdx >= 0 && arr[leftIdx] < arr[leftIdx + 1]) {
                    leftIdx--;
                }
                // find valley on the right side of the peak
                int rightIdx = i + 2;
                while(rightIdx < n && arr[rightIdx - 1] > arr[rightIdx]) {
                    rightIdx++;
                }

                mountainLength = rightIdx - leftIdx - 1;

                longestLength = Math.max(longestLength, mountainLength);
            }

        }

        return longestLength;
    }
}
