package com.training.leetcode;

import java.util.*;

public class SHortestAlternatingPath {

    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        // Map adjacency list by node and color fromNode -> [[toNode, 0 or 1], ...]
        // 0 - denotes red edge
        // 1 - denotes blue edge
        for(int[] redEdge : redEdges){
            int fromNode = redEdge[0], toNode = redEdge[1];
            adj.computeIfAbsent(fromNode, k -> new ArrayList<>()).add(new int[]{toNode, 0});
        }

        for(int[] blueEdge : blueEdges){
            int fromNode = blueEdge[0], toNode = blueEdge[1];
            adj.computeIfAbsent(fromNode, k -> new ArrayList<>()).add(new int[]{toNode, 1});
        }

        int[] ans = new int[n]; // return answer
        Arrays.fill(ans, -1); // fill with default distance -1 (no possible answer)
        // nodes visited by red and blue edge, hence [n][2] size
        boolean[][] visited = new boolean[n][2];
        visited[0][0] = true; // initialise as node 0 is visited through red edge
        visited[0][1] = true; // initialise as node 0 is visited through red edge

        Queue<int[]> q = new LinkedList<>();
        // Queue contains integer triplet
        //[0] - current node
        //[1] - distance from node 0 to current node
        //[2] - color of previous edge
        // start from node = 0, steps/distance = 0, color = -1 (undefined)
        q.add(new int[]{0, 0, -1});
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int currNode = curr[0];
            int dist = curr[1];
            int prevColor = curr[2];
            if(!adj.containsKey(currNode)) continue;

            for(int[] neighbors : adj.get(currNode)){
                int neighbor = neighbors[0];
                int color = neighbors[1];
                // unvisited node by colored edge that is different from prev edge color
                if(!visited[neighbor][color] && color != prevColor){
                    if(ans[neighbor] == -1){
                        ans[neighbor] = 1 + dist;
                    }
                    visited[neighbor][color] = true;
                    q.add(new int[]{neighbor, 1 + dist, color});
                }

            }
        }

        return ans;

    }
}
