package com.training.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<Integer>();

        int m = matrix.length, n = matrix[0].length;
        int startRow = 0, endRow = m - 1;
        int startCol = 0, endCol = n - 1;
        while(startRow <= endRow && startCol <=endCol){
            //top left -> right
            for(int c = startCol; c <= endCol; c++){
                ans.add(matrix[startRow][c]);
            }
            // right top -> bottom
            for(int r = startRow + 1; r <= endRow; r++){
                ans.add(matrix[r][endCol]);
            }
            // bottom right -> left
            for(int c = endCol - 1; c >= startCol && startRow != endRow; c--){
                ans.add(matrix[endRow][c]);
            }
            // left bottom -> top
            for(int r = endRow - 1; r > startRow && startCol != endCol; r--){
                ans.add(matrix[r][startCol]);
            }
            startRow++; endRow--;
            startCol++; endCol--;

        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3}, {4,5,6}, {7,8,9}};
        System.out.println(new SpiralMatrix().spiralOrder(matrix));
        System.out.println(new SpiralMatrix().spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}}));
    }
}
