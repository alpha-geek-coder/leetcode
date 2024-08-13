package com.training.leetcode;

import java.util.Stack;
/*
We can apply the maximum in histogram in each row of the 2D matrix. What we need is to maintain an int array for each row, which represent for the height of the histogram.
Please refer to https://leetcode.com/problems/largest-rectangle-in-histogram/ first.
Suppose there is a 2D matrix like

1 1 0 1 0 1

0 1 0 0 1 1

1 1 1 1 0 1

1 1 1 1 0 1

First initiate the height array as 1 1 0 1 0 1, which is just a copy of the first row. Then we can easily calculate the max area is 2.
Then update the array. We scan the second row, when the matrix[1][i] is 0, set the height[i] to 0; else height[i] += 1, which means the height has increased by 1. So the height array again becomes 0 2 0 0 1 2. The max area now is also 2.
Apply the same method until we scan the whole matrix. the last height arrays is 2 4 2 2 0 4, so the max area has been found as 2 * 4 = 8.
Then reason we scan the whole matrix is that the maximum value may appear in any row of the height.
 */
public class MaximalRectangle {
    int m, n;
    int[] heights;
    public int maximalRectangle(char[][] matrix) {
         m = matrix.length;
         n = matrix[0].length;
         heights = new int[n];
         int ans = 0;
         int idx = 0;
         for(char col : matrix[0]){
             heights[idx++] = col - '0';
         }

         ans = Math.max(ans, largestRectangleArea());
         for(int i = 1; i < m; i++){
             resizeHeights(matrix, i);
             ans = Math.max(ans, largestRectangleArea());
         }

         return ans;
    }

    public void resizeHeights(char[][] matrix, int row){
        int i = 0;
        for(char col : matrix[row]){
            heights[i] = col - '0' == 0 ? 0 : ++heights[i];
            i++;
        }
    }

    public int largestRectangleArea(){
        Stack<Integer> stack = new Stack();
        int max_area = 0;
        // String increasing stack
        for(int i = 0; i <= n; i++){
            while(!stack.isEmpty() && (i == n || heights[stack.peek()] >= heights[i])){
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                max_area = Math.max(max_area, height * width);
            }
            stack.push(i);
        }

        return max_area;
    }

    public static void main(String[] args) {
        char[][] mat = new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.println(new MaximalRectangle().maximalRectangle(mat));

        System.out.println("zbaba".compareTo("zba"));
    }
}
