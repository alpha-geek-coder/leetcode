package com.training.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Trie {
    TrieNode root;
    char endWordSymbol;
    public Trie() {
        endWordSymbol = '*';
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(!curr.children.containsKey(c)) curr.children.put(c, new TrieNode());
            curr = curr.children.get(c);
        }
        curr.children.put(endWordSymbol, null);
        curr.word = word;
    }

    public boolean search(String word) {
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(!curr.children.containsKey(c)) return false;
            curr = curr.children.get(c);
        }
        return curr.children.containsKey(endWordSymbol);
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(int i = 0; i < prefix.length(); i++){
            char c = prefix.charAt(i);
            if(!curr.children.containsKey(c)) return false;
            curr = curr.children.get(c);
        }
        return true;
    }

    class TrieNode{
        String word = "";
        Map<Character, TrieNode> children  = new HashMap<>();
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        System.out.println("Insert apple");
        trie.insert("apple");
        System.out.println("Search apple " + trie.search("apple"));
        System.out.println("Search app " + trie.search("app"));
        System.out.println("StartsWith app " + trie.startsWith("app"));
        System.out.println("Insert app");
        trie.insert("app");
        System.out.println("Search app " + trie.search("app"));


    }
}
