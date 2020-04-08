package com.honor.pre;

import org.omg.CORBA.StringHolder;

/**
 * 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
 *
 * '?' 可以匹配任何单个字符。
 * '*' 可以匹配任意字符串（包括空字符串）。
 * 两个字符串完全匹配才算匹配成功。
 *
 * 说明:
 *
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。
 * 示例 1:
 *
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 *
 * 输入:
 * s = "aa"
 * p = "*"
 * 输出: true
 * 解释: '*' 可以匹配任意字符串。
 * 示例 3:
 *
 * 输入:
 * s = "cb"
 * p = "?a"
 * 输出: false
 * 解释: '?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
 * 示例 4:
 *
 * 输入:
 * s = "adceb"
 * p = "*a*b"
 * 输出: true
 * 解释: 第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce".
 * 示例 5:
 *
 * 输入:
 * s = "acdcb"
 * p = "a*c?b"
 * 输入: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/wildcard-matching
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: 白猛
 * @Date: 2020/2/25 18:16
 */
public class LeetCode_44_BM {
    public static void main(String[] args) {

        boolean match = isMatch("acdcb", "a*c?b");
        System.out.println(match);

    }

    public static boolean isMatch(String s, String p) {
        if (p == null || p.equals("")) {
            return s == null || s.equals("");
        }

        int sStart = -1, pStart = -1, sLen = s.length(), pLen = p.length(), i = 0, j = 0;
        while (i < sLen) {
            //?和字符相等的情况
            if (j < pLen && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {
                i++;
                j++;
                //单个字符和星号匹配
            } else if (j < pLen && p.charAt(j) == '*') {
                sStart = i;
                pStart = j++;
                //不匹配但是之前有星号
            } else if (pStart > -1) {
                sStart++;
                i = sStart;
                //j指针不动
                j = pStart + 1;
            } else {
                return false;
            }
        }

            while (j < pLen) {
                if (p.charAt(j++) != '*') {
                    return false;
                }
            }

        return true    ;
    }
}
