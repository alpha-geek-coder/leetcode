package com.training.leetcode;

import java.util.ArrayList;
import java.util.List;

public class ChampagneTower {
    public double champagneTower(int poured, int query_row, int query_glass) {
        if(poured == 0) return 0.0;

        int n = query_row + 1;
        List<Double> prev = new ArrayList();
        prev.add((double) poured);
        int r = 1;
        while(r < query_row){
            List<Double>  curr = new ArrayList();
            curr.add(Math.max(0, (prev.get(0) - 1) / 2));
            for(int c = 1; c < prev.size(); c++){
                curr.add(Math.max(0, (prev.get(c - 1) - 1) / 2) + Math.max(0, (prev.get(c) - 1) / 2));
            }
            curr.add(Math.max(0, (prev.get(0) - 1) / 2));
            prev = curr;
            r++;
        }
        return Math.min(1, prev.get(query_glass));
    }

    public static void main(String[] args) {
        System.out.println(new ChampagneTower().champagneTower(3,2,1));

    }
}
