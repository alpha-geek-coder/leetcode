package com.training.leetcode;

import java.util.*;

public class SumOfDistancesInTree {
    int N;
    List<Set<Integer>> graph;
    int[] count, ans;
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        N = n;
        count = new int[n];
        Arrays.fill(count, 1);
        ans = new int[n];
        graph = new ArrayList<Set<Integer>>();

        for(int node = 0; node < n; node++) {
            graph.add(new HashSet<>());
        }
        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        dfs(0, -1);
        dfs2(0, -1);

        return ans;

    }

    public void dfs(int node, int parent){
        for(int child : graph.get(node)){
            if(child != parent){
                dfs(child, node);
                count[node] += count[child];
                ans[node] += ans[child] + count[child];
            }
        }
    }

    public void dfs2(int node, int parent){
        for(int child : graph.get(node)){
            if(child != parent){
                ans[child] = ans[node] - count[child] + N - count[child];
                dfs2(child, node);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new SumOfDistancesInTree().sumOfDistancesInTree(6, new int[][]{{0,1},{0,2},{2,3},{2,4},{2,5}}));
    }
}
