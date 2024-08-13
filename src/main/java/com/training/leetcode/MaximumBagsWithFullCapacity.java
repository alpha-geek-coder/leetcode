package com.training.leetcode;

import java.util.Arrays;

public class MaximumBagsWithFullCapacity {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int[] remainingCapacity = new int[capacity.length];
        for(int i = 0; i < capacity.length; i++){
            remainingCapacity[i] = capacity[i] - rocks[i];
        }
        Arrays.sort(remainingCapacity);
        int fullBags = 0;
        for(int i = 0; i < capacity.length ; i++){
            int requiredRocks = remainingCapacity[i];

            if(additionalRocks >= requiredRocks){
                fullBags++;
                additionalRocks -= requiredRocks;
            } else {
                break;
            }
        }
        return fullBags;
    }

    public static void main(String[] args) {
        System.out.println(new MaximumBagsWithFullCapacity().maximumBags(new int[]{2,3,4,5}, new int[]{1,2,4,4}, 2));
    }
}
