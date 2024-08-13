package com.training.leetcode;

public class CapacityToShipPackagesInNDays {
    public int shipWithinDays(int[] weights, int days) {
        int maxWeight = 0, totalWeight = 0;
        for(int weight : weights){
            totalWeight += weight;
            maxWeight = Math.max(maxWeight, weight);
        }
        // Binary search
        int l = maxWeight, r = totalWeight;
        while(l < r){
            int mid = l + (r - l) / 2;
            int daysNeeded = 1, currLoad = 0;
            for(int weight : weights){
                currLoad += weight;
                if(currLoad > mid){
                    daysNeeded++;
                    currLoad = weight;
                }
            }
            if(daysNeeded > days){
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return l;
    }

}
