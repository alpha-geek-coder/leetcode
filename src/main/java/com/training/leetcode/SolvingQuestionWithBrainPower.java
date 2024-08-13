package com.training.leetcode;

public class SolvingQuestionWithBrainPower {
    int n;
    long[] memo;
    public long mostPoints(int[][] questions) {
        n = questions.length;
        memo = new long[n];

        return dp(questions, 0);

    }

    public long dp(int[][] questions, int i){
        if(i >= n ) return 0;
        if(memo[i] != 0) return memo[i];

        int points = questions[i][0];
        int brainpower = questions[i][1];
        memo[i] =  Math.max(points + dp(questions, i + brainpower + 1), dp(questions, i + 1));
        return memo[i];
    }

    public static void main(String[] args) {
        System.out.println(new SolvingQuestionWithBrainPower().mostPoints(new int[][]{{3,2},{4,3},{4,4},{2,5}}));
        System.out.println(-1 % 2);
    }
}
