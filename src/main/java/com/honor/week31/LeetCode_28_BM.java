package com.honor.week31;

/**
 * @Author: 白猛
 * @Date: 2019/12/9 17:58
 * 实现 strStr() 函数。
 * <p>
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * <p>
 * <p>
 * 说明:
 * <p>
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * <p>
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-strstr
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_28_BM {
    public static void main(String[] args) {
        int i = strStr("aaaaa", "bba");
        System.out.println(i);
    }

    public static int strStr(String haystack, String needle) {
        if (needle == null || needle.length() > haystack.length()) {
            return -1;
        } else if (needle.length() == 0) {
            return 0;
        }
        int l = 0;
        int r = l + needle.length();
        for (; r < haystack.length(); l++, r++) {
            if (haystack.substring(l, r).equals(needle)) {
                return l;
            }
        }
        return -1;
    }
}
