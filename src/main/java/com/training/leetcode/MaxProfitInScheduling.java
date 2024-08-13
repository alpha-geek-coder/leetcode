package com.training.leetcode;

import javafx.util.Pair;

import java.util.Arrays;

public class MaxProfitInScheduling {
    int[] startTime, endTime, profit;
    int m;
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {

        this.startTime = startTime;
        this.endTime = endTime;
        this.profit = profit;
        m = startTime.length;
        Pair<Integer, Pair<Integer,Integer>>[] pairs = new Pair[m];
        for(int i = 0; i < m; i++){
            pairs[i] = new Pair(endTime[i], new Pair(startTime[i], profit[i]));
        }
        //Arrays.sort(pairs, (a, b) -> a.getKey().compareTo(b.getKey()));
        Arrays.sort(pairs, (a, b) ->
                a.getKey().intValue() == b.getKey().intValue() ? a.getValue().getKey().compareTo(b.getValue().getKey())
                        : a.getKey().compareTo(b.getKey()));


        for(int i = 0; i < m; i++){
            endTime[i] = pairs[i].getKey();
            startTime[i] = pairs[i].getValue().getKey();
            profit[i] = pairs[i].getValue().getValue();
        }

        int[] dp = new int[m];
        int max = 0;
//        for(int i = 0; i < m; i++){
//            dp[i] = profit[i] + nextJob(endTime[i]);
//            max = Math.max(max, dp[i]);
//        }
        dp[0] = profit[0];
        for(int i = 1; i < m; i++){
            int profitSoFar = profit[i];
            int prevJob = search(startTime[i]);
            if(prevJob != -1) {
                profitSoFar += dp[prevJob];
            }
            dp[i] = Math.max(profitSoFar, dp[i -1]);
        }

        return dp[m -1];
    }

    public int nextJob(int time){
        int maxProfit = 0;
        int next = binarySearch(time);
        if(next == -1) return maxProfit;
        for(int i = next; i < m ; i++){
            maxProfit = Math.max(maxProfit, profit[i] + nextJob(endTime[i]));
        }
        return maxProfit;
    }

    public int binarySearch(int num){
        int l = 0, h = m - 1, idx = -1;
        while(l <= h){
            int mid = l + (h - l) / 2;
            if(startTime[mid] == num) {
                idx = mid;
                h = mid - 1;
            } else if(startTime[mid] < num){
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return idx;
    }
    public int search(int num){
        int l = 0, h = m - 1;
        while(l <= h){
            int mid = l + (h - l) / 2;
            if(endTime[mid] <= num) {
                if(endTime[mid + 1] <= num){
                    l = mid + 1;
                } else {
                    return mid;
                }
            } else {
                h = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] start1 = {1,2,3,3};
        int[] end1 = {3,4,5,6};
        int[] profit1 = {50,10,40,70};
        System.out.println(new MaxProfitInScheduling().jobScheduling(start1, end1 , profit1 ));

        int[] start2 = {1,2,3,4,6};
        int[] end2 = {3,5,10,6,9};
        int[] profit2 = {20,20,100,70,60};
        System.out.println(new MaxProfitInScheduling().jobScheduling(start2, end2 , profit2 ));

        int[] start3 = {1,1,1};
        int[] end3 = {2,3,4};
        int[] profit3 = {5,6,4};
        System.out.println(new MaxProfitInScheduling().jobScheduling(start3, end3 , profit3 ));
    }
}
