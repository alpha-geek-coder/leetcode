package com.training.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ClosestNodeToTwoNodes {
    public int closestNode(int[] edges, int node1, int node2){
        int n = edges.length;
        int[] dist1 = new int[n];
        Arrays.fill(dist1, Integer.MAX_VALUE);
        int[] dist2 = new int[n];
        Arrays.fill(dist2, Integer.MAX_VALUE);
        bfs(node1, dist1, edges);
        bfs(node2, dist2, edges);
        int minDistNode = -1;
        int minDistTillNow = Integer.MAX_VALUE;

        for(int currNode = 0; currNode < n; currNode++){
            if(minDistTillNow > Math.max(dist1[currNode], dist2[currNode])){
                minDistTillNow = Math.max(dist1[currNode], dist2[currNode]);
                minDistNode = currNode;
            }
        }
        return minDistNode;
    }

    public void bfs(int startNode, int[] dist, int[] edges){

        Queue<Integer> q = new LinkedList<>();
        q.add(startNode);
        dist[startNode] = 0;
        boolean[] visited = new boolean[edges.length];

        while(!q.isEmpty()){
            int currNode = q.poll();
            if(!visited[currNode]){
                int next = edges[currNode];
                if(next != -1 && !visited[next]){
                    dist[next] = dist[currNode] + 1;
                    q.add(next);
                }
                visited[currNode] = true;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new ClosestNodeToTwoNodes().closestNode(new int[] {2,2,3,-1}, 0, 1));
    }
}
