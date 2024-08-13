package com.training.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReorganizeString {

    public String reorganizeString(String s){
        Map<Character, Integer> freq = new HashMap();
        for(char c : s.toCharArray()){
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Character, Integer> entry : freq.entrySet()){
            pq.add(entry);
        }
        while(!pq.isEmpty()){
            Map.Entry<Character, Integer> first = pq.poll();
            char c1 = first.getKey();
            int val1 = first.getValue();
            if(sb.length() == 0 || sb.charAt(sb.length() - 1) != c1) {
                sb.append(c1);
                if(val1 > 1) {
                    first.setValue(val1 - 1);
                    pq.add(first);
                }
            } else {
                if(pq.isEmpty()) return "";
                Map.Entry<Character, Integer> second = pq.poll();
                char c2 = second.getKey();
                int val2 = second.getValue();
                sb.append(c2);
                if(val2 > 1) {
                    second.setValue(val2 - 1);
                    pq.add(second);
                }
                pq.add(first);
            }

        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new ReorganizeString().reorganizeString("vvvlo"));

        String customers = "YYNY";
        int n = customers.length();
        int[] prefixN = new int[n + 1];
        int[] suffixY = new int[n + 1];
        int[] penalties = new int[n + 1];
        int countN = 0, countY = 0;
        for(int i = 0; i < n; i++){
            prefixN[i] = countN;
            if(customers.charAt(i) == 'N')  countN++;
        }
        prefixN[n] = countN;
        for(int i = n - 1; i >= 0; i--){
            suffixY[i + 1] = countY;
            if(customers.charAt(i) == 'Y')  countY++;
        }
        suffixY[0] = countY;
        int min = Integer.MAX_VALUE, idx = 0;
        for(int i = 0; i <= n; i++){
            penalties[i] = prefixN[i] + suffixY[i];
            if(penalties[i] < min){
                min = penalties[i];
                idx = i;
            }
        }

        System.out.println(idx);
    }
}
