package com.training.leetcode;

public class Cards {

    public enum Suit {
        Club(0), Diamond(1), Heart(2), Spade(3);
        public final int value;
        private Suit(int v){
            value = v;
        }
        public  static Suit getSuitFromValue(int v){
            for(Suit e : values()){
                if(e.value == v) return e;
            }
            return null;
        }
    }

    public static void main(String[] args) {

        System.out.println(Suit.getSuitFromValue(1).value);
    }
}
