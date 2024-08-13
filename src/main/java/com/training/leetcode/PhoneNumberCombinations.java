package com.training.leetcode;

import java.util.*;

public class PhoneNumberCombinations {
    Map<Integer, List<Character>> codes;
    List<String> ans ;
    public List<String> letterCombinations(String digits) {
        ans = new ArrayList<>();
        if(digits.isEmpty()) return ans;

        codes = new HashMap();
        codes.put(2, Arrays.asList('a', 'b', 'c'));
        codes.put(3, Arrays.asList('d', 'e', 'f'));
        codes.put(4, Arrays.asList('g', 'h', 'i'));
        codes.put(5, Arrays.asList('j', 'k', 'l'));
        codes.put(6, Arrays.asList('m', 'n', 'o'));
        codes.put(7, Arrays.asList('p', 'q', 'r', 's'));
        codes.put(8, Arrays.asList('t', 'u', 'v'));
        codes.put(9, Arrays.asList('w', 'x', 'y', 'z'));

        backtrack(digits, 0, new StringBuilder());

        return ans;
    }

    public void backtrack(String digits, int idx, StringBuilder sb){

        if(sb.length() == digits.length()){
            ans.add(sb.toString());
            return;
        }
        for(int i = idx; i < digits.length(); i++){
            int num = digits.charAt(i) - '0';
            if(codes.containsKey(num)){
                for(int j = 0; j < codes.get(num).size(); j++){
                    sb.append(codes.get(num).get(j));
                    backtrack(digits, i + 1, sb);
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new PhoneNumberCombinations().letterCombinations("23"));
    }
}
