package com.honor.pre;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: 白猛
 * @Date: 2020/5/6 11:47
 */
public class OneByOne_3 {
    public static void main(String[] args) {
        char[] chars1 = "123456".toCharArray();
        char[] chars2 = "ABCDEF".toCharArray();
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
//        Condition condition2 = lock.newCondition();
        CountDownLatch latch = new CountDownLatch(1);

        new Thread(() -> {

            try {
                latch.await();
                lock.lock();
                for (char c : chars2) {
                    System.out.println(c);
                    condition.signal();
                    condition.await();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }, "t2").start();


        new Thread(() -> {
            try {
                lock.lock();
                for (char c : chars1) {
                    System.out.println(c);
                    latch.countDown();
                    condition.signal();
                    condition.await();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }, "t1").start();


    }
}
