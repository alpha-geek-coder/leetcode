package com.training.leetcode;

import java.util.*;

public class SortVowelsInString {

    public String sortVowels(String s){

        Set<Character> vowels = new HashSet(Arrays.asList('a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U'));
        List<Character> arr = new ArrayList();
        for(int i = 0; i < s.length(); i++){
            if(vowels.contains(s.charAt(i))) arr.add(s.charAt(i));
        }
        Collections.sort(arr);
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        for(int i = 0; i < s.length(); i++){
            if(vowels.contains(s.charAt(i))){
                sb.append(arr.get(idx++));
            } else {
                sb.append(s.charAt(i));
            }
        }
    return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new SortVowelsInString().sortVowels("lEetcOde"));
    }
}
