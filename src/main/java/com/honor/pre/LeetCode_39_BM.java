package com.honor.pre;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: candidates = [c], target = 7,
 * 所求解集为:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://dev.lingkou.xyz/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: 白猛
 * @Date: 2020/1/15 16:27
 */
public class LeetCode_39_BM {
    public static void main(String[] args) {
        int[] nums = new int[]{2,3,5};
        List<List<Integer>> lists = combinationSum(nums, 8);
        System.out.println(1);

    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        //回溯获取所有组合
        List<Integer> comb = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        getComb(candidates, target, comb,result);
        return result;
    }

    private static   void getComb(int[] candidates, int target, List<Integer> comb,List<List<Integer>> result) {
        int count = 0;
        for (Integer integer : comb) {
            count += integer;
        }
        if (count == target) {
            //排序
//            comb.sort(Comparator.comparing(Integer::intValue));
//            //检查是否已存在
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
        for (int i = 0; i < candidates.length; i++) {
            int num = candidates[i];
            ArrayList<Integer> list = new ArrayList<>(comb);
            if (comb.size()>0 && num < comb.get(comb.size()-1)) {
                continue;
            }
            list.add(num);
            getComb(candidates,target,list,result);
        }
    }
}
