package com.training.leetcode;

import java.util.*;

public class LongestWordInDictionaryThroughDeletion {

    /*
    Given a string s and a string array dictionary, return the longest string in the dictionary that can be formed by deleting some of the given string characters. If there is more than one possible result, return the longest word with the smallest lexicographical order. If there is no possible result, return the empty string.

    Example 1:

    Input: s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
    Output: "apple"
     */


    // Approach 1: Using recursion get list of words by deleting one or more chars from String s
    // and search each word in dictionary in the list
    public String findLongestWordUsingRecursion(String s, List<String> dictionary) {

        Set<String> set = new HashSet<>(dictionary);

        List<String> list = new ArrayList <>();
        generateCombinations(s, "", 0, list);

        String ans = "";
        for(String str : list) {
            if(set.contains(str)) {
                if(str.length() > ans.length() || str.length() == ans.length() && str.compareTo(ans) < 0) {
                    ans = str;
                }
            }
        }
        return ans;
    }

    public void generateCombinations(String s, String str, int idx, List<String> list) {

        if(idx == s.length()) {
            list.add(str);
        } else {
            generateCombinations(s, str + s.charAt(idx), idx + 1, list);
            generateCombinations(s, str, idx + 1, list);
        }
    }

    // Approach 2 : Since we are interested in longest word length from dictionary,
    // sort in decreasing length order and check if each word is a subsequence of String s
    public String findLongestWord(String s, List<String> dictionary) {

        // Step 1: Sort dictionary by length
        Collections.sort(dictionary, (s1, s2) ->
            s1.length() != s2.length() ?  s2.length() - s1.length() : s1.compareTo(s2)
        );

        for(String word : dictionary) {
            if(isSubsequence(word, s)){
                return word;
            }
        }

        return "";
    }

    public boolean isSubsequence(String word, String s) {

        int j = 0;

        for(int i = 0; i < s.length() && j < word.length(); i++) {

            if(s.charAt(i) == word.charAt(j)) j++;
        }

        return j == word.length();
    }

    public static void main(String[] args) {
        System.out.println(new LongestWordInDictionaryThroughDeletion().findLongestWordUsingRecursion("abpcplea", Arrays.asList(new String[] {"ale","apple","monkey","plea"})));

        System.out.println(new LongestWordInDictionaryThroughDeletion().findLongestWord("abpcplea", Arrays.asList(new String[] {"ale","apple","monkey","plea"})));

        System.out.println("apple".compareTo("apply"));
    }
}
