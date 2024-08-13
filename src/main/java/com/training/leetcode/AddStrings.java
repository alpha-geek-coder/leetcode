package com.training.leetcode;

public class AddStrings {
    public static String addStrings(String num1, String num2) {

        int sum = 0, carry = 0;
        int i = num1.length() - 1, j = num2.length() - 1;
        StringBuilder sb = new StringBuilder();
        while(i >= 0 || j >= 0){
            sum = carry;
            if(i >= 0) sum += num1.charAt(i--) - '0';
            if(j >= 0) sum += num2.charAt(j--) - '0';
            carry = sum / 10;
            sb.append(sum % 10);
        }
        if(carry == 1) sb.append(carry);
        sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(AddStrings.addStrings("456", "77"));
    }
}
