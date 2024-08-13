package com.training.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MostStonesRemoved {
    Map<Integer, Integer> id = new HashMap<>();
    int islands = 0;
    public int removeStones(int[][] stones){

        for(int i = 0; i < stones.length; i++){
            int x = stones[i][0];
            int y = ~stones[i][1];
            if(id.putIfAbsent(x, x) == null) islands++;
            if(id.putIfAbsent(y, y) == null) islands++;
            union(x, y);
        }

        return stones.length - islands;
    }

    public void union(int x, int y){
        int rootX = findRootOf(x);
        int rootY = findRootOf(y);

        if(rootX != rootY) {
            id.put(rootX, rootY);
            islands--;
        }
    }

    public int findRootOf(int p){
        // Apply path compression, pointing straight to root rather than traversing each time.
            int root = p;
            while(root != id.get(root)){
                root = id.get(root);
            }
            // compress path leading to the root
            while(p != root){
                int next = id.get(p);
                id.put(next, root);
                p = next;
            }

        return root;
    }

    public static void main(String[] args) {
        System.out.println(new MostStonesRemoved().removeStones(new int[][]{ {0,0}, {0,1}, {1,0}, {1,2}, {2,1}, {2,2}}));
        System.out.println(new MostStonesRemoved().removeStones(new int[][]{ {0,0}}));
        System.out.println(new MostStonesRemoved().removeStones(new int[][]{ {0,0}, {0,2}, {1,1},{2,0},{2,2}}));
    }
}
