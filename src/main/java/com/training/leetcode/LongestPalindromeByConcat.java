package com.training.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindromeByConcat {
    public int longestPalindrome(String[] words) {

//        Map<String, Integer> map = new HashMap<>();
//        int len = 0, palindromeWords = 0;
//        for(String word : words){
//            String reverseWord  = new StringBuilder(word).reverse().toString();
//            if(map.containsKey(reverseWord)){
//                len += 4;
//                if(map.get(reverseWord) == 1) {
//                    map.remove(reverseWord);
//                } else {
//                    map.put(reverseWord, map.get(reverseWord) - 1);
//                }
//                if(word.equals(reverseWord)) {
//                    palindromeWords--;
//                }
//            } else {
//                map.put(word, map.getOrDefault(word, 0) + 1);
//                if(word.equals(reverseWord)) {
//                    palindromeWords++;
//                }
//            }
//        }
//
//        return palindromeWords > 0 ? len + 2 : len;
// Approach 2
        Map<String, Integer> wordCounts = new HashMap<>();
        for(String word: words){
            wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
        }

        int ans = 0; boolean central = false;
        for(Map.Entry<String, Integer> entry : wordCounts.entrySet()){
            String word = entry.getKey();
            int count = entry.getValue().intValue();

            if(word.charAt(0) == word.charAt(1)){
            // e.g. aa 8 times
                if(count % 2 == 0){
                    ans += count;
                } else {
                    // e.g. aa 9 times, max palindrome length will be even i.e. count - 1
                    ans += count - 1;
                    central = true;
                }
            } else if(word.charAt(0) < word.charAt(1)){
                // e.g. ab 4 times and ba 2 times, max palindrom must be 2 * min(ab count, ba count)
                String reverseWord = "" + word.charAt(1) + word.charAt(0);
                if(wordCounts.containsKey(reverseWord)){
                    ans += 2 * Math.min(count, wordCounts.get(reverseWord));
                }
            }
        }
        if(central) ans++;

        return 2 * ans;

    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindromeByConcat().longestPalindrome(new String[]{"aa","ab","ba", "ab","ab", "ba","aa", "aa"}));
        System.out.println(new LongestPalindromeByConcat().longestPalindrome(new String[]{"lc","cl","gg"}));
//        System.out.println(new LongestPalindromeByConcat().longestPalindrome(new String[]{"ab","ty","yt","lc","cl","ab"}));
//        System.out.println(new LongestPalindromeByConcat().longestPalindrome(new String[]{"cc","ll","xx"}));
//        System.out.println(new LongestPalindromeByConcat().longestPalindrome(new String[]{"dd","aa","bb","dd","aa","dd","bb","dd","aa","cc","bb","cc","dd","cc"}));
    }
}

