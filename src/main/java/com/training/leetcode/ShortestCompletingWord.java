package com.training.leetcode;

import java.util.HashMap;
import java.util.Map;

public class ShortestCompletingWord {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        Map<Character, Integer> freq = new HashMap<>();
        for(int i = 0; i < licensePlate.length(); i++){
            char c = Character.toLowerCase(licensePlate.charAt(i));
            if(c >= 'a' && c <= 'z'){
                freq.put(c, freq.getOrDefault(c, 0) + 1);
            }
        }
        int minIdx = -1;
        Map<Character, Integer> wordFreq= new HashMap<>();
        for(int idx = 0; idx < words.length; idx++){
            wordFreq.clear();
            String word = words[idx];
            for(int i = 0; i < word.length(); i++){
                char c = Character.toLowerCase(word.charAt(i));
                if(c >= 'a' && c <= 'z'){
                    wordFreq.put(c, wordFreq.getOrDefault(c, 0) + 1);
                }
            }
            int x = 0;
            for(Map.Entry<Character, Integer> entry : freq.entrySet()){
                char letter = entry.getKey();
                int count = entry.getValue();
                if(!wordFreq.containsKey(letter) || wordFreq.get(letter).intValue() < count) break;
                x++;
                if(x == freq.size()){
                    if(minIdx == -1 || word.length() < words[minIdx].length()){
                        minIdx = idx;
                    }
                }
            }
        }
        return words[minIdx];
    }

    public static void main(String[] args) {
        System.out.println(new ShortestCompletingWord().shortestCompletingWord("1s3 PSt", new String[] {"step","steps","stripe","stepple"}));
        System.out.println(new ShortestCompletingWord().shortestCompletingWord("GrC8950",new String[]{"measure","other","every","base","according","level","meeting","none","marriage","rest"}));
    }
}
