package com.training.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.

Note that the same word in the dictionary may be reused multiple times in the segmentation.

Example 1:

Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple","pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: false


Constraints:

1 <= s.length <= 300
1 <= wordDict.length <= 1000
1 <= wordDict[i].length <= 20
s and wordDict[i] consist of only lowercase English letters.
All the strings of wordDict are unique.
 */
public class WordBreak {
    Trie trie;
    public boolean wordBreak(String s, List<String> wordDict) {
        trie = new Trie();
        for(String word : wordDict){
            insert(word);
        }

        boolean[] dp = new boolean[s.length()];
        for(int i = 0; i < s.length(); i++){
            if(i == 0 || dp[i - 1]){
                Node curr = trie.root;
                for(int j = i; j < s.length(); j++){
                    char c = s.charAt(j);
                    if(!curr.children.containsKey(c)) break;
                    curr = curr.children.get(c);
                    if(curr.word != null) dp[j] = true;
                }
            }
        }
        return dp[s.length() - 1];
    }

    public void insert(String word){
        Node curr = trie.root;
        for(char c : word.toCharArray()){
            if(!curr.children.containsKey(c)) {
                curr.children.put(c, new Node());
            }
            curr = curr.children.get(c);
        }
        curr.children.put(trie.endSymbol, null);
        curr.word = word;
    }

    static class Trie{
        Node root;
        char endSymbol = '*';
        Trie(){
            root = new Node();
        }
    }
    static class Node{
        Map<Character, Node> children = new HashMap<>();
        public String word = null;
    }

    public static void main(String[] args) {
        System.out.println(new WordBreak().wordBreak("catsandog", Arrays.asList("cats","dog","sand","and","cat")));
    }
}
