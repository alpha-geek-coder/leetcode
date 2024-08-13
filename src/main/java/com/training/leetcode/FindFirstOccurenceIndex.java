package com.training.leetcode;

import java.util.Arrays;

public class FindFirstOccurenceIndex {
    /*
    Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:

Input: haystack = "sadbutsad", needle = "sad"
Output: 0
Explanation: "sad" occurs at index 0 and 6.
The first occurrence is at index 0, so we return 0.
     */
    public int strStr(String haystack, String needle) {

        //Approach 1 : Using KMP algorithm
//        int[] pattern = buildPattern(needle);
//
//        int i = 0, j = 0;
//        while(i + needle.length() - j <= haystack.length()){
//            if(haystack.charAt(i) == needle.charAt(j)){
//                if(j == needle.length() - 1) {
//                    return i - j;
//                }
//                i++; j++;
//            } else if(j > 0){
//                j = pattern[j - 1] + 1;
//            } else {
//                i++;
//            }
//        }

//        return -1;

        // Approach 2 : Using sliding-window
        int m = needle.length();
        int n = haystack.length();

        for(int i = 0; i <= n - m; i++){

            for(int j = 0; j < m; j++){
                if(haystack.charAt(i + j) != needle.charAt(j)) break;
                if(j == m - 1) return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new FindFirstOccurenceIndex().strStr("sadbutsad", "sad"));
    }

    public int[] buildPattern(String needle){

        int n = needle.length();
        int[] pattern = new int[n];
        Arrays.fill(pattern, -1);

        int i = 1, j = 0;
        while(i < n){
            if(needle.charAt(i) == needle.charAt(j)){
                pattern[i++] = j++;
            } else if(j > 0){
                j = pattern[j - 1] + 1;
            }else {
                i++;
            }
        }

        return pattern;
    }
}
