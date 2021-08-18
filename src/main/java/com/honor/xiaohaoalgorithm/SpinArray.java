package com.honor.xiaohaoalgorithm;

import java.util.Arrays;

/**
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * 示例 1:
 * <p>
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * <p>
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 * <p>
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * <p>
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * 说明:
 * <p>
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * <p>
 * 要求使用空间复杂度为 O(1) 的 原地 算法。
 *
 * @Description
 * @Author baimeng
 * @Date 2021/8/17 9:59
 **/
public class SpinArray {
    public static void main(String[] args) {

//        int[] a = new int[]{1,2,3,4,5,6,7};
//
//        SpinArray spinArray = new SpinArray();
//        spinArray.spinArray(a,3);


        int[] a = new int[]{-1, -100, 3, 99};

        SpinArray spinArray = new SpinArray();
        spinArray.spinArray(a, 2);

        System.out.println(Arrays.toString(a));

    }


    public void spinArray(int[] ints, int k) {
        reverseArray(ints, 0, ints.length - 1);
        reverseArray(ints, 0, k - 1);
        reverseArray(ints, k, ints.length - 1);

    }

    public void reverseArray(int[] ints, int start, int end) {
        while (start < end) {
            exchange(ints, start, end);
            start++;
            end--;
        }

    }

    private void exchange(int[] ints, int start, int end) {
        if (start < end) {

            int temp = ints[start];

            ints[start] = ints[end];
            ints[end] = temp;
        }

    }
}
