package com.honor.xiaohaoalgorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * <p>
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * @program: cloud-integration
 * @description:
 * @Author: baimeng
 * @Date: 2021/9/5 19:49
 */
public class SumOfTwoNum {
    public static void main(String[] args) {

        int[] a = new int[]{2, 7, 11, 15};
        int target = 9;
        SumOfTwoNum sumOfTwoNum = new SumOfTwoNum();
        int[] ints = sumOfTwoNum.sumOfTwoNum(a, target);

        System.out.println(Arrays.toString(ints));
    }

    public int[] sumOfTwoNum(int[] a, int target) {
        Map<Integer, Integer> cache = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            int currentValue = a[i];
            if (cache.get(target - currentValue) != null) {
                return new int[]{i, cache.get(target - currentValue)};
            }
            cache.put(currentValue, i);
        }
        return new int[]{};
    }

}
