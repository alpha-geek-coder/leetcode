package com.training.leetcode;

import javafx.util.Pair;

import java.util.Collections;
import java.util.PriorityQueue;

public class IPO {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        PriorityQueue<Pair<Integer, Integer>> sortedProjects = new PriorityQueue<Pair<Integer, Integer>>(n, (a, b) -> Integer.compare(a.getKey(), b.getKey()));

        for(int i = 0; i < n; i++){
            sortedProjects.add(new Pair(capital[i], profits[i]));
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(n, Collections.reverseOrder());

        for(int i = 0; i < k; i++){
            while(!sortedProjects.isEmpty() && sortedProjects.peek().getKey().intValue() <= w){
                pq.add(sortedProjects.poll().getValue());
            }
            if(pq.isEmpty()) break;
            w += pq.poll();
        }
        return w;
    }

    public static void main(String[] args) {
        System.out.println(new IPO().findMaximizedCapital(2, 0, new int[]{1, 2, 3}, new int[] {0,1,1}));
    }
}
