package com.training.leetcode;

import java.util.*;

public class LongestPathWithDifferentAdjacentChars {
    Map<Integer, List<Integer>> childNodes;
    int longestPath = 1;
    public int longestPath(int[] parent, String s) {
        int n = parent.length;
        childNodes = new HashMap();
//        parent[node0] = -1
        for(int node = 1; node < n; node++){
            childNodes.computeIfAbsent(parent[node], val -> new ArrayList<Integer>()).add(node);
        }

        dfs(0, s);

        return longestPath;
    }
    public int longestPathBFS(int[] parent, String s){
        int n = parent.length;
        int[] childrenCounts = new int[n];

        for(int node = 1; node < n; node++){
            childrenCounts[parent[node]]++;
        }
        // first and second longest chains
        int[][] longestChains = new int[n][2];
        Queue<Integer> q = new LinkedList<>();
        // add all leaf nodes to queue
        for(int node = 1; node < n ; node++){
            if(childrenCounts[node] == 0){
                longestChains[node][0] = 1; // size of longest chain is 1 for a leaf
                q.add(node);
            }
        }

        while(!q.isEmpty()){
            int curr = q.poll();
            int p = parent[curr];
            int longestChainFromCurr = longestChains[curr][0];
            if(s.charAt(curr) != s.charAt(p)){
                if(longestChainFromCurr > longestChains[p][0]){
                    longestChains[p][1] = longestChains[p][0];
                    longestChains[p][0] = longestChainFromCurr;
                } else if(longestChainFromCurr > longestChains[p][1]){
                    longestChains[p][1] = longestChainFromCurr;
                }
            }
            longestPath = Math.max(longestPath, longestChains[p][0] + longestChains[p][1] + 1);

            childrenCounts[p]--;
            if(childrenCounts[p] == 0 && p != 0){
                longestChains[p][0]++;
                q.add(p);
            }
        }

        return longestPath;
    }

    public int dfs(int node, String s){

        if(!childNodes.containsKey(node)) return 1;

        int longestChain = 0, secondLongestChain = 0;

        for(int child : childNodes.get(node)){

            int longestChainFromChild = dfs(child, s);

            if(s.charAt(node) != s.charAt(child)){
                if(longestChainFromChild > longestChain){
                    secondLongestChain = longestChain;
                    longestChain = longestChainFromChild;
                } else if(longestChainFromChild > secondLongestChain){
                    secondLongestChain = longestChainFromChild;
                }
            }
        }

        longestPath = Math.max(longestPath,1 + longestChain + secondLongestChain);
        return longestChain + 1;
    }
}
