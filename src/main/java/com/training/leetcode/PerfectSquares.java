package com.training.leetcode;

import java.util.*;

public class PerfectSquares {

    public int numSquares(int n) {
//        int[] dp = new int[n + 1];
//
//        dp[0] = 0;
//        for (int i = 1; i <= n; i++) {
//            dp[i] = i;
//            for (int j = 1; j * j <= i; j++) {
//                int square = j * j;
//                dp[i] = Math.min(dp[i], dp[i - square] + 1);
//            }
//
//        }
//
//        return dp[n];

        // Approach 2 : BFS

        int level = 0;
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> seen = new HashSet<>();
        q.add(n);
        while(!q.isEmpty()){
            int size = q.size();
            level++;
            for(int i = 0; i < size; i++){
                int curr = q.poll();
                if(!seen.add(curr)) continue;
                for(int j = 1; j * j <= curr; j++){
                    if(curr - j * j == 0) return level;
                    q.add(curr - j * j);
                }
            }
        }

        return level;
    }

    public static void main(String[] args) {
        System.out.println(43 + "--> " + new PerfectSquares().numSquares(43));
        for (int i = 1; i <= 20; i++) {
            System.out.println(i + "--> " + new PerfectSquares().numSquares(i));
        }
//        System.out.println(new PerfectSquares().numSquares(1));
//        System.out.println(new PerfectSquares().numSquares(2));
//        System.out.println(new PerfectSquares().numSquares(12));
//        System.out.println(new PerfectSquares().numSquares(13));
        String[] words = new String[]{"omk"};
        int[] letters = new int[]{2,3,3,2,1,2,2,2,1,2,2,2,3,3,1,1,1,1,2,1,1,3,1,3,1,3};

        List<String> ans = new ArrayList();
        for(int i = 0; i < words.length; i++){
            String word = words[i].toLowerCase();
            int row = letters[word.charAt(0) - 'a'] ;
            for(int j = 0; j < word.length(); j++){
                if(letters[word.charAt(j) - 'a'] != row) break;
                if(j == word.length() - 1) ans.add(words[i]);
            }
        }
        String[] res = ans.toArray(new String[ans.size()]);
    for(String w : res){
        System.out.println(w);
    }
    }
}
