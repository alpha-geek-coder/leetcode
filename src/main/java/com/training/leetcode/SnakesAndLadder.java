package com.training.leetcode;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class SnakesAndLadder {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;

        Pair<Integer, Integer>[] cells = new Pair[n * n + 1];
        Integer[] columns = new Integer[n];
        for(int i = 0; i < n; i++){
            columns[i] = i;
        }
        int cell = 1;
        for(int r = n - 1; r >= 0 ; r--){
            for(int c : columns){
                cells[cell++] = new Pair(r, c);
            }
            Collections.reverse(Arrays.asList(columns));
        }
        int[] dist = new int[n * n + 1];
        Arrays.fill(dist, -1); // distance from starting cell to every other cell is unknown yet.
        Queue<Integer> q = new LinkedList<>();
        q.add(1); // starting position of board
        dist[1] = 0; // distance from starting pos to itself is 0

        while(!q.isEmpty()){
            int curr = q.poll();

            for(int next = curr + 1; next <= Math.min(curr + 6, n * n); next++){
                int row = cells[next].getKey(), col = cells[next].getValue();
                int destination = board[row][col] != -1 ? board[row][col] : next;

                if(dist[destination] == -1){
                    dist[destination] = dist[curr] + 1;
                    q.add(destination);
                }
            }
        }

        return dist[n * n];
    }

    public static void main(String[] args) {
        System.out.println(new SnakesAndLadder().snakesAndLadders(new int[][]
                        {{-1,-1,-1,-1,-1,-1},
                        {-1,-1,-1,-1,-1,-1},
                        {-1,-1,-1,-1,-1,-1},
                        {-1,35,-1,-1,13,-1},
                        {-1,-1,-1,-1,-1,-1},
                        {-1,15,-1,-1,-1,-1}}));
    }
}
