package com.training.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javafx.util.Pair;

public class AddToArray {
    public List<Integer> addToArrayForm(int[] num, int k) {

        List<Integer> ans = new ArrayList<>();
        int curr = k, i = num.length - 1;
        while(i >= 0 || curr > 0){
            if(i >= 0) curr += num[i];
            ans.add(curr % 10);
            curr /= 10;
            i--;
        }

        Collections.reverse(ans);
        return ans;
    }

    public static void main(String[] args) {
       // System.out.println(new AddToArray().addToArrayForm(new int[] {1,2,0,0}, 34));
        System.out.println(new AddToArray().addToArrayForm(new int[] {9,9,9,9,9,9,9,9,9,9}, 1));
        Pair<Integer, Integer> pair = new Pair(1, 2);
        
    }
}
