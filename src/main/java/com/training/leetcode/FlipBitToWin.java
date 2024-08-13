package com.training.leetcode;

import java.util.ArrayList;

public class FlipBitToWin {
    public int longestSequence(int n){

        if(~n == 0) return Integer.BYTES * 8; // if all are 1s in n already

        ArrayList<Integer> sequences = getSequences(n);
        return findLongestSequences(sequences);
    }

    public ArrayList<Integer> getSequences(int n){

        ArrayList<Integer> sequences = new ArrayList<>();

        int searchingFor = 0;
        int count = 0;

        for(int i = 0; i < Integer.BYTES * 8; i++){
            if( (n & 1) != searchingFor){
                sequences.add(count);
                count = 0;
                searchingFor = n & 1; // flip 1 to 0 or 0 to 1
            }
            count++;
            n >>>= 1;
        }
        sequences.add(count);
        return sequences;
    }

    public int findLongestSequences(ArrayList<Integer> sequences){
        int maxSeq = 0;
        for(int i = 0; i < sequences.size(); i += 2){
            int leftSeq = i - 1 >= 0 ? sequences.get(i - 1) : 0;
            int zeroSeq = sequences.get(i);
            int rightSeq = i + 1 < sequences.size() ? sequences.get(i + 1) : 0;

            int thisSeq = 0;
            if(zeroSeq == 1){
                thisSeq = leftSeq + 1 + rightSeq;
            } else if(zeroSeq > 1){
                thisSeq = 1 + Math.max(leftSeq, rightSeq);
            } else if(zeroSeq == 0){
                thisSeq = Math.max(leftSeq, rightSeq);
            }
            maxSeq = Math.max(maxSeq, thisSeq);
        }

        return maxSeq;
    }
}
