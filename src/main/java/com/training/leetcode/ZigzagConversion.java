package com.training.leetcode;

public class ZigzagConversion {
    public String convert(String s, int numRows) {

        StringBuilder[] sb = new StringBuilder[numRows];
        for(int row = 0; row < numRows; row++){
            sb[row] = new StringBuilder();
        }

        int i = 0;
        while(i < s.length()){
            for(int row = 0; row < numRows && i < s.length(); row++){
                sb[row].append(s.charAt(i));
                i++;
            }
            for(int row = numRows - 2; row >= 1 && i < s.length(); row--){
                sb[row].append(s.charAt(i));
                i++;
            }


        }

        StringBuilder ans = new StringBuilder();
        for(StringBuilder r : sb){
            ans.append(r.toString());
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(new ZigzagConversion().convert("PAYPALISHIRING", 1));
        System.out.println(new ZigzagConversion().convert("PAYPALISHIRING", 2));
        System.out.println(new ZigzagConversion().convert("PAYPALISHIRING", 3));
        System.out.println(new ZigzagConversion().convert("PAYPALISHIRING", 4));
        System.out.println(new ZigzagConversion().convert("A", 1));
        System.out.println(new ZigzagConversion().convert("AB", 1));
        System.out.println(new ZigzagConversion().convert("AB", 2));
    }
}
