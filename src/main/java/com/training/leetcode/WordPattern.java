package com.training.leetcode;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    public static boolean wordPattern(String pattern, String s) {

        Map<String, Character> map1 = new HashMap();
        Map<Character, Integer> map2 = new HashMap();
        String[] words = s.split(" ");

        for (int i = 0; i < words.length; i++) {
            char c = pattern.charAt(i);

            if (!map1.containsKey(words[i]) && !map2.containsKey(c)) {
                map1.put(words[i], c);
                map2.put(c, i);
            } else if(map1.containsKey(words[i]) && map1.get(words[i])!= c){
                return false;
            } else if(map2.containsKey(c) && !words[map2.get(c)].equals(words[i])){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(WordPattern.wordPattern("abxa", "dog cat cat dog"));
    }
}
