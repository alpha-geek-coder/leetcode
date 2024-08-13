package com.training.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MinWindowSubstr {

    public String minWindowSubstring(String s, String t){

        Map<Character, Integer> mapT = new HashMap<>();
        for(char c : t.toCharArray()){
            mapT.put(c, mapT.getOrDefault(c, 0) + 1);
        }

        int l = 0, n = s.length(), freq = 0;
        int startIdx = 0, endIdx = 0, len = -1;
        Map<Character, Integer> windowFreq = new HashMap<>();
        for(int r = 0; r < n; r++){
            char c = s.charAt(r);
            windowFreq.put(c, windowFreq.getOrDefault(c, 0) + 1);
            if(mapT.containsKey(c) && windowFreq.get(c).intValue() == mapT.get(c).intValue()){
                freq++;
            }
            while(l <= r && freq == mapT.size()){
                if(len == -1 || r - l + 1 < len){
                    startIdx = l;
                    endIdx = r;
                    len = r - l + 1;
                }
                char ch = s.charAt(l);
                windowFreq.put(ch, windowFreq.get(ch) - 1);
                if(mapT.containsKey(ch) && windowFreq.get(ch).intValue() < mapT.get(ch).intValue()){
                    freq--;
                }
                l++;
            }
        }

        return len == -1 ? "" : s.substring(startIdx, endIdx + 1);
    }

    public static void main(String[] args) {
        System.out.println(new MinWindowSubstr().minWindowSubstring("ADOBECODEBANC", "ABC"));
    }
}
