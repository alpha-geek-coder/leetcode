package com.training.leetcode;

import java.util.*;

public class ReconstructItinerary {
    Map<String, PriorityQueue<String>> adj;
    public List<String> findItinerary(List<List<String>> tickets) {
        adj = new HashMap();
        for(List<String> ticket : tickets){
            String from = ticket.get(0);
            String to = ticket.get(1);
            adj.computeIfAbsent(from, v -> new PriorityQueue<>()).add(to);
        }
        List<String> ans = new LinkedList<>();

        dfs("JFK", ans);

        Collections.reverse(ans);

        return ans;
    }

    public void dfs(String node, List<String> ans){

        while(adj.containsKey(node) && !adj.get(node).isEmpty()){
            String neighbor = adj.get(node).poll();
            dfs(neighbor, ans);
        }

        ans.add(node);

    }

    public static void main(String[] args) {
        List<List<String>> tickets = new ArrayList<>();
//        tickets.add(new ArrayList(Arrays.asList("MUC","LHR")));
//        tickets.add(new ArrayList(Arrays.asList("JFK","MUC")));
//        tickets.add(new ArrayList(Arrays.asList("SFO","SJC")));
//        tickets.add(new ArrayList(Arrays.asList("LHR","SFO")));

        tickets.add(new ArrayList(Arrays.asList("JFK","SFO")));
        tickets.add(new ArrayList(Arrays.asList("JFK","ATL")));
        tickets.add(new ArrayList(Arrays.asList("SFO","ATL")));
        tickets.add(new ArrayList(Arrays.asList("ATL","JFK")));
        tickets.add(new ArrayList(Arrays.asList("ATL","SFO")));


        List<String> ans = new ReconstructItinerary().findItinerary(tickets);
        System.out.println(ans);
    }

}
