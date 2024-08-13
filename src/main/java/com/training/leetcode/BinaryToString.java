package com.training.leetcode;

public class BinaryToString {
    // num is a real number between 0 and 1 e.g. 0.72, print binary represetation.
    public java.lang.String printBinary(double num){
        if(num >= 1 || num <= 0) return "ERROR";

//        StringBuilder binary = new StringBuilder();
//
//        binary.append("."); // prefix decimal
//
//        while(num > 0){
//
//            if(binary.length() >= 32) return "ERROR";
//            // multiplying a binary decimal with base-10 2 will result in first digit after decimal to be shifted before decimal
//            // e.g. decimal 0.101 (base-2) * 2 (base-10) = 1.01 (base-2), doing this repeatedly we get all binary decimals
//            num = 2 * num;
//            if(num >= 1){
//                binary.append(1);
//                num -= 1;
//            } else {
//                binary.append(0);
//            }
//        }
//
//        return binary.toString();

        StringBuilder sb = new StringBuilder();

        sb.append(".");
        while(num > 0){
            if(sb.length() >= 32) return "ERROR";
            num = 2 * num;
            if(num >= 1){
                sb.append(1);
                num -= 1;
            } else {
                sb.append(0);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new BinaryToString().printBinary( 0.12));
    }
}
