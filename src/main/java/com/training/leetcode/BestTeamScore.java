
package com.training.leetcode;
import java.util.Arrays;

public class BestTeamScore {
    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        int[][] scoresByAge = new int[n][2];
        for(int i = 0; i < n; i ++){
            scoresByAge[i][0] = ages[i];
            scoresByAge[i][1] = scores[i];
        }
        Arrays.sort(scoresByAge,(a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        Integer[][] teams = new Integer[n][n];

       // return findMaxScore(teams, scoresByAge, -1, 0);
        int[] ans = new int[n];
        int best = 0;
        for(int i = 0; i < n; i++){
            ans[i] = scoresByAge[i][1];
            for(int j = 0; j < i; j++){
                if(scoresByAge[i][1] >= scoresByAge[j][1]){
                    ans[i] = Math.max(ans[i], ans[j] + scoresByAge[i][1]);
                }

            }
            best = Math.max(best, ans[i]);
        }

        return best;

    }

    public int findMaxScore(Integer[][] teams, int[][] scoresByAge, int prevIdx, int idx){
        if(idx >= teams.length){
            return 0; // we've iterated over all players for all teams
        }

        if(teams[prevIdx + 1][idx] != null){
            return teams[prevIdx + 1][idx];
        }

        if(prevIdx == -1 || scoresByAge[prevIdx][1] <= scoresByAge[idx][1]){
            return teams[prevIdx + 1][idx] = Math.max(
                    scoresByAge[idx][1] + findMaxScore(teams, scoresByAge, idx, idx + 1),
                    findMaxScore(teams, scoresByAge, prevIdx, idx + 1)
            );
        }

        return teams[prevIdx + 1][idx] = findMaxScore(teams, scoresByAge, prevIdx, idx + 1);

    }

    public static void main(String[] args) {
        System.out.println(new BestTeamScore().bestTeamScore(new int[]{1,3,5,10,15}, new int[] {1,2,3,4,5}));
        System.out.println(new BestTeamScore().bestTeamScore(new int[]{4,5,6,5}, new int[] {2,1,2,1}));
        System.out.println(new BestTeamScore().bestTeamScore(new int[]{1,2,3,5}, new int[] {8,9,10,1}));
    }
}
