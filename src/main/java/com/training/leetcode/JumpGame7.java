package com.training.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class JumpGame7 {
    /*
    You are given a 0-indexed binary string s and two integers minJump and maxJump. In the beginning, you are standing at index 0, which is equal to '0'.
    You can move from index i to index j if the following conditions are fulfilled:

    i + minJump <= j <= min(i + maxJump, s.length - 1), and
    s[j] == '0'.
    Return true if you can reach index s.length - 1 in s, or false otherwise.
     */

    public boolean canReach(String s, int minJump, int maxJump) {

        int m = s.length();

        // Approach 1 : Sliding window + DP
//        int prev = 0; // no of previous indices within minJump, maxJump boundary we can jump from satisfying condition/criteria
//
//        boolean[] dp = new boolean[m];
//
//        //step 1 : base case
//        dp[0] = true;
//
//        for(int i = 1; i < m; i++) {
//
//            if(i >= minJump && dp[i - minJump]) {
//                prev++;
//            }
//
//            if(i > maxJump && dp[i - maxJump - 1]) {
//                prev--;
//            }
//            dp[i] = prev > 0 && s.charAt(i) == '0';
//        }
//
//        return dp[m - 1];


        // Approach 2 : BFS

        Queue<Integer> q = new LinkedList<Integer>();

        q.add(0);

        int maxReach = 0;

        while(!q.isEmpty()) {
            int idx = q.poll();
            if(idx == m - 1) return true;
            for(int i = Math.max(idx + minJump, maxReach); i <= Math.min(idx + maxJump, m - 1); i++){
                if(s.charAt(i) == '0')
                    q.add(i);
            }

            // since we have processed till idx + maxJump so update maxReach to next index
            maxReach = Math.min(idx + maxJump + 1, m - 1);
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(new JumpGame7().canReach("011010",
                2, 3));
    }
}
