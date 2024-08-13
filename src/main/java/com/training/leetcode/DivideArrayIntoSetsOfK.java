package com.training.leetcode;

import java.util.*;

public class DivideArrayIntoSetsOfK {
    public boolean isPossibleDivide(int[] nums, int k) {
//        Map<Integer, Integer> freq = new HashMap();
//        Arrays.sort(nums);
//        int n = nums.length;
//        int num = nums[0], i = 0;
//        while(i < n) {
//            int count = 0;
//            int next = Integer.MAX_VALUE;
//            while(count < k && i < n){
//                num += count;
//                if(freq.containsKey(num)){
//                    freq.put(start, freq.get(num) - 1);
//                    count++;
//                    if(freq.get(num) == 0){
//                        freq.remove(num);
//                    }
//                } else {
//                    if(nums[i] == num){
//                        count++;
//                    } else {
//                        freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
//                        start = Math.min(start, nums[i]);
//                    }
//                    i++;
//                }
//            }
//            if(count != k) return false;
//
//
//        }
//        return true;

//        TreeMap<Integer, Integer> tm = new TreeMap<>();
//        for(int num : nums){
//            tm.put(num, tm.getOrDefault(num, 0) + 1);
//        }
//
//        while(!tm.isEmpty()){
//            int curr = tm.firstKey();
//            int count = 0;
//            while(count < k && !tm.isEmpty()){
//                if(!tm.containsKey(curr)) return false;
//                tm.put(curr, tm.get(curr) - 1);
//                if(tm.get(curr) == 0) tm.remove(curr);
//                curr++;
//                count++;
//            }
//            if(count != k) return false;
//        }
//        return true;

        Map<Integer, Integer> freq = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num : nums){
            if(!freq.containsKey(num)){
                freq.put(num, 0);
                pq.add(num);
            }
            freq.put(num, freq.get(num) + 1);
        }
        while(!pq.isEmpty()){
            int curr = pq.poll();
            if(!freq.containsKey(curr)) continue;
            int curr_freq = freq.get(curr);
            for(int i = 0; i < k; i++){
                int next = curr + i;
                if(!freq.containsKey(next) || freq.get(next) < curr_freq) return false;
                freq.put(next, freq.get(next) - curr_freq);
                if(freq.get(next) == 0) freq.remove(next);
            }
        }

        Arrays.sort(nums);
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new DivideArrayIntoSetsOfK().isPossibleDivide(new int[]{1,2,3,3,4,4,5,6}, 4));
    }


}
