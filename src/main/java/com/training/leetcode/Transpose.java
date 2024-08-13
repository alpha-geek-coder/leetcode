package com.training.leetcode;

public class Transpose {
    public int[][] transpose(int[][] matrix) {

        int m = matrix.length, n = matrix[0].length;

        int[][] res = new int[n][m];
        for(int r = 0; r < n; r++){
            for(int c = 0; c < m; c++){
                res[r][c] = matrix[c][r];
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        int[][] mat1 = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        int[][] mat2 = new Transpose().transpose(mat1);

    }
}
