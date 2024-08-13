package com.training.leetcode;



public class LongestRepeatingChars {
    /*
    You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.

Return the length of the longest substring containing the same letter you can get after performing the above operations.

Example 1:

Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace the two 'A's with two 'B's or vice versa.
Example 2:

Input: s = "AABABBA", k = 1
Output: 4
Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
     */
    public int characterReplacement(String s, int k) {

        int ans = 0;
        int i = 0, j = 0, count = 0;
        for(; i < s.length(); i++){
            char c = s.charAt(i);
            count = 0;
            j = i;
            for(; j < s.length() - 1 && count < k; j++){
                if(s.charAt(j) != s.charAt(j + 1)) count++;
            }
            if(count <= k) {
                ans = Math.max(ans, j - i + 1);
            }
        }
        ans = Math.max(ans, j - i);
        return ans;
    }

    public static void main(String[] args) {
//        System.out.println(new LongestRepeatingChars().characterReplacement("AAAA", 2));
//        System.out.println(new LongestRepeatingChars().characterReplacement("AABABBA", 1));
        System.out.println(new LongestRepeatingChars().characterReplacement("AABCBCB", 3));

        System.out.println(Math.ceil(11/ (double) 15));

    }
}
