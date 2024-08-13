package com.training.leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryWatch {

    public List<String>  readBinaryWatch(int turnedOn){

        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int hour = 0; hour < 12; hour++){
            for(int minute = 0; minute < 60; minute++){
                sb.setLength(0);
                if(Integer.bitCount(hour) + Integer.bitCount(minute) == turnedOn){
                    sb.append(hour).append(":").append(String.format("%02d", minute));
                    list.add(sb.toString());
                }
            }
        }

        return list;
    }

    public static void main(String[] args) {
        System.out.println(new BinaryWatch().readBinaryWatch(1));
    }
}
