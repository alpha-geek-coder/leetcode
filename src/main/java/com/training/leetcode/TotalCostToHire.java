package com.training.leetcode;

import java.util.PriorityQueue;

public class TotalCostToHire {
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> costs[a] - costs[b]);
        int n = costs.length;
        int l = 0, r = n -1;

        for(int i = 0; i < candidates && l <= r; i++){
            pq.add(l++);
            if(l <= r) pq.add(r--);
        }
        int ans = 0;
        while(k > 0 ){
            int idx = pq.poll();
            ans += costs[idx];
            if(idx <= l) {
                pq.add(l++);
            } else pq.add(r--);
            k--;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new TotalCostToHire().totalCost(new int[]{17,12,10,2,7,2,11,20,8}, 3, 4));
        System.out.println(new TotalCostToHire().totalCost(new int[]{1,2,4,1}, 3, 3));
    }
}
