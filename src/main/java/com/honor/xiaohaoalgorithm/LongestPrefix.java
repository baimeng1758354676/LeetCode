package com.honor.xiaohaoalgorithm;

/**
 * @Description 题目14: 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。如果不存在公共前缀，则返回""
 * 示例1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释:
 * <p>
 * 输入不存在公共前缀。
 * 说明：
 * <p>
 * 所有输入只包含小写字母 a-z
 * @Author baimeng
 * @Date 2021/8/5 16:00
 **/
public class LongestPrefix {
    public static void main(String[] args) {

//        String[] strings = new String[]{"flower", "flow", "flight"};
        String[] strings = new String[]{"dog", "racecar", "car"};


        LongestPrefix longestPrefix = new LongestPrefix();
        String s = longestPrefix.longestPrefix(strings);
        System.out.println(s);

    }

    public String longestPrefix(String[] strings) {
        String standard = strings[0];

        for (int i = 1; i < strings.length; i++) {

            standard = getPrefixOfTwo(standard, strings[i]);
        }
        return standard;
    }

    private String getPrefixOfTwo(String standard, String string) {

        int index1 = 0, index2 = 0;
        while (index1 < standard.length() && index2 < string.length()) {
            if (standard.charAt(index1) == string.charAt(index2)) {
                index1++;
                index2++;
            } else {
                break;

            }

        }
        return standard.substring(0, index1);
    }

}
