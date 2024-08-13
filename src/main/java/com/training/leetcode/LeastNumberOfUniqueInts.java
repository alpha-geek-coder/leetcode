package com.training.leetcode;

import java.util.*;

public class LeastNumberOfUniqueInts {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> freq = new HashMap();
        for(int num : arr){
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        List<Integer> list = new ArrayList(freq.values());

        Collections.sort(list);
        int idx = 0;
        while(k > 0 && idx < list.size()){
            if(list.get(idx) <= k){
                k -= list.get(idx);
                idx++;
            } else {
                break;
            }
        }
        return list.size() - idx;
    }

    public static void main(String[] args) {
        System.out.println(new LeastNumberOfUniqueInts().findLeastNumOfUniqueInts(new int[]{5,5,4}, 1));
        System.out.println(new LeastNumberOfUniqueInts().findLeastNumOfUniqueInts(new int[]{4,3,1,1,3,3,4}, 3));
    }
}
