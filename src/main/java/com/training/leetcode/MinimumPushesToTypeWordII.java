package com.training.leetcode;

import java.util.Arrays;

public class MinimumPushesToTypeWordII {

    public int minimumPushes(String word) {
        int[] freq = new int[26];
        for(char c : word.toCharArray()){
            freq[c - 'a']++ ;
            
        }

        Arrays.sort(freq);
        int cost = 0, key = 1;
        int[] keys = new int[9];
        for(int i = 25; i >= 0; i--){
            if(freq[i] > 0){
                key = (key + 1) % 8;
                keys[key]++;
                cost += freq[i] * keys[key];
            }
        }

        return cost;
    }
    public static void main(String[] args) {
        System.out.println(new MinimumPushesToTypeWordII().minimumPushes("abcde"));
    }
    
}
