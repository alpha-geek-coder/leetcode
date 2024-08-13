package com.training.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortStringByFreq {
    public String frequencySort(String s) {

        Map<Character, Integer> map = new HashMap();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<Map.Entry<Character, Integer>>(
                (a, b) -> b.getValue().compareTo(a.getValue())
        );

        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            pq.add(entry);
        }

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){

            Map.Entry<Character, Integer> entry = pq.poll();

            for(int i = 0; i < entry.getValue().intValue(); i++){
                sb.append(entry.getKey());
            }

        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new SortStringByFreq().frequencySort("tree"));
        System.out.println(new SortStringByFreq().frequencySort("cccaaa"));
        System.out.println(new SortStringByFreq().frequencySort("Aabb"));
    }
}
