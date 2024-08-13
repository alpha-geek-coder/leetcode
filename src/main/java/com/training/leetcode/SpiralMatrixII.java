package com.training.leetcode;

public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {

        int[][] matrix = new int[n][n];

        int startRow = 0, endRow = n - 1, startCol = 0, endCol = n - 1;
        int cell = 1;
        while(startRow <= endRow && startCol <= endCol){
            //top left -> right
            for(int c = startCol; c <= endCol; c++){
                matrix[startRow][c] = cell++;
            }
            //right top -> bottom
            for(int r = startRow + 1; r <= endRow; r++){
                matrix[r][endCol] = cell++;
            }
            //bottom right -> left
            for(int c = endCol - 1; c >= startCol && startRow != endRow; c--){
                matrix[endRow][c] = cell++;
            }
            //left bottom -> top
            for(int r = endRow - 1; r > startRow && startCol != endCol; r--){
                matrix[r][startCol] = cell++;
            }
            startRow++; endRow--;
            startCol++; endCol--;
        }

        return matrix;
    }

    public static void main(String[] args) {
        int[][] mat1 = new SpiralMatrixII().generateMatrix(3);
        for(int r = 0; r < 3; r++){
            System.out.print("[");
            for(int c = 0; c < 3; c++){
                System.out.print(mat1[r][c] + ",");
            }
            System.out.print("],");
        }
    }
}
