package com.training.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    List<List<Integer>> ans;

    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();

        backtrack(nums, new boolean[nums.length], new ArrayList<Integer>());

        return ans;
    }

    public void backtrack(int[] nums, boolean[] visited, List<Integer> curr){

        if(curr.size() == nums.length){
            ans.add(new ArrayList<Integer>(curr));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(!visited[i]){
                curr.add(nums[i]);
                visited[i] = true;
                backtrack(nums, visited, curr);
                curr.remove(curr.size() - 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Permutations().permute(new int[]{1,2,3}));
    }
}
