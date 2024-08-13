package com.training.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MinSubstringWithoutDuplicates {

    public int minSubStringWithoutDuplicates(String s){
//        int[] last_index = new int[26];
//        Arrays.fill(last_index, -1);
//        int n = s.length();
//        int ans = 1;
//        for(int l = 0, r = 0; r < n; r++){
//            int c = s.charAt(r) - 'a';
//            if(last_index[c] >= l){
//                l = last_index[c] + 1;
//                ans++;
//            }
//            last_index[c] = r;
//        }

        int n = s.length(), ans = 1;
        Map<Character, Integer> last_occurence = new HashMap<>();
        for(int l = 0, r = 0; r < n; r++){
            char c = s.charAt(r);
            if(last_occurence.getOrDefault(c, -1) >= l) {
                l = last_occurence.getOrDefault(c, -1) + 1;
                ans++;
            }
            last_occurence.put(c, r);
        }
      
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new MinSubstringWithoutDuplicates().minSubStringWithoutDuplicates("cyclec"));
    }
}
