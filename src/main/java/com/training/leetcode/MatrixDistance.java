package com.training.leetcode;

import java.util.*;

public class MatrixDistance {
    int[][] dirs = new int[][]{{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    int m, n;

    public int[][] updateMatrix(int[][] mat) {

        m = mat.length;
        n = mat[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new LinkedList();
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (mat[row][col] == 0) {
                    visited[row][col] = true;
                    q.add(new int[]{row, col});
                }
            }
        }
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int row = curr[0], col = curr[1];
            for (int[] dir : dirs) {
                int r = row + dir[0];
                int c = col + dir[1];
                if (r >= 0 && r < m && c >= 0 && c < n && !visited[r][c]) {
                    mat[r][c] = mat[row][col] + 1;
                    visited[r][c] = true;
                    q.add(new int[]{r, c});
                }
            }
        }


        return mat;
    }

    public static void main(String[] args) {
        int[][] mat = new int[][]{{0, 1, 0}, {0, 1, 0}, {0, 1, 0}, {0, 1, 0}, {0, 1, 0}};
        int[][] ans = new MatrixDistance().updateMatrix(mat);

        for (int[] r : ans) {
            System.out.println(r);
        }
        String s = "ABAB";
        int i = 1, prevLPS = 0, n = s.length();
        int[] pattern = new int[n];

        while(i < n){
            char prefix = s.charAt(prevLPS);
            char suffix = s.charAt(i);
            if(prefix == suffix){
                pattern[i++] = ++prevLPS;
            } else if(prevLPS == 0){
                pattern[i++] = 0;
            } else {
                prevLPS = pattern[prevLPS - 1];
            }
        }

        System.out.println((pattern[n - 1] > 0 && n % (n - pattern[n - 1]) == 0));

        int columnNumber = 701;
        StringBuilder sb = new StringBuilder();
        while(columnNumber > 0){
            columnNumber--;
            sb.append((char) ('A' + columnNumber % 26));
            columnNumber /= 26;
        }
        System.out.println(sb.reverse().toString());

    }
}
