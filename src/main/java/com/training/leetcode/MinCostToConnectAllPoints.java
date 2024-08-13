package com.training.leetcode;



public class MinCostToConnectAllPoints {
    public int minCostConnectPoints(int[][] points) {

        int ans = 0;
        int n = points.length;
        UnionFind uf = new UnionFind(n);
        for(int i = 0; i < n; i++){
            int min_cost = Integer.MAX_VALUE;
            int neighbor = -1;
            for(int j = 0; j < n; j++){
                if(i != j){
                    int x_i = points[i][0], x_j = points[j][0];
                    int y_i = points[i][1], y_j = points[j][1];
                    int cost = Math.abs(Math.abs(x_i - x_j) + Math.abs(y_i - y_j));
                    if(cost < min_cost && !uf.isConnected(i, j)) {
                        min_cost = cost;
                        neighbor = j;
                    }
                }

            }
            if(neighbor != -1) {
                uf.unify(i, neighbor);
                ans += min_cost;
            }

        }

        return ans;
    }

    static class UnionFind{

        int[] nodes, rank;
        int num_components;

        public UnionFind(int n){
            nodes = new int[n];
            rank = new int[n];

            for(int i = 0; i < n; i++){
                nodes[i] = i;
                rank[i] = 1;
            }

            num_components = n;
        }

        public boolean isConnected(int a, int b){
            return find(a) == find(b);
        }

        public int find(int a){

            int root = a;
            while(root != nodes[root]){
                root = nodes[root];
            }

            while(a != root){
                int next = nodes[a];
                nodes[a] = root;
                a = next;
            }
            return root;
        }

        public void unify(int a, int b){
            if(isConnected(a, b)) return;

            int root_a = find(a);
            int root_b = find(b);

            if(rank[root_a] < rank[root_b]){
                nodes[root_a] = root_b;
                rank[root_b] += rank[root_a];
                rank[root_a] = 0;
            } else {
                nodes[root_b] = root_a;
                rank[root_a] += rank[root_b];
                rank[root_b] = 0;
            }
            num_components--;
        }
    }

    public static void main(String[] args) {
//        System.out.println(new MinCostToConnectAllPoints().minCostConnectPoints(new int[][]{{0,0},{2,2},{3,10},{5,2},{7,0}}));
        System.out.println(new MinCostToConnectAllPoints().minCostConnectPoints(new int[][]{{3,12},{-2,5},{-4,1}}));

        int[] row = new int[]{1,1,1,1,0};
        int l = 0, r = row.length - 1;
        while(l < r){
            int mid = l + (r - l) / 2;
            if(row[mid] == 1){
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        System.out.println(l);
    }
}
