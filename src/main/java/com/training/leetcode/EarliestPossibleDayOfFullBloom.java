package com.training.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EarliestPossibleDayOfFullBloom {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {

        List<Integer> indices = new ArrayList<>();
        for(int i = 0; i < growTime.length; i++){
            indices.add(i);
        }
      //  Collections.sort(indices, Comparator.comparing(i -> -growTime[i]));
        // Sort by growTime descending
        Collections.sort(indices, (i,j) -> Integer.compare(-growTime[i], -growTime[j]));

        int result = 0, currPlantTime = 0;

        for(int i = 0; i < growTime.length; i++){
            int idx = indices.get(i);
            int bloomTimeSoFar = currPlantTime + plantTime[idx] + growTime[idx];
            result = Math.max(result, bloomTimeSoFar);
            currPlantTime += plantTime[idx];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] plantTime1 = new int[]{1,4,3};
        int[] growTime1 = new int[]{2,3,1};
        System.out.println(new EarliestPossibleDayOfFullBloom().earliestFullBloom(plantTime1, growTime1));
    }

}
