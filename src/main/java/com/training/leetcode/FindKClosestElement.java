package com.training.leetcode;

import java.util.ArrayList;
import java.util.List;

public class FindKClosestElement {

    /*
    Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. The result should also be sorted in ascending order.

    An integer a is closer to x than an integer b if:

    |a - x| < |b - x|, or
    |a - x| == |b - x| and a < b
     */

    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        /*
        // Approach 1 : Using Priority Queue
        {<Integer> minHeap = new {<Integer>();

        for(int num : arr) {
            // add first k elements to min heap
            if(k > 0) {
                minHeap.add(num);
                k--;
                // if k reached, check if |smallest element - x| > |current element - x|
                // this condition is opposite of |smallest element - x| <= |current element - x|
            } else if(Math.abs(minHeap.peek() - x) > Math.abs(num - x)) {
                minHeap.poll();
                minHeap.add(num);
            }
        }
        List<Integer> result = new ArrayList<Integer>();
        while(!minHeap.isEmpty()) {
            result.add(minHeap.poll());
        }

        return result;

        */

        // Approach 2 : Using Binary Search

        int left = 0, right = arr.length - k;

        while(left < right) {

            int pivotIdx = left + (right - left) / 2;

            if(x <= arr[pivotIdx]) {
                right = pivotIdx;
            } else if(arr[pivotIdx + k] <= x){
                left = pivotIdx + 1;
            } else {

                if(Math.abs(arr[pivotIdx] - x) <= Math.abs(arr[pivotIdx + k] - x)){
                    right = pivotIdx;
                } else {
                    left = pivotIdx + 1;
                }
            }
        }

        List<Integer> result = new ArrayList<Integer>();

        for(int i = left; i < left + k; i++) {
            result.add(arr[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new FindKClosestElement().findClosestElements(new int[]{-2,1,2,3,4,5,7}, 4, 6));
    }
}
