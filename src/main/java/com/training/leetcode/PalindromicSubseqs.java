package com.training.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PalindromicSubseqs {

    public int countPalindromicSubsequence(String s) {
        int[] first_occurence = new int[26];
        int[] last_occurence = new int[26];
        Arrays.fill(first_occurence, -1);

        for(int i = 0; i < s.length(); i++){
           int c = s.charAt(i) - 'a';
            if(first_occurence[c] == -1){
                first_occurence[c] = i;
            }
            last_occurence[c] = i;
        }
        int ans = 0;
        for(int i = 0; i < 26; i++){
            if(first_occurence[i] == -1) continue;
            Set<Character> between = new HashSet<>();
            for(int j = first_occurence[i] + 1; j < last_occurence[i]; j++){
                between.add(s.charAt(j));
            }
            ans += between.size();
        }

        return ans;
    }


    public static void main(String[] args) {
        System.out.println(new PalindromicSubseqs().countPalindromicSubsequence("aabca"));
        System.out.println(new PalindromicSubseqs().countPalindromicSubsequence("bbcbaba"));
    }
}
