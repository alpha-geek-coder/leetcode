package com.training.leetcode;
import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class AsFarFromLandAsPossible {


    public int maxDistance(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] directions = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        for(int r = 0; r < m; r++){
            for(int c = 0; c < n; c++){
                if(grid[r][c] == 1){
                    q.add(new Pair(r, c));
                }
            }
        }

        boolean[][] visited = new boolean[m][n];
        int dist = -1;
        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0; i < size; i++){
                Pair<Integer, Integer> land = q.poll();

                for(int[] dir : directions){
                    int x = land.getKey() + dir[0];
                    int y = land.getValue() + dir[1];
                    if(x >= 0 && y >= 0 && x < m && y < n && !visited[x][y] && grid[x][y] == 0){
                        visited[x][y] = true;
                        q.add(new Pair(x, y));
                    }
                }
            }
            dist++;
        }

        return dist == 0 ? -1 : dist;
    }

    public static void main(String[] args) {
        System.out.println(new AsFarFromLandAsPossible().maxDistance(new int[][]{{1,0,1},{0,0,0},{1,0,1}}));
    }
}
