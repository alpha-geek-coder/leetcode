package com.training.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MinWindowSubstring {

    public String minWindow(String s, String t){
        ArrayList<Integer> ans = new ArrayList();

        Map<Character, Integer> mapT = new HashMap<>();
        for(char c : t.toCharArray()){
            mapT.put(c, mapT.getOrDefault(c, 0) + 1);
        }

        // window of s must contain all unique chars in t
        int required = mapT.size();

        // when window of s contains all chars in t
        int formed = 0; // init to 0

        // window initial points
        int l = 0, r = 0;

        // min window size, start and end indices
        int[] windowSize = new int[]{-1, l, r};
        Map<Character, Integer> windowCounts = new HashMap<>();

        while(r < s.length()){

            char c = s.charAt(r);

            if(mapT.containsKey(c)){
                windowCounts.put(c, windowCounts.getOrDefault(c, 0) + 1);
                if(mapT.get(c).intValue() == windowCounts.get(c).intValue()) {
                    formed++; // increase when char count matches unique char count in t
                }
            }

            while(l <= r && formed == required){

                if(windowSize[0] == -1 || r - l + 1 < windowSize[0]){
                    windowSize[0] = r - l + 1;
                    windowSize[1] = l;
                    windowSize[2] = r;
                }
                // start contract window from left
                c = s.charAt(l); // pick left char

                // if the left char in t, reduce formed count
                if(mapT.containsKey(c)) {
                    windowCounts.put(c, windowCounts.get(c) - 1); // decrease count from window
                    if(windowCounts.get(c).intValue() < mapT.get(c).intValue()) {
                        formed--; // window does not contain all chars in t
                    }
                }
                l++;
            }
            r++;
        }

        return windowSize[0] == -1 ? "" : s.substring(windowSize[1], windowSize[2] + 1);
    }

    public static void main(String[] args) {
        System.out.println(new MinWindowSubstring().minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(new MinWindowSubstring().minWindow("a", "a"));
        System.out.println(new MinWindowSubstring().minWindow("a", "aa"));
    }
}
