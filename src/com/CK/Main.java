package com.CK;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Solution solution = new Solution();
        System.out.println(solution.subsets(nums).toString());
    }
}

class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        if (nums.length == 0) return res;
        boolean[] visited = new boolean[nums.length];
        List<Integer> dfsList = new ArrayList<>();
        subsetsHelper(nums, visited, dfsList, 0);
        return res;
    }

    private void subsetsHelper(int[] nums, boolean[] visited, List<Integer> dfsList, int first) {
        res.add(new ArrayList<>(dfsList));
        for (int i = first; i < nums.length; i++) {
            if (!visited[i]) {
                dfsList.add(nums[i]);
                visited[i] = true;
                subsetsHelper(nums, visited, dfsList, i + 1);
                dfsList.remove(dfsList.size() - 1);
                visited[i] = false;
            }
        }
    }
}
