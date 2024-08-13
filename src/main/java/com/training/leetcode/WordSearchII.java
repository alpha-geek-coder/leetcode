package com.training.leetcode;

import java.util.*;

public class WordSearchII {
    public List<String> findWords(char[][] board, String[] words) {
        int m = board.length, n = board[0].length;
        Trie trie = new Trie();
        for(String word : words){
            trie.add(word);
        }
        boolean[][] seen = new boolean[m][n];
        Set<String> finalWords = new HashSet<>();
        for(int r = 0; r < m; r++){
            for(int c = 0; c < n; c++){
                explore(r, c, board, trie.root, seen, finalWords);
            }
        }
        List<String> list = new ArrayList<>();
        list.addAll(finalWords);
        return list;
    }

    public void explore(int row, int col, char[][] board, TrieNode node, boolean[][] seen, Set<String> finalWords){
        if(seen[row][col]) return;
        char c = board[row][col];
        if(!node.children.containsKey(c)) return;
        node = node.children.get(c);
        if(node.children.containsKey('*')){
            finalWords.add(node.word);
        }
        seen[row][col] = true;
        List<Integer[]> neighbors = getNeighbors(row, col, board);
        for(Integer[] neighbor : neighbors){
            explore(neighbor[0], neighbor[1], board, node, seen, finalWords);
        }
        seen[row][col] = false;
    }

    public List<Integer[]> getNeighbors(int row, int col, char[][] board){
        int m = board.length, n = board[0].length;
        List<Integer[]> neighbors = new ArrayList<>();
        if(row < m && col + 1 < n) neighbors.add(new Integer[]{row, col + 1});
        if(row - 1 >= 0 && col < n) neighbors.add(new Integer[]{row - 1, col});
        if(row < m && col - 1 >= 0) neighbors.add(new Integer[]{row, col - 1});
        if(row + 1 < m && col < n) neighbors.add(new Integer[]{row + 1, col});

        return neighbors;
    }

    static class Trie{
        TrieNode root;
        char endSymbol;

        public Trie(){
            root = new TrieNode();
            endSymbol = '*';
        }

        public void add(String word){
            TrieNode node = root;
            for(char c : word.toCharArray()){
                if(!node.children.containsKey(c)){
                    node.children.put(c, new TrieNode());
                }
                node = node.children.get(c);
            }
            node.children.put(endSymbol, null);
            node.word = word;
        }
    }

    static class TrieNode{
        String word = "";
        Map<Character, TrieNode> children = new HashMap<>();
    }

    public static void main(String[] args) {
//        char[][] board1 = new char[][]{{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
//        String[] words1 = new String[]{"oath","pea","eat","rain"};
//        System.out.println(new WordSearchII().findWords(board1, words1));
        char[][] board1 = new char[][]{{'a', 'b'}};
        String[] words1 = new String[]{"ba"};
        System.out.println(new WordSearchII().findWords(board1, words1));
    }
}
