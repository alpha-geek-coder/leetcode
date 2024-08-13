package com.training.leetcode;

import java.util.*;

public class LongestWordInDictionary {
    /*
    Given an array of strings words representing an English Dictionary, return the longest word in words that can be built one character at a time by other words in words.

    If there is more than one possible answer, return the longest word with the smallest lexicographical order. If there is no answer, return the empty string.

    Note that the word should be built from left to right with each additional character being added to the end of a previous word.

    Input: words = ["w","wo","wor","worl","world"]
    Output: "world"
    Explanation: The word "world" can be built one character at a time by "w", "wo", "wor", and "worl".
     */

    public String longestWord(String[] words) {

        Set<String> wordSet = new HashSet<String>();

        StringBuilder longest = new StringBuilder();

        for(String word : words) {
            wordSet.add(word);
        }

        for(String word : words) {

            if(word.length() > longest.length() || word.length() == longest.length() && word.compareTo(longest.toString()) < 0) {
                boolean found = true;
                for(int i = 1; i < word.length(); i++) {
                    if(!wordSet.contains(word.substring(0, i))) {
                        found = false;
                        break;
                    }
                }
                if(found) {
                    longest.setLength(0);
                    longest.append(word);
                }
            }
        }

        return longest.toString();
    }

    public String longestWordUsingTrie(String[] words) {

        Trie trie = new Trie();
        int index = 0;
        for(String word : words) trie.insert(word, ++index); // 1 indexed
        trie.words = words;

        return trie.dfs();

    }

    public class Node {

        char c;
        int end;
        Map<Character, Node> children = new HashMap();

        Node(char ch) {
            c = ch;
        }
    }

    public class Trie {

        Node root;
        String[] words;
        Map<Character, Node> children = new HashMap<Character, Node>();

        Trie() {
            root = new Node('0');
        }

        public void insert(String word, int index){

            Node curr = root;
            for(char ch : word.toCharArray()){
                curr.children.putIfAbsent(ch, new Node(ch));
                curr = curr.children.get(ch);
            }
            curr.end = index;
        }

        public String dfs(){

            Stack<Node> stack = new Stack<>();
            stack.push(root);
            String ans = "";
            while(!stack.isEmpty()){
                Node node = stack.pop();

                if(node.end > 0 || node == root){
                    if(node != root) {
                        String word = this.words[node.end - 1];
                        if(word.length() > ans.length() || word.length() == ans.length() && word.compareTo(ans) < 0) {
                            ans = word;
                        }
                    }

                    for(Node child : node.children.values()){
                        stack.add(child);
                    }

                }
            }
            return ans;
        }

    }

    public void generate(String s, String str, int i, List<String> current){

        if(i == s.length()) {
            current.add(str);
            return;
        }

        generate(s, str + s.charAt(i), i + 1, current);
        generate(s, str, i + 1, current);
    }

    public static void main(String[] args) {
     //   System.out.println(new LongestWordInDictionary().longestWord(new String[] {"w","wo","wor","worl","world"}));
        System.out.println("apply".compareTo("appl"));
        System.out.println(new LongestWordInDictionary().longestWord(new String[] {"a","banana","app","appl","ap","apply","apple"}));

        System.out.println(new LongestWordInDictionary().longestWordUsingTrie(new String[] {"a","banana","app","appl","ap","apply","apple"}));

        List<String> list = new ArrayList<String>();
        new LongestWordInDictionary().generate("apple", "", 0, list);
        System.out.println(list);
    }
}
