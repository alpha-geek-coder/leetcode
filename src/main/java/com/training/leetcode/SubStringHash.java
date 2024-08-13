package com.training.leetcode;

public class SubStringHash {
    public String subStrHash(String s, int power, int modulo, int k, int hashValue) {

        int n = s.length();
        int[] val = new int[n];
        for(int i = 0; i < n; i++){
            val[i] = s.charAt(i) - 'a' + 1;
        }
        int l = 0, r = 0;
        int h = 0;
        while(r < n){
            if(r - l + 1 > k){
                if(h == hashValue){
                    return s.substring(l, r);
                }
                h -= val[l++] % modulo;
                h /= power;
            }
            h += val[r] * (int) Math.pow(power, r - l) % modulo;
            r++;
        }
        return h == hashValue ? s.substring(l, r) : "";
    }

    public static void main(String[] args) {
        System.out.println(new SubStringHash().subStrHash("leetcode", 7, 20, 2, 0));
    }
}
