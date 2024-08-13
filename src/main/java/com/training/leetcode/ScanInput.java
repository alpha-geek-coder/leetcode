package com.training.leetcode;

import java.util.Scanner;

public class ScanInput {
    public static void main(String[] args) {
        System.out.println("Enter your name :");
        Scanner in = new Scanner(System.in);
        String name = in.nextLine();
        in.close();
        System.out.println("Thanks "+ name);
    }
}
