package com.honor.pre;

import java.util.*;

/**
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 说明：
 *
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: 白猛
 * @Date: 2020/1/15 18:46
 */
public class LeetCode_40_BM {
    public static void main(String[] args) {
        int[] nums = new int[]{10,1,2,7,6,1,5};
        List<List<Integer>> lists = combination(nums, 8);
        System.out.println(1);

    }
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<>();
        for (int candidate : candidates) {
            list.add(candidate);
        }
        List<Integer> comb = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        backTack(list,target,result,comb);
        return result;
    }

    private static void backTack(List<Integer> list, int target, List<List<Integer>> result, List<Integer> comb) {
        int count = 0;
        for (Integer integer : comb) {
            count += integer;
        }
        if (target == count) {
//            检查是否已存在
//           A: for (List<Integer> integers : result) {
//                if (integers.size() == comb.size()) {
//                    for (int i = 0; i < comb.size(); i++) {
//                        if (!comb.get(i).equals(integers.get(i))) {
//                            continue A;
//                        }
//                    }
//                    //内层循环走完 表示两个组合重复
//                    return;
//                }
//            }
            result.add(comb);
            return;
        } else if (count > target) {
            return;
        }
        for (int i = 0; i < list.size() ; i++) {
            if (comb.size() > 0 && list.get(i) < comb.get(comb.size() - 1)) {
                continue;
            }
            List<Integer> newComb = new ArrayList<>(comb);
            newComb.add(list.get(i));
            List<Integer> integers = new ArrayList<>(list);
//            integers.remove(i);
            for (int j = 0; j <= i; j++) {
                integers.remove(0);
            }
            backTack(integers, target, result, newComb);
        }
    }


    public static List<List<Integer>> combination(int[] candidates, int target) {
        int len = candidates.length;
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>(len);
        dfs(candidates,len,0,target, path,result);
        return result;
    }

    private static void dfs(int[] candidates, int len, int begin,int reside, Deque<Integer> path, List<List<Integer>> result) {
        if (reside == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i < len; i++) {
            if (reside - candidates[i] < 0) {
                return;
            }

            if (i > 0 && candidates[i] == candidates[i - 1]) {
                continue;
            }
            path.addLast(candidates[i]);
            dfs(candidates,len,i+1,reside-candidates[i],path,result);
        }
    }
}
