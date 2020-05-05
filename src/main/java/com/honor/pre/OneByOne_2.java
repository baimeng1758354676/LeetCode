package com.honor.pre;

/**
 * @Author: 白猛
 * @Date: 2020/5/5 14:58
 */
public class OneByOne_2 {
    enum ReadyToRun {T1, T2}

    static volatile ReadyToRun readyToRun = ReadyToRun.T1;

    public static void main(String[] args) {
        char[] chars1 = "123456".toCharArray();
        char[] chars2 = "ABCDEF".toCharArray();
        new Thread(() -> {
            for (char c : chars1) {
                while (readyToRun != ReadyToRun.T1) {
                }
                System.out.println(c);
                readyToRun = ReadyToRun.T2;
            }
        }, "t1").start();
        new Thread(() -> {
            for (char c : chars2) {
                while (readyToRun != ReadyToRun.T2) {

                }
                System.out.println(c);
                readyToRun = ReadyToRun.T1;
            }
        }, "t2").start();

    }
}
