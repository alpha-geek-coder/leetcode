package com.training.leetcode;

import java.util.*;

public class PathSumIII {

    public static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int value) {
            val = value;
        }

        TreeNode insert(List<Integer> values, int i) {
            if (i >= values.size()) return null;

            List<TreeNode> queue = new ArrayList<TreeNode>();
            queue.add(this);
            while (queue.size() > 0) {
                TreeNode current = queue.get(0);
                queue.remove(0);
                if(values.get(i) == null) break;
                if (current.left == null) {
                    current.left = new TreeNode(values.get(i));
                    break;
                }
                queue.add((TreeNode) current.left);
                if (current.right == null) {
                    current.right = new TreeNode(values.get(i));
                    break;
                }
                queue.add((TreeNode) current.right);
            }
            insert(values, i + 1);
            return this;
        }

    }

    public TreeNode buildBinaryTree(Integer[] array) {

//        TreeNode root = new TreeNode(array[0]);

//      //  int lowestLevelParentIdx = ((array.length - 1) - 1) / 2;
//        Queue<Pair<Integer, TreeNode>> q = new LinkedList();
//        q.add(new Pair(-1, root));
//
//        while(!q.isEmpty()) {
//            Pair<Integer, TreeNode> pair = q.poll();
//            int idx = pair.getKey();
//           // if(idx > lowestLevelParentIdx) continue;
//
//            TreeNode curr = pair.getValue();
//
//            int leftChildIdx = idx + 2;
//            if(leftChildIdx < array.length && array[leftChildIdx] != null){
//                curr.left = new TreeNode(array[leftChildIdx]);
//              //  if(leftChildIdx <= lowestLevelParentIdx)
//                    q.add(new Pair(leftChildIdx, curr.left));
//            }
//            int rightChildIdx = leftChildIdx + 1;
//            if(rightChildIdx < array.length && array[rightChildIdx] != null){
//                curr.right = new TreeNode(array[rightChildIdx]);
//              //  if(rightChildIdx <= lowestLevelParentIdx)
//                    q.add(new Pair(rightChildIdx, curr.right));
//            }
//          //  System.out.println(array[parentIdx] + " " + array[leftChildIdx] + " " + array[rightChildIdx]);
//        }

       // return insertLevelOrder(array, 0);
        Queue<Integer> intQ = new LinkedList<>();
        Queue<TreeNode> nodeQ = new LinkedList();
        for(int i = 1; i < array.length; i++){
            intQ.add(array[i]);
        }
        TreeNode root = new TreeNode(array[0]);
        nodeQ.add(root);

        while(!nodeQ.isEmpty()){
            TreeNode curr = nodeQ.poll();
            Integer leftVal = intQ.isEmpty() ? null : intQ.poll();
            Integer rightVal = intQ.isEmpty() ? null : intQ.poll();

            if(leftVal != null){
                curr.left = new TreeNode(leftVal);
                nodeQ.add(curr.left);
            }

            if(rightVal != null){
                curr.right = new TreeNode(rightVal);
                nodeQ.add(curr.right);
            }

        }
        return root;
    }

    public TreeNode insertLevelOrder(Integer[] arr, int i){
        TreeNode root = null;
        // Base case for recursion
        if (i < arr.length && arr[i] != null) {
            root = new TreeNode(arr[i]);

            // insert left child
            root.left = insertLevelOrder(arr, 2 * i + 1);

            // insert right child
            root.right = insertLevelOrder(arr, 2 * i + 2);
        }
        return root;

    }

    public int pathSum(TreeNode root, int targetSum) {

        if(root == null) return 0;

        int pathsFromRoot = pathSumFromNode(root, targetSum, 0);

        int pathsFromLeft = pathSum(root.left, targetSum);

        int pathsFromRight = pathSum(root.right, targetSum);

        return pathsFromRoot + pathsFromLeft + pathsFromRight;

    }

    public int pathSumFromNode(TreeNode node, long targetSum, long runningSum) {

        if(node == null) return 0;

        runningSum += node.val;

        int totals = 0;
        if(runningSum == targetSum){
            totals++;
        }

        totals += pathSumFromNode(node.left, targetSum, runningSum);

        totals += pathSumFromNode(node.right, targetSum, runningSum);

        return totals;

    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(10).insert(Arrays.asList(5,-3,3,2,null,11,3,-2,null,1), 0);
 //       TreeNode root = new PathSumIII().buildBinaryTree(new Integer[]{1000000000,1000000000,null,294967296,null,1000000000,null,1000000000,null,1000000000});
       // TreeNode root = new PathSumIII().buildBinaryTree(new Integer[]{10,5,-3,3,2,null,11,3,-2,null,1});
        System.out.println(new PathSumIII().pathSum(root, 0));
    }
}
