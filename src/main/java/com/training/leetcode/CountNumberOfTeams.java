package com.training.leetcode;


class CountNumberOfTeams {
    public int numTeams(int[] rating){
        int n = rating.length;
        Integer[][] increasing_team_cache = new Integer[n][4];
        Integer[][] decreasing_team_cache = new Integer[n][4];

        int teams = 0;
        for(int start_idx = 0; start_idx < n; start_idx++){
            teams += countIncreasingTeams(start_idx, 1, rating, increasing_team_cache) + countDecreasingTeams(start_idx, 1, rating, decreasing_team_cache);
        }
        
        return teams;
    }

    public int countIncreasingTeams(int curr_idx, int team_size, int[] rating, Integer[][] increasing_team_cache){
        int n = rating.length;

        if(curr_idx == n) return 0;

        if(team_size == 3) return 1;

        if(increasing_team_cache[curr_idx][team_size] != null){
            return increasing_team_cache[curr_idx][team_size];
        }

        int teams = 0;
        for(int next_idx = curr_idx + 1; next_idx < n; next_idx++){
            if(rating[next_idx] > rating[curr_idx]){
                teams += countIncreasingTeams(next_idx, team_size + 1, rating, increasing_team_cache);
            }
        }

        return increasing_team_cache[curr_idx][team_size] = teams;
    }

    public int countDecreasingTeams(int curr_idx, int team_size, int[] rating, Integer[][] decreasing_team_cache){
        int n = rating.length;

        if(curr_idx == n) return 0;

        if(team_size == 3) return 1;

        if(decreasing_team_cache[curr_idx][team_size] != null){
            return decreasing_team_cache[curr_idx][team_size];
        }

        int teams = 0;
        for(int next_idx = curr_idx + 1; next_idx < n; next_idx++){
            if(rating[next_idx] < rating[curr_idx]){
                teams += countDecreasingTeams(next_idx, team_size + 1, rating, decreasing_team_cache);
            }
        }

        return decreasing_team_cache[curr_idx][team_size] = teams;
    }

    public static void main(String[] args) {
        System.out.println(new CountNumberOfTeams().numTeams(new int[] {2,5,3,4,1}));
        System.out.println(new CountNumberOfTeams().numTeams(new int[] {2,1,3}));
    }

    
}