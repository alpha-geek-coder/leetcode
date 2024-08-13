package com.training.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
//        Approach 1 : Brute Force
        int max_length = 0;
        String ans = "";
        for(int end = s.length() - 1; end >= 0; end--){
            for(int start = 0; start < end; start++ ){
                if(isPalindrome(s, start, end) && end - start > max_length){
                    max_length = end - start ;
                    ans = s.substring(start, end + 1);
                }
            }
        }
        return ans;
    }

    public boolean isPalindrome(String s, int start, int end){
        while(start < end){
            if(s.charAt(start) != s.charAt(end)) return false;
            start++;
            end --;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindromicSubstring().longestPalindrome("cbbd"));
        System.out.println(7 ^ 0);
        List<Character> arr = new ArrayList<>(Arrays.asList('a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U'));
        Collections.sort(arr);
        System.out.println(arr);
    }
}
