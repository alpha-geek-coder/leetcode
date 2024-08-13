package com.training.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubtreeSameLabel {
    Map<Integer, List<Integer>> adj;
    public int[] countSubTrees(int n, int[][] edges, String labels) {

        adj = new HashMap();
        for(int[] edge : edges){
            int a = edge[0];
            int b = edge[1];
            adj.computeIfAbsent(a, val -> new ArrayList<Integer>()).add(b);
            adj.computeIfAbsent(b, val -> new ArrayList<Integer>()).add(a);
        }


        int[] ans = new int[n];
        dfs(0, -1, labels, ans);
        return ans;
    }

    public int[] dfs(int node, int parent, String labels, int[] ans){
        int[] counts = new int[26];
        if(!adj.containsKey(node)) return counts;
        counts[labels.charAt(node) - 'a'] = 1;
        for(int child : adj.get(node)){
            if(child != parent){
                int[] childCounts = dfs(child, node, labels, ans);
                for(int i = 0; i < 26; i++){
                    counts[i] += childCounts[i];
                }
            }
        }
        ans[node] = counts[labels.charAt(node) - 'a'];
        return counts;

    }

    public static void main(String[] args) {
        int[] ans = new SubtreeSameLabel().countSubTrees(7, new int[][]{{0,1},{0,2},{1,4},{1,5},{2,3},{2,6}},"abaedcd" );
        for(int i = 0; i < ans.length; i++){
            System.out.print(ans[i] + " ");
        }
    }

}
