package com.honor.pre;

import java.util.concurrent.locks.LockSupport;

/**
 * @Author: 白猛
 * @Date: 2020/5/5 14:49
 */
public class OneByOne {

    static Thread t1, t2;

    public static void main(String[] args) {


        char[] chars1 = "123456".toCharArray();
        char[] chars2 = "ABCDEF".toCharArray();
        t1 = new Thread(() -> {
            for (char c : chars1) {
                System.out.println(c);
                LockSupport.unpark(t2);
                LockSupport.park();
            }

        });
        t2 = new Thread(() -> {
            for (char c : chars2) {
                LockSupport.park();
                System.out.println(c);
                LockSupport.unpark(t1);
            }
        });

        t1.start();
        t2.start();


    }


}
