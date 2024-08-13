package com.training.leetcode;

public class IntegerToWords {
    private static final String[] below_ten = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine" };
    private static final String[] below_twenty = { "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen" };
    private static final String[] below_hundred =  { "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };
    public String numberToWords(int num){

        if(num == 0) return "Zero";

        return convertToWords(num);

    }

    public String convertToWords(int num){

        if(num < 10){
            return below_ten[num];
        } 
        if(num < 20){
            return below_twenty[num - 10];
        } 
        if(num < 100){
            return below_hundred[(num / 10)] + (num % 10 != 0 ? " " + convertToWords(num % 10) : "");
        }
        if(num < 1000){
            return convertToWords(num / 100) + " Hundred" + (num % 100 != 0 ? " " + convertToWords(num % 100) : "");
        }
        if(num < 1000000){
            return convertToWords(num / 1000) + " Thousand" + (num % 1000 != 0 ? " " + convertToWords(num % 1000) : "");
        }

        if(num < 100000000){
            return convertToWords(num / 1000000) + " Million" + (num % 1000000 != 0 ? " " + convertToWords(num % 1000000) : "");
        }
        
        return convertToWords(num / 1000000000) + " Billion" + (num % 1000000000 != 0 ? " " + convertToWords(num % 1000000000) : ""); 
    
    }

    public static void main(String[] args) {
        System.out.println(new IntegerToWords().numberToWords(1234567891));
    }
}
