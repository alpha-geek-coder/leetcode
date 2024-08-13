package com.training.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PermutationOFArray {
    List<List<Integer>> ans;
    public List<List<Integer>> permutation(int[] arr){

         ans = new ArrayList<>();

        rec(arr, 0);

        return ans;
    }

    public void rec(int[] arr, int startIdx){
        if(startIdx == arr.length){
            List<Integer> tmp = Arrays.stream(arr).boxed().collect(Collectors.toList());
            ans.add(tmp);
        } else {
            for(int endIdx = startIdx; endIdx < arr.length; endIdx++){
                swap(arr, startIdx, endIdx);
                rec(arr, startIdx + 1);
                swap(arr, startIdx, endIdx);
            }
        }
    }

    public void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        System.out.println(new PermutationOFArray().permutation(new int[]{1,2,3}));
    }
}
