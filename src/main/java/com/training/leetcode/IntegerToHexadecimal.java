package com.training.leetcode;



public class IntegerToHexadecimal {

    public static String toHex(int num) {

        if(num == 0) return "0";

        StringBuilder sb = new StringBuilder();

//        char[] hex = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
//
//        for(int i = 1; i <= Byte.SIZE && num != 0; i++){
//            sb.append(hex[num & 15]);
//            num = num >>> 4;
//        }
//
//        return sb.reverse().toString();
        char[] hex = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        int base = 16;
        long n = 0x00000000ffffffffL;
        while(n != 0){

            sb.append(hex[(int) n % base]);
            n /= base;
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(IntegerToHexadecimal.toHex(-1));
        System.out.println(IntegerToHexadecimal.toHex(0));
        System.out.println(IntegerToHexadecimal.toHex(26));
    }
}
