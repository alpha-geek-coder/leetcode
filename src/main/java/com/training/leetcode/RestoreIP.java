package com.training.leetcode;

import java.util.ArrayList;
import java.util.List;

public class RestoreIP {
    List<String> res;
    public List<String> restoreIpAddresses(String s) {
        res = new ArrayList();
        if(s.length() < 4) return res;
        backtrack(s, 0, 0, "");
        return res;
    }

    public void backtrack(String s, int idx, int comp, String ip){
        if(idx == s.length() && isValid(ip)){
            res.add(ip);
            return;
        }
        for(int end = idx; end < idx + 3 && end < s.length() && comp < 4; end++){
            String curr = s.substring(idx, end + 1);
            int currRange = Integer.parseInt(curr);
            if(currRange > 255 || (curr.length() > 1 && curr.charAt(0) == '0')) continue;
            String newIP = ip + curr;
            if(comp < 3) newIP += ".";
            backtrack(s, end + 1, comp + 1, newIP);
        }

    }

    public boolean isValid(String ip){
        String[] split = ip.split("[.]");
        if(split.length != 4) return false;
        for(String s : split){
            if (s.isEmpty()) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new RestoreIP().restoreIpAddresses("25525511135"));
        System.out.println(new RestoreIP().restoreIpAddresses("101023"));
    }
}
