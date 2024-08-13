package com.training.leetcode;

import java.util.*;

public class DistanceLimitedPathExists {
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        boolean[] ans = new boolean[queries.length];
        UnionFind uf = new UnionFind(n);
        int numQueries = queries.length;

        int[][] queriesWithIndex = new int[numQueries][4];
        for(int queryIdx = 0; queryIdx < numQueries; queryIdx++){
            queriesWithIndex[queryIdx][0] = queries[queryIdx][0];
            queriesWithIndex[queryIdx][1] = queries[queryIdx][1];
            queriesWithIndex[queryIdx][2] = queries[queryIdx][2];
            queriesWithIndex[queryIdx][3] = queryIdx;
        }
        // Sort queries by distance
        sort(queries);
        // Sort queries with index by distance
        sort(queriesWithIndex);
        // initial edge index to 0
        int edgeIdx = 0;
        for(int queryIdx = 0; queryIdx < numQueries; queryIdx++){
            int p = queriesWithIndex[queryIdx][0];
            int q = queriesWithIndex[queryIdx][1];
            int limit = queriesWithIndex[queryIdx][2];
            int queryOriginalIdx = queriesWithIndex[queryIdx][3];

            while(edgeIdx < edgeList.length && edgeList[edgeIdx][2] < limit){
                uf.unify(edgeList[edgeIdx][0], edgeList[edgeIdx][1]);
                edgeIdx++;
            }

            ans[queryOriginalIdx] = uf.isConnected(p,q);
        }

        return ans;
    }

    public void sort(int[][] array){
        Arrays.sort(array, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[2], o2[2]);
            }
        });
    }

    class UnionFind{
        int[] arr;
        int[] rank;
        int size;
        int numComponents;
        UnionFind(int n){
            arr = new int[n];
            rank = new int[n];
            size = n;
            numComponents = n;
            for(int i = 0; i < n; i++){
                arr[i] = i;
                rank[i] = 1;
            }
        }

        public void unify(int x, int y){
            if(isConnected(x, y)) return;
            int rootX = findRoot(x);
            int rootY = findRoot(y);
            if(rank[rootX] > rank[rootY]){
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

        public boolean isConnected(int x , int y){
            return findRoot(x) == findRoot(y);
        }

    }

    public static void main(String[] args) {
        int[][] edgeList1 = new int[][]{{0,1,2},{1,2,4},{2,0,8},{1,0,16}};
        int[][] queries1 = new int[][]{{0,1,2},{0,2,5}};
        boolean[] ans1 = new DistanceLimitedPathExists().distanceLimitedPathsExist(3, edgeList1, queries1);
        for(boolean ans : ans1){
            System.out.print(ans + " ");
        }
        System.out.println();
        int[][] edgeList2 = new int[][]{{0,1,10},{1,2,5},{2,3,9},{3,4,13}};
        int[][] queries2 = new int[][]{{0,4,14},{1,4,13}};
        boolean[] ans2 = new DistanceLimitedPathExists().distanceLimitedPathsExist(5, edgeList2, queries2);

        for(boolean ans : ans2){
            System.out.print(ans + " ");
        }
    }
}
