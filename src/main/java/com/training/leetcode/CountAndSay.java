package com.training.leetcode;



public class CountAndSay {
    public String countAndSay(int n) {

        String s = "1";
        //return countAndSay(s, n - 1);
        for(int i = 2; i <= n; i++){
            s = count(s);
        }


        return s;
    }

    public String count(String s) {

        StringBuilder sb = new StringBuilder();

        char c = s.charAt(0);
        int count = 1;
        for(int i = 1; i < s.length(); i++) {
            if(c == s.charAt(i)){
                count++;
            } else {
                sb.append(count).append(c);
                count = 1;
                c = s.charAt(i);
            }
        }

        sb.append(count).append(c);

        return sb.toString();
    }

    public String countAndSay(String s, int n){

        if(n == 0) return s;

        StringBuilder sb = new StringBuilder();

        int i = 0;
        int count = 0;
        while(i < s.length()) {
            int curr = i;
            while(curr < s.length() && s.charAt(i) == s.charAt(curr)){
                count++;
                curr++;
            }

            sb.append(count).append(s.charAt(i));
            count = 0;
            i++;
            while(i < s.length() && s.charAt(i) == s.charAt(i - 1)){
                i++;
            }
        }

        return countAndSay(sb.toString(), n - 1);
    }

    public static void main(String[] args) {
        System.out.println(new CountAndSay().countAndSay(4));
    }
}
