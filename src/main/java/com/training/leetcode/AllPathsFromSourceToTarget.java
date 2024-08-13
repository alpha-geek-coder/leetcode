package com.training.leetcode;
import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceToTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(0, graph, res, path);
        return res;
    }

    public void dfs(int node, int[][] graph, List<List<Integer>> res, List<Integer> path){

        if(node == graph.length - 1){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = 0; i < graph[node].length; i++){
            path.add(graph[node][i]);
            dfs(graph[node][i], graph, res, path);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new AllPathsFromSourceToTarget().allPathsSourceTarget(new int[][]{{1,2},{3},{3},{}}));
        System.out.println(new AllPathsFromSourceToTarget().allPathsSourceTarget(new int[][]{{4,3,1},{3,2,4},{3},{4},{}}));
        System.out.println(new AllPathsFromSourceToTarget().allPathsSourceTarget(new int[][]{{4,3,1},{3,2,4},{},{4},{}}));
        System.out.println(new AllPathsFromSourceToTarget().allPathsSourceTarget(new int[][]{{2},{},{1}}));

    }
}
