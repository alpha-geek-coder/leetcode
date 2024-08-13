package com.training.leetcode;

import java.util.*;

public class NumberOfGoodPaths {
    public int numberOfPaths(int[] vals, int[][] edges){

        int n = vals.length;
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for(int[] edge : edges){
            int a = edge[0], b = edge[1];
            adj.computeIfAbsent(a, val -> new ArrayList<>()).add(b);
            adj.computeIfAbsent(b, val -> new ArrayList<>()).add(a);
        }
        TreeMap<Integer, List<Integer>> valuesToNodes = new TreeMap<>();
        for(int node = 0; node < n; node++){
            valuesToNodes.computeIfAbsent(vals[node], val -> new ArrayList<>()).add(node);
        }
        UnionFind uf = new UnionFind(n);
        int goodPaths = 0;

        for(int value : valuesToNodes.keySet()){
            List<Integer> nodes = valuesToNodes.get(value);
            for(int node : nodes){
                if(!adj.containsKey(node)) continue;
                for(int child : adj.get(node)){
                    if(vals[node] >= vals[child]){
                        uf.unify(node, child);
                    }

                }
            }
            Map<Integer, Integer> group = new HashMap<>();
            for(int node : valuesToNodes.get(value)){
                group.put(uf.find(node), group.getOrDefault(uf.find(node), 0) + 1);
            }

            for(int size : group.values()){
                goodPaths += size * (size + 1)/ 2;
            }
        }

        return goodPaths;

    }
    class UnionFind{
        int[] arr, rank;
        int size, numComponents;

        UnionFind(int s){
            size = s;
            numComponents = s;
            arr = new int[size];
            rank = new int[size];
            for(int i = 0; i < size; i++){
                arr[i] = i;
                rank[i] = 1;
            }
        }
        public int find(int x){
            int rootX = x;
            while(rootX != arr[rootX]){
                rootX = arr[rootX];
            }
            while(x != rootX){
                int next = arr[x];
                arr[x] = rootX;
                x = next;
            }
            return rootX;
        }

        public void unify(int x, int y){
            if(isConnected(x, y)) return;
            int rootX = find(x);
            int rootY = find(y);
            if(rank[x] > rank[y]){
                arr[rootY] = rootX;
                rank[x] += rank[y];
                rank[y] = 0;
            } else {
                arr[rootX] = rootY;
                rank[y] += rank[x];
                rank[x] = 0;
            }
            numComponents--;
        }

        public boolean isConnected(int x, int y){
            return find(x) == find(y);
        }
    }

    public static void main(String[] args) {
        System.out.println(new NumberOfGoodPaths().numberOfPaths(new int[] {1,3,2,1,3}, new int[][] {{0,1},{0,2},{2,3},{2,4}}));
    }
}
