package com.training.leetcode;

public class UnionFind {
    int[] root, rank;
    int size, numComponents;

    public UnionFind(int size){
        this.size = this.numComponents = size;
        root = new int[size];
        rank = new int[size];
        for(int i = 0; i < size; i++){
            root[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int x){

        int rootX = x;
        while(rootX != this.root[rootX]){
            rootX = this.root[rootX];
        }
        while(x != rootX){
            int next = this.root[x];
            this.root[x] = rootX;
            x = next;
        }

        return rootX;
    }

    public void unify(int x, int y){
        // already connected - do nothing
        if(isConnected(x, y)) return;

        int rootX = find(x);
        int rootY = find(y);

        if(rank[x] > rank[y]){
            // merge root of y with x
            rank[x] += rank[y];
            rank[y] = 0;
            root[rootY] = rootX;
        } else {
            // merge root of x with y
            rank[y] += rank[x];
            rank[x] = 0;
            root[rootX] = rootY;
        }
        // disjointed set, decrement count
        numComponents--;
    }

    public boolean isConnected(int p, int q){
        return find(p) == find(q);
    }

    public int size() {
        return size;
    }

    public int getComponentSize(int p){
        return rank[p];
    }

    public int getNumberOfComponents(){
        return numComponents;
    }

    public static void main(String[] args) {
        UnionFind uf = new UnionFind(10);
        uf.unify(0,1);
        uf.unify(2,3);
        uf.unify(1,3);
        uf.unify(4,8);
        uf.unify(5,7);
        uf.unify(5,6);
        System.out.println(uf.isConnected(0,3));
        System.out.println(uf.isConnected(1,2));
        System.out.println(uf.isConnected(4,8));
        System.out.println(uf.isConnected(5,7));
        System.out.println(uf.isConnected(6,9));
    }
}
