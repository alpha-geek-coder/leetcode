package com.training.leetcode;

import java.util.ArrayList;
import java.util.List;

public class CountCompleteSubstrings {
    public int countCompleteSubstrings(String word, int k) {
        int ans = 0;
        // Count unique chars in word.
        // each substring must contain atleast one unqiue char * k
        int total_unique_chars = (int) word.chars().distinct().count();
        for(int num_unqiue_chars = 1; num_unqiue_chars <= total_unique_chars; num_unqiue_chars++){
            int substr_len = num_unqiue_chars * k; // This is our substring length or window size
            if(substr_len > word.length()) break;
            int[] freq = new int[26];
            // int start = 0, end = substr_len; // our window includes chars from 0 through len - 1
            for(int i = 0; i < substr_len; i++){
                freq[word.charAt(i) - 'a']++;
            }
            // Check if window contains complete substring
            if(isCompleteSubstring(word, freq, k, 0, substr_len - 1)){
                ans++;
            }
            // Shrink from left/start and expand window to right/end until end of word.
            for(int start = 0, end = substr_len; end < word.length(); end++){
                freq[word.charAt(start++) - 'a']--;
                freq[word.charAt(end) - 'a']++;
                // Check if sliding window contains complete substring
                if(isCompleteSubstring(word, freq, k, start, end)){
                    ans++;
                }
            }
        }

        return ans;
    }

    public boolean isCompleteSubstring(String word, int[] freq, int k, int start, int end){

        for(int i = 0; i < 26; i++){
            if(freq[i] > 0 && freq[i] != k){
                return false;
            }
        }

        for(int i = start + 1; i <= end; i++){
            if(Math.abs((word.charAt(i) - 'a') - (word.charAt(i - 1) - 'a')) > 2) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new CountCompleteSubstrings().countCompleteSubstrings("igigee", 2));
        System.out.println(new CountCompleteSubstrings().countCompleteSubstrings("jjjqq", 1));

        String[] words = {"bella","label","roller"};
        int[][] freq = new int[words.length][26];
        for(int i = 0; i < words.length; i++){
            for(char c : words[i].toCharArray()){
                freq[i][c - 'a']++;
            }
        }
        List<String> ans = new ArrayList();
        for(int c = 0; c < 26; c++){
            int char_freq = Integer.MAX_VALUE;
            int count = 0;
            for(int i = 0; i < words.length; i++){
                if(freq[i][c] > 0 ) {
                    count++;
                    char_freq = Math.min(char_freq, freq[i][c]);
                }
            }
            if(count == words.length) {
                for(int j = 0; j < char_freq; j++){
                    ans.add(String.valueOf((char) (c + 'a')));
                }
            }
        }
        int num = 3;
        int flip_num = ~num;
        flip_num &= -flip_num;
        System.out.println(flip_num);
    }
}
