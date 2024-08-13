package com.training.leetcode;

public class Maximum69Number {
    public int maximum69Number (int num) {

        int units = 1, n = num, x = 0;
        while(num > 0){
            if(num % 10 == 6) x = 3 * units;
            units *= 10;
            num /= 10;
        }

        return n + x;
    }

    public static void main(String[] args) {
        System.out.println(new Maximum69Number().maximum69Number(6));
        System.out.println(new Maximum69Number().maximum69Number(69));
        System.out.println(new Maximum69Number().maximum69Number(9669));
        System.out.println(new Maximum69Number().maximum69Number(9996));
        System.out.println(new Maximum69Number().maximum69Number(9999));
        Integer.toBinaryString(999);
    }
}
