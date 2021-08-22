package com.honor.xiaohaoalgorithm;

import java.util.Arrays;

/**
 * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 * 示例 1:
 *
 * 给定 nums = [3,2,2,3], val = 3,
 * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
 * 你不需要考虑数组中超出新长度后面的元素。
 * 这道题比较简单哦，只要把握好“原地删除”这个关键字，就可以顺利求解啦！
 * @Description
 * @Author baimeng
 * @Date 2021/8/20 9:45
 **/
public class InPlaceDelete {

    public static void main(String[] args) {

        int[] a = new int[]{3, 2, 2, 3};
        InPlaceDelete inPlaceDelete = new InPlaceDelete();

        int i = inPlaceDelete.inPlaceDel(a, 3);
        System.out.println(String.format("新长度：%s,新数组：%s", i, Arrays.toString(a)));

    }

    public int inPlaceDel(int[] ints, int value) {

        int mark = -1;


        for (int i = 0; i < ints.length && mark < ints.length; i++) {
            if (ints[i] != value) {
                ints[++mark] = ints[i];
            }
        }
        return mark + 1;
    }

}
