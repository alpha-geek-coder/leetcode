package com.training.leetcode;

import java.util.*;

public class MinDeletionCharFreq {
    public int minDeletions(String s) {
        int[] freq = new int[26];
        Set<Integer> set= new HashSet<>();

        for(char c: s.toCharArray()){
            freq[c - 'a']++;
        }
        int ans = 0;
        for(int i = 0; i < 26; i++){
            int count = freq[i];
            while(count > 0 && set.contains(count)){
                ans++;
                count--;
            }
            set.add(count);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new MinDeletionCharFreq().minDeletions("xxxccbbb"));
    }
}
