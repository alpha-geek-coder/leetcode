package com.training.leetcode;

import java.util.*;

public class SequentialDigits {
    List<Integer> ans;
    public List<Integer> sequentialDigits(int low, int high) {
        ans = new ArrayList();

        for(int start_digit = 1; start_digit < 10; start_digit++){
            dfs(start_digit, low, high);
        }
        Collections.sort(ans);
        return ans;
    }

    public void dfs(int num, int low, int high){
        if(low <= num && num <= high){
            ans.add(num);
        }
        int last_digit = num % 10 ;
        if(num > high || last_digit == 9) return;
        num = (num * 10) + last_digit + 1;
        dfs(num, low, high);
    }

    public static void main(String[] args) {
        List<Integer> result = new SequentialDigits().sequentialDigits(1000, 13000);
        System.out.println(result);


        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> ans = new ArrayList();
        Map<String, List<String>> map = new HashMap();
        for(String s : strs){
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sorted_str = new String(chars);
            map.computeIfAbsent(sorted_str, k -> new ArrayList()).add(s);
        }
        for(List<String> l : map.values()){
            ans.add(l);
        }
        System.out.println(ans);
    }
}
