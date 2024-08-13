package com.training.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    List<List<Integer>> ans;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ans = new ArrayList();
        Arrays.sort(candidates);
        backtrack(candidates,target, 0, new ArrayList<Integer>());

        return ans;
    }
    public void backtrack(int[] candidates, int target, int start_idx, List<Integer> curr){
        if(target < 0) return;
        if(target == 0){
            ans.add(new ArrayList<>(curr));
            return;
        }
        
        for(int idx = start_idx; idx < candidates.length ; idx++){
            if(idx > start_idx && candidates[idx] == candidates[idx - 1]) continue; 
            int candidate = candidates[idx];
            if(candidate <= target){
                curr.add(candidate);
                backtrack(candidates, target - candidate, idx + 1, curr);
                curr.remove(curr.size() - 1);
            }

        }

    }

    public static void main(String[] args) {
        System.out.println(new CombinationSumII().combinationSum2(new int[]{10,1,2,7,6,1,5}, 8));
    }
}
