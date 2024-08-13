package com.training.leetcode;

public class PermutationsInString {
    /*
    Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
    In other words, return true if one of s1's permutations is the substring of s2.

    Example 1:
    Input: s1 = "ab", s2 = "eidbaooo"
    Output: true
    Explanation: s2 contains one permutation of s1 ("ba").
     */

    public boolean checkInclusion(String s1, String s2) {

        if(s1.length() > s2.length()) return false;

        // Hint : sorted(s1) == sorted(s2)

        int[] s1map = new int[26];
        int[] s2map = new int[26];

        for(int i = 0; i < s1.length(); i++){
            s1map[s1.charAt(i) - 'a']++;
            s2map[s2.charAt(i) - 'a']++;
        }

        for(int i = 0; i < s2.length() - s1.length(); i++){

            if(matches(s1map, s2map)) return true;
            // increment char to right i.e. current + s1.length()
            s2map[s2.charAt(i + s1.length()) - 'a']++;
            // decrement char at current idx
            s2map[s2.charAt(i) - 'a']--;
        }

        return matches(s1map, s2map);
    }

    public boolean matches(int[] s1map, int[] s2map){
        for(int j = 0; j < 26; j++){
            if (s1map[j] != s2map[j]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        // acb premutation cba is present in second string
        System.out.println(new PermutationsInString().checkInclusion("acb", "sdfsbbbowirkcbxxcbagf"));
    }
}
