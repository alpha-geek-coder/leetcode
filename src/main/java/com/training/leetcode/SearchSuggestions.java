package com.training.leetcode;

import java.util.*;

public class SearchSuggestions {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> ans = new ArrayList<>();
        Trie trie = new Trie();
        Arrays.sort(products);
        for(int i = 0; i < products.length; i++){
            trie.insert(products[i], i);
        }
        Node curr = trie.root;
        for(int i = 0; i < searchWord.length(); i++){
            List<String> words = new ArrayList<>();
            if(!curr.children.containsKey(searchWord.charAt(i))) return ans;
            curr = curr.children.get(searchWord.charAt(i));
            for(int j = 0; j < curr.idx.size() && j < 3; j++){
                words.add(products[curr.idx.get(j)]);
            }
            ans.add(words);
        }
        return ans;
    }

    static class Trie{
        Node root = new Node();
        char end_symbol = '*';


        public void insert(String word, int i){
            Node curr = root;
            for(char c : word.toCharArray()){
                if(!curr.children.containsKey(c)) {
                    curr.children.put(c, new Node());
                }
                curr = curr.children.get(c);
                curr.idx.add(i);
            }
            curr.children.put(end_symbol, null);
            curr.word = word;
        }

    }

    static class Node{
        Map<Character, Node> children = new HashMap<>();;
        String word = null;
        List<Integer> idx = new ArrayList();
    }

    public static void main(String[] args) {
        System.out.println(new SearchSuggestions().suggestedProducts(new String[]{"mobile","mouse","moneypot","monitor","mousepad"}, "mouse"));

    }

}
