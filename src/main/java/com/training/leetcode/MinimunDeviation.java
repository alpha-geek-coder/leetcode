package com.training.leetcode;

import java.util.Collections;
import java.util.PriorityQueue;

public class MinimunDeviation {
    public int minimumDeviation(int[] nums){
        int n = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(n, Collections.reverseOrder());

        int minValue = Integer.MAX_VALUE, minDeviation = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            int num = nums[i];
            if(num % 2 == 1) num *= 2;
            pq.add(num);
            minValue = Math.min(minValue, num);
        }

        while(!pq.isEmpty()){
            int maxValue = pq.poll();
            minDeviation = Math.min(minDeviation, maxValue - minValue);
            if(maxValue % 2 == 1) break; // exhausted all divide by 2 operations
            maxValue /= 2; // divide
            minValue = Math.min(minValue, maxValue);

            pq.add(maxValue);
        }
        return minDeviation;
    }

    public static void main(String[] args) {
        System.out.println(new MinimunDeviation().minimumDeviation(new int[]{1,2,3,4}));
    }
}
