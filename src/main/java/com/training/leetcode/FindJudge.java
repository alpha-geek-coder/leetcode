package com.training.leetcode;

import java.util.HashMap;
import java.util.Map;

public class FindJudge {
    public int findJudge(int n, int[][] trust) {

        Map<Integer, Integer> map = new HashMap();
        for(int[] pair : trust){
            int a = pair[0], b= pair[1];
            map.put(a, b);
            map.put(b,a);
        }

        for(int i = 1; i <= n; i++){
            if(!map.containsKey(i)) return i;
        }

        return -1;

    }

    public static void main(String[] args) {
        System.out.println(new FindJudge().findJudge(3, new int[][]{{1,2},{2,3}}));
    }
}
