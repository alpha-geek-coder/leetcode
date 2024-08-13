package com.training.leetcode;

import java.util.*;

public class CheapestFlight {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> adj = new HashMap<>();

        for(int[] flight : flights){
            int from = flight[0];
            int to = flight[1];
            int price = flight[2];
            adj.computeIfAbsent(from, val -> new ArrayList<>()).add(new int[] {to, price});
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{src, 0}); // start from source with priceSoFar = 0

        int stops = 0;

        while(stops <= k && !q.isEmpty()){
            int size = q.size();

            for(int i = 0; i < size; i++){
                int[] curr = q.poll();
                int from = curr[0];
                int priceSoFar = curr[1];
                if(!adj.containsKey(from)) continue;
                List<int[]> neighbors = adj.get(from);
                for(int[] neighbor : neighbors){
                    if(neighbor[1] + priceSoFar >= dist[neighbor[0]]) continue;
                    dist[neighbor[0]] = neighbor[1] + priceSoFar;
                    q.add(new int[] {neighbor[0], neighbor[1] + priceSoFar});
                }

            }
            stops++;
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}
