package com.training.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class NearestExitFromEntrance {
    public int nearestExit(char[][] maze, int[] entrance) {

        int m = maze.length, n = maze[0].length;

        maze[entrance[0]][entrance[1]] = '+';

        Queue<int[]> q = new LinkedList();
        q.add(new int[]{entrance[0], entrance[1], 0});


        while(!q.isEmpty()){
            int[] cell = q.poll();
            int r = cell[0], c = cell[1];

            for(int[] dir : new int[][]{{0, -1}, {-1, 0}, {0, 1}, {1, 0}}){
                int nr = cell[0] + dir[0];
                int nc = cell[1] + dir[1];
                if(nr >= 0 && nr < m && nc >= 0 && nc < n && maze[nr][nc] != '+'){
                    int dist = cell[2] + 1;
                    maze[nr][nc] = '+';
                    if(nr == 0 || nr == m - 1 || nc == 0 || nc == n - 1){
                        return dist;
                    }
                    q.add(new int[]{nr, nc, dist});

                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        char[][] maze1 = new char[][]{{'+','+','.','+'},{'.','.','.','+'},{'+','+','+','.'}};
        int[] entrance1 = new int[] {1,2};
        System.out.println(new NearestExitFromEntrance().nearestExit(maze1, entrance1));

        char[][] maze2 = new char[][]{{'+','+','+'},{'.','.','.'},{'+','+','+'}};
        int[] entrance2 = new int[] {1,0};
        System.out.println(new NearestExitFromEntrance().nearestExit(maze2, entrance2));

        char[][] maze3 = new char[][]{{'.', '+'}};
        int[] entrance3 = new int[] {0,0};
        System.out.println(new NearestExitFromEntrance().nearestExit(maze3, entrance3));
    }
}
