package com.training.leetcode;

import java.util.*;

public class PossibleBipartisan {
    public boolean possibleBipartition(int n, int[][] dislikes) {

        Map<Integer, List<Integer>> adjList = new HashMap<>();


        for(int[] edge : dislikes){
            int a = edge[0], b = edge[1];
            adjList.computeIfAbsent(a, x -> new ArrayList<Integer>()).add(b);
            adjList.computeIfAbsent(b, x -> new ArrayList<Integer>()).add(a);
        }
        UnionFind uf = new UnionFind(n + 1);
        for(int node = 1; node <= n; node++){
            if(!adjList.containsKey(node)) continue;
            for(Integer neighbor : adjList.get(node)){
                if(uf.findRoot(neighbor) == uf.findRoot(node)){
                    return false;
                }
                uf.union(adjList.get(node).get(0), neighbor);
            }
        }
        return true;

    }
    public boolean possibleBipartitionBFS(int n, int[][] dislikes) {

        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int[] edge : dislikes) {
            int a = edge[0], b = edge[1];
            adjList.computeIfAbsent(a, x -> new ArrayList<Integer>()).add(b);
            adjList.computeIfAbsent(b, x -> new ArrayList<Integer>()).add(a);
        }
        int[] color = new int[n + 1]; // 0 - RED, 1 - BLUE
        Arrays.fill(color, -1); // set to uncolored -1

        for(int node = 1; node <= n; node++){
            if(color[node] == -1){
                // BFS for uncolored nodes
                if(!bfs(node, adjList, color)){
                    return false;
                }
            }
        }

        return true;
    }

    public boolean bfs(int source, Map<Integer, List<Integer>> adjList, int[] color){

        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        color[source] = 0 ; // pick RED as default color

        while(!q.isEmpty()){
            int node = q.poll();
            if(!adjList.containsKey(node)) continue;
            for(Integer neighbor : adjList.get(node)){
                if(color[neighbor] == color[node]){
                    return false;
                }
                if(color[neighbor] == -1){
                    color[neighbor] = 1 - color[node]; // flip color from current node
                    q.add(neighbor);
                }
            }
        }
        return true;
    }
    public class UnionFind{
        int[] rank;
        int size, numComponents;
        int[] arr;

        public UnionFind(int s){
            size = numComponents = s;
            arr = new int[s];
            rank = new int[s];
            for(int i = 0; i < s; i++){
                arr[i] = i;
                rank[i] = 1;
            }
        }

        public int getNumComponents(){
            return numComponents;
        }

        public int getSize() {
            return size;
        }

        public void union(int x, int y){
            int rootX = findRoot(x);
            int rootY = findRoot(y);

            if(rootX == rootY) return;
            if(rank[x] > rank[y]){
                rank[x] += rank[y];
                rank[y] = 0;
                arr[y] = rootX;
            } else {
                rank[y] += rank[x];
                rank[x] = 0;
                arr[x] = rootY;
            }
            numComponents--;
        }

        public int findRoot(int x){
            int root = x;
            while(root != arr[root]){
                root = arr[root];
            }

            while(x != root){
                int next = arr[x];
                arr[x] = root;
                x = next;
            }
            return root;
        }
    }

    public static void main(String[] args) {

        System.out.println(new PossibleBipartisan().possibleBipartition(4, new int[][]{{1,2},{1,3},{2,4}}));
        System.out.println(new PossibleBipartisan().possibleBipartition(3, new int[][]{{1,2},{1,3},{2,3}}));
        System.out.println(new PossibleBipartisan().possibleBipartition(5, new int[][]{{1,2},{2,3},{3,4},{4,5},{1,5}}));

    }
}
