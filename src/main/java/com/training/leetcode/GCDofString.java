package com.training.leetcode;

public class GCDofString {
    public String gcdOfStrings(String str1, String str2) {

        int len1 = str1.length(), len2 = str2.length();
        for(int baseLength = Math.min(len1, len2); baseLength >= 1; baseLength--){
            if(validBaseString(str1, str2, baseLength)){
                return str1.substring(0, baseLength);
            }
        }

        return "";
    }

    public boolean validBaseString(String str1, String str2, int baseLength){
        int len1 = str1.length(), len2 = str2.length();

        if(len1 % baseLength > 0 || len2 % baseLength > 0){
            return false;
        } else {
            String baseStr = str1.substring(0, baseLength);
            int n1 = len1 / baseLength, n2 = len2 / baseLength;
            return str1.equals(concatString(baseStr, n1)) && str2.equals(concatString(baseStr, n2));
        }
    }

    public String concatString(String baseStr, int repeatCount){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < repeatCount; i++){
            sb.append(baseStr);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new GCDofString().gcdOfStrings("LEET", "CODE"));
    }
}
