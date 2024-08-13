package com.training.leetcode;

public class WordSearchI {
    int m, n;
    String word;
    char[][] board;
    int[][] directions = new int[][]{{0, -1},{-1, 0}, {0, 1}, {1, 0}};
    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        this.board = board;
        this.word = word;
        for(int r = 0; r < m; r++){
            for(int c = 0; c < n; c++){
                if(backtrack(r, c, 0)) return true;
            }
        }
        return false;
    }

    public boolean backtrack(int r, int c, int idx){
        if(idx >= word.length()) return true;

        if(r < 0 || c < 0 || r >= m || c >= n || board[r][c] != word.charAt(idx)){
            return false;
        }

        board[r][c] = '#'; // mark as visited
        for(int[] dir : directions){
            int nr = r + dir[0];
            int nc = c + dir[1];
            if(backtrack(nr, nc, idx + 1)) return true;
        }
        board[r][c] = word.charAt(idx); // backtrack to original value

        return false;
    }

    public static void main(String[] args) {

        char[][] board1 = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        System.out.println(new WordSearchI().exist(board1, "ABCCED"));
        char[][] board2 = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        System.out.println(new WordSearchI().exist(board2, "SEE"));
        char[][] board3 = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        System.out.println(new WordSearchI().exist(board3, "ABCB"));
    }
}
