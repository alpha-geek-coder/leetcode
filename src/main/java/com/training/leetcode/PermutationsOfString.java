package com.training.leetcode;

import java.util.HashSet;
import java.util.Set;

public class PermutationsOfString {

    Set<String> set = new HashSet<>();
    public Set<String> permutations(String s) {
        rec(s, 0);
        return set;
    }

    public void rec(String s, int idx) {

        if(idx == s.length()) {
            set.add(s);
        } else {
            for(int endIdx = idx; endIdx < s.length(); endIdx++){
                String s1 = swap(s, idx, endIdx);
                rec(s1, idx + 1);
                s1 = swap(s, idx, endIdx);
            }
        }
    }

    public String swap(String s, int startIdx, int endIdx) {

        if(startIdx == endIdx) return s;

//        String s1 = s.substring(0, startIdx);
//        String s2 = s.substring(startIdx + 1, endIdx);
//        String s3 = s.substring(endIdx + 1);
//
//        return s1 + s.charAt(endIdx) + s2 + s.charAt(startIdx) + s3;

        char[] charArray = s.toCharArray();

        char tmp = charArray[startIdx];
        charArray[startIdx] = charArray[endIdx];
        charArray[endIdx] = tmp;

        return new String(charArray);
    }

    public static void main(String[] args) {
        System.out.println(new PermutationsOfString().permutations("ABC"));
    }
}
