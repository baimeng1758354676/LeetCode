package com.honor.week23;

import org.apache.commons.lang.StringUtils;

/**
 * 实现 strStr() 函数。
 *
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 * 示例 1:
 *
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 *
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 说明:
 *
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 *
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-strstr
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @version V1.0
 * @author: LuoGuang
 * @Package com.honor.week23
 * @Description:
 * @date: 2019/11/11 18:33
 */
public class LeetCode_28_LG {
    
    public static void main(String[] args){
        String haystack = "a", needle = "a";
        System.out.println(strStr(haystack,needle));
    }

    /**
     * 执行用时 :
     * 7 ms
     * , 在所有 java 提交中击败了
     * 20.78%
     * 的用户
     * 内存消耗 :
     * 37.5 MB
     * , 在所有 java 提交中击败了
     * 43.75%
     * 的用户
     * @param haystack
     * @param needle
     * @return
     */
    public static Integer strStr(String haystack, String needle) {
        if (StringUtils.isEmpty(needle)){
            return 0;
        }
        if (haystack == null || haystack.length()<needle.length()){
            return -1;
        }

        for (int i = 0; i < haystack.length(); i++){
            int tmp = i;
            for (int j = 0;j < needle.length(); j++){
                if (needle.charAt(j) != haystack.charAt(i)){
                    break;
                }
                i++;
                if (j >= needle.length()-1){
                    return tmp;
                }
                if (i >= haystack.length()){
                    return -1;
                }
            }
            i = tmp;
        }
        return -1;
    }

}
