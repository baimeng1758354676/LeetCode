package com.honor.pre;

import java.util.Arrays;

/**
 * @Author: 白猛
 * @Date: 2020/1/10 11:37
 */
public class ReversePrint {
    public static void main(String[] args) {
        char[] chars = new char[]{'q', 'w','e','r'};
        reverseString(chars, 0);
        System.out.println(1);
    }

    public static void printReverse(String str, int index) {
        if (str.length() < 1) {
            return;
        }

        printReverse(str.substring(1),index+1);
        System.out.println(str.charAt(0));
    }

    public static void reverseString(char[] s,int index) {
        if (index == s.length - 1) {
            s[0] = s[index];
            return;
        }
        char c = s[index];
        reverseString(s,index+1);
        s[s.length -1-index] =c;
    }
}
