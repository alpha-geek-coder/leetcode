package com.training.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class BSTSequences {

    public ArrayList<LinkedList<Integer>> allSequences(TreeNode node){

        ArrayList<LinkedList<Integer>> results = new ArrayList<LinkedList<Integer>>();

        if(node == null){
            results.add(new LinkedList<Integer>());
            return results;
        }

        LinkedList<Integer> prefix = new LinkedList<>();

        prefix.add(node.val);

        ArrayList<LinkedList<Integer>> leftSeq = allSequences(node.left);
        ArrayList<LinkedList<Integer>> rightSeq = allSequences(node.right);

        for(LinkedList<Integer> first : leftSeq){
            for(LinkedList<Integer> second : rightSeq){
                ArrayList<LinkedList<Integer>> weavedLists = new ArrayList<>();
                weaveLists(first, second, prefix, weavedLists);
                results.addAll(weavedLists);
            }
        }

        return results;
    }

    public void weaveLists(LinkedList<Integer> first, LinkedList<Integer> second, LinkedList<Integer> prefix, ArrayList<LinkedList<Integer>> weaved){


        if(first.size() == 0 || second.size() == 0){
            LinkedList<Integer> result =  (LinkedList<Integer>) prefix.clone();
            result.addAll(first);
            result.addAll(second);
            weaved.add(result);
            return;
        }

        int headFirst = first.removeFirst();
        prefix.addLast(headFirst);
        weaveLists(first, second, prefix, weaved);
        prefix.removeLast();
        first.addFirst(headFirst);

        int headSecond = second.removeFirst();

        prefix.addLast(headSecond);
        weaveLists(first, second, prefix, weaved);
        prefix.removeLast();
        second.addFirst(headSecond);

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(50);

        int[] bst = new int[]{20,10,25,5,15,60,70,65,80};
     //   int[] bst = new int[]{5,10,15,20,25,60,65,70,80};
        for(int val : bst){
            root.insert(val);
            System.out.println(root.size());
        }

        Random random = new Random();
        int index = random.nextInt(root.size());
        System.out.println(root.getIthNode(index).val);
        System.out.println(new BSTSequences().allSequences(root));

      //  System.out.println(new BSTSequences().deleteNode(root, 50));

        TreeNode root2 = new TreeNode(50);

        int[] bst2 = new int[]{30,70,40,60,80,65};
        //   int[] bst = new int[]{5,10,15,20,25,60,65,70,80};
        for(int val : bst2){
            root2.insert(val);
        }
        System.out.println(new BSTSequences().deleteNodeIterative(root2, 50));

        TreeNode root3 = new TreeNode(5);

        int[] bst3 = new int[]{3,6,2,4,7};
        //   int[] bst = new int[]{5,10,15,20,25,60,65,70,80};
        for(int val : bst3){
            root3.insert(val);
        }
        System.out.println(new BSTSequences().deleteNodeNew(root3, 0));
    }

    public TreeNode deleteNodeNew(TreeNode root, int key) {

        if(root == null) return root;

        TreeNode curr = root, currParent = null;

        while(curr != null){

            if(key < curr.val){
                currParent = curr;
                curr = curr.left;
            } else if(key > curr.val) {
                currParent = curr;
                curr = curr.right;
            } else if(key == curr.val) {

                TreeNode minValueNode = curr.right, minNodeParent = curr;
                while(minValueNode.left != null) {
                    minNodeParent = minValueNode;
                    minValueNode = minValueNode.left;
                }

                minValueNode.left = curr.left;

                if(curr.right != minValueNode) {
                    minNodeParent.left = minValueNode.right;
                    minValueNode.right = curr.right;
                }

                if(currParent == null) {
                    return minValueNode;
                } else if(currParent.left == curr){
                    currParent.left = minValueNode;
                } else {
                    currParent.right = minValueNode;
                }
                return root;
            }

        }

        return root;
    }

    public TreeNode deleteNode(TreeNode root, int value){
        if(root == null) return root;

        if(value < root.val){
            root.left = deleteNode(root.left, value);
            return root;
        } else if(value > root.val){
            root.right = deleteNode(root.right, value);
            return root;
        } else {

            if(root.left == null){
                return root.right;
            } else if(root.right == null){
                return root.left;
            } else {
                TreeNode minNode = root.right;
                while(minNode.left != null){
                    minNode = minNode.left;
                }
                root.val = minNode.val;
                root.right = deleteNode(root.right, minNode.val);
                return root;
            }
        }

    }

    public TreeNode deleteNodeIterative(TreeNode root, int value){
        if(root == null) return root;

        TreeNode parent = null;
        TreeNode curr = root;

        while(curr != null && curr.val != value) {
            parent = curr;
            if(value < curr.val){
                curr = curr.left;
            } else if(value > curr.val){
                curr = curr.right;
            }
        }
        if(parent == null){
            // replace root node
            return deleteNode(curr);
        }

        if(parent.left == curr){
            parent.left = deleteNode(curr);
        } else {
            parent.right = deleteNode(curr);
        }

        return root;
    }

    public TreeNode deleteNode(TreeNode node){

        if(node.left == null){
            return node.right;
        } else if(node.right == null){
            return node.left;
        } else {
            TreeNode minValueNode = node.right;
            TreeNode parent = node;
            while(minValueNode.left != null){
                parent = minValueNode;
                minValueNode = minValueNode.left;
            }
            minValueNode.left = node.left;

            if(node.right != minValueNode){
                parent.left = minValueNode.right;
                minValueNode.right = node.right;
            }
            return minValueNode;
        }
    }

    public static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        int size;

        TreeNode(int value){
            val = value;
            size = 1;
        }

        public TreeNode insert(int value){

            TreeNode curr = this;
            while(true){
                if(value <= curr.val){
                    if(curr.left != null){
                        curr = curr.left;
                        curr.size++;
                    } else {
                        curr.left = new TreeNode(value);
                        break;
                    }
                } else {
                    if(curr.right != null){
                        curr = curr.right;
                        curr.size++;
                    } else {
                        curr.right = new TreeNode(value);
                        break;
                    }
                }

            }
            size++;
            return this;
        }

        public int size() {
            return size;
        }

        public TreeNode getIthNode(int i){
            int leftSize = left == null ? 0 : left.size;
            if(i < leftSize) {
                return left.getIthNode(i);
            } else if( i > leftSize) {
                return right.getIthNode(i - (leftSize + 1));
            } else {
                return this;
            }
        }

    }
}
