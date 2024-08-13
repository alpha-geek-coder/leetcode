package com.training.leetcode;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> list = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for(int i = 0; i < strs.length; i++){
            char[] str = strs[i].toCharArray();
            Arrays.sort(str);
            String sortedWord = new String(str);
            if(!map.containsKey(sortedWord)){
                map.put(sortedWord, new ArrayList<String>());
            }
            List<String> wordList = map.get(sortedWord);
            wordList.add(strs[i]);
            map.put(sortedWord,wordList);
        }

        for(Map.Entry<String, List<String>> entry : map.entrySet()){
            list.add(entry.getValue());
        }

        return list;
    }

    public static void main(String[] args) {
        System.out.println(new GroupAnagrams().groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
    }
}
