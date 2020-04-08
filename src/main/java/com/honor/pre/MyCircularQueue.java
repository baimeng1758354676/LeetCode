package com.honor.pre;

/**
 * @Author: 白猛
 * @Date: 2019/11/20 17:05
 */
public class MyCircularQueue {
    private int[] list;

    private int first;
    private int last;
    private int size;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        this.list = new int[k];
        this.first = -1;
        this.last=-1;
        this.size =k;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        } else {
            if (isEmpty()) {
                first++;
            }

            last = last + 1 > size - 1 ? last + 1 - size : last + 1;
            list[last] = value;
            return true;
        }
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        } else {
            list[first] = -1;
            //是否最后一个元素出队
            if (first == last) {

                first = -1;
                last = -1;
                return true;
            }

            first = first + 1 > size - 1 ? first + 1 - size : first + 1;

            return true;
        }

    }

    /** Get the front item from the queue. */
    public int Front() {
        if (isEmpty()) {
            return -1;
        } else {
            return list[first];
        }
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if (isEmpty()) {
            return -1;
        } else {
            return list[last];
        }
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return first == -1 && last == -1;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        if(first < last){
            return last - first +1 == size ;
        }else{
            return first == last + 1;
        }

    }
}
