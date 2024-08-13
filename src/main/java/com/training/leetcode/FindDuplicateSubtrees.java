package com.training.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindDuplicateSubtrees {
    /*
    Given the root of a binary tree, return all duplicate subtrees.

For each kind of duplicate subtrees, you only need to return the root node of any one of them.

Two trees are duplicate if they have the same structure with the same node values.
     */
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> ans = new ArrayList<>();
        HashMap<String, Integer> tripletToID = new HashMap<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        postOrder(root, tripletToID, map, ans);

        return ans;
    }

    public int postOrder(TreeNode node, HashMap<String, Integer> tripletToID, HashMap<Integer, Integer> map, List<TreeNode> ans){

        if(node == null) return 0;

        String subTree = postOrder(node.left, tripletToID, map, ans) + ""
                + node.val + "" + postOrder(node.right, tripletToID, map, ans);

        if(!tripletToID.containsKey(subTree)){
            tripletToID.put(subTree, tripletToID.size() + 1);
        }
        int tripletID = tripletToID.get(subTree);
        map.put(tripletID, map.getOrDefault(tripletID, 0) + 1);
        if(map.get(tripletID) == 2){
            ans.add(node);
        }

        return tripletID;
    }

    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
