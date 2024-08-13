package com.training.leetcode;

import java.util.PriorityQueue;

public class KweakestRowInMatrix {
    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> (a[0] == b[0]) ? b[1] - a[1] : b[0] - a[0]);

        for(int r = 0; r < m; r++){
            int count = 0;
            // for(int c = 0; c < n; c++){
            //   if(mat[r][c] != 1) break;
            //   count++;
            // }
            // instead use binary search to determine boundary
            count = search(mat[r]);
            pq.add(new int[]{count, r});
            if(pq.size() > k) pq.poll();
        }
        int[] ans = new int[k];
        for(int i = k - 1; i >= 0; i--){
            ans[i] = pq.poll()[1];
        }
        return ans;
    }

    public int search(int[] row){
        int l = 0, r = row.length;
        while(l < r){
            int mid = l + (r - l) / 2;
            if(row[mid] == 1){
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return l;
    }

    public static void main(String[] args) {
        int[][] mat = new int[][]{{1,1,1,1,1},{1,0,0,0,0},{1,1,0,0,0},{1,1,1,1,0},{1,1,1,1,1}};
        int[] ans = new KweakestRowInMatrix().kWeakestRows(mat, 3);
        for(int idx : ans){
            System.out.print(idx + ",");
        }
    }
}
