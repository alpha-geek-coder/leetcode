package com.training.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        Map<Character, Integer> tFreq = new HashMap<>();

        for(int i = 0; i < t.length(); i++){
            tFreq.put(t.charAt(i), tFreq.getOrDefault(t.charAt(i), 0) + 1);
        }
        int tSize = tFreq.size(), formed = 0;
        int[] windowSize = new int[]{0, s.length()};
        int l = 0;
        Map<Character, Integer> window = new HashMap<>();
        for(int r = 0; r < s.length(); r++){
            char c = s.charAt(r);
            window.put(c, window.getOrDefault(c, 0) + 1);
            if(tFreq.containsKey(c) && tFreq.get(c).intValue() == window.get(c).intValue()){
                formed++;
            }

            while(l <= r && formed == tSize){
                if(windowSize[1] - windowSize[0] + 1 < r - l + 1){
                    windowSize[0] = l;
                    windowSize[1] = r;
                }
                c = s.charAt(l);
                window.put(c, window.get(c) - 1);
                if(tFreq.containsKey(c) && tFreq.get(c).intValue() != window.get(c).intValue()){
                    formed--;
                }
                l++;
            }
        }

        return s.substring(windowSize[0], windowSize[1]);
    }

    public static void main(String[] args) {
        System.out.println(new MinWindowSubstring().minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(new MinWindowSubstring().minWindow("a", "aa"));
    }
}
