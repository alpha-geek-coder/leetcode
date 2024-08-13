package com.training.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxLengthSubsequenceWithUniqueChars {

    int max = 0;
    public int maxLength(List<String> arr){

        boolean[] unique = new boolean[arr.size()];
        for(int i = 0; i < arr.size(); i++){
            if(isUnique(arr.get(i))) unique[i] = true;
        }

       // int max = 0;
//        for(int i = 0; i < unique.length; i++){
//            if(unique[i]){
//                StringBuilder sb = new StringBuilder();
//                sb.append(arr.get(i));
//
//                for(int j = i + 1; j < unique.length; j++){
//                    if(unique[j]) {
//                        int len = sb.length();
//                        sb.append(arr.get(j));
//                        if(!isUnique(sb.toString())){
//                            sb.delete(len, sb.length());
//                        }
//                    }
//                }
//                max = Math.max(max, sb.length());
//            }
//
//        }
        //StringBuilder sb = new StringBuilder();
        backtrack(arr, 0, unique, "");
        return max;
    }
    public void backtrack(List<String> arr, int idx, boolean[] unique, String s){

        if(idx == arr.size()){
            if(isUnique(s)){
                max = Math.max(max, s.length());
            }
            return;
        }
        for(int i = idx; i < unique.length; i++){
            if(unique[i]){
                backtrack(arr, i + 1, unique,s + arr.get(i));
             //   backtrack(arr, idx + 1, unique,s);
            }
        }

    }

    public boolean isUnique(String s){
        int[] chars = new int[26];

        for(int i = 0; i < s.length(); i++){
            if(chars[s.charAt(i) - 'a'] > 0) return false;
            chars[s.charAt(i) - 'a']++;
        }

        return true;
    }

    public static void main(String[] args) {

        List<String> list = new ArrayList(Arrays.asList("a", "abc", "d", "de", "def"));
        System.out.println(new MaxLengthSubsequenceWithUniqueChars().maxLength(list));

        List<String> list1 = new ArrayList(Arrays.asList("un", "iq", "ue"));
        System.out.println(new MaxLengthSubsequenceWithUniqueChars().maxLength(list1));

        List<String> list2 = new ArrayList(Arrays.asList("cha","r","act","ers"));
        System.out.println(new MaxLengthSubsequenceWithUniqueChars().maxLength(list2));


        List<String> list3 = new ArrayList(Arrays.asList("abcdefghijklmnopqrstuvwxyz"));
        System.out.println(new MaxLengthSubsequenceWithUniqueChars().maxLength(list3));


    }
}
