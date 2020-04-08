package com.honor.pre;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: 白猛
 * @Date: 2020/1/10 14:52
 */
public class ReverseListNode {

//    private static Logger logger = LoggerFactory.getLogger();

    public static void main(String[] args) {

//        ListNode listNode = new ListNode(1);
//        listNode.next = new ListNode(2);
//                listNode.next.next = new ListNode(3);
//        ListNode reverse = reverse(listNode);


//        ListNode swapPairs = swapPairs(listNode);
//        System.out.println(1);

        List<Integer> generate = generate(19);
        System.out.println(1);
    }

   public static   class  ListNode {
      int val;
     ListNode next;
      ListNode(int x) { val = x; }
  }

    public static  ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode first = head;
        ListNode second = head.next;
        ListNode rest = second.next;
        second.next = first;
        first.next = swapPairs(rest);
        return second;
    }

    public static List<Integer> generate(int numRows) {
        List<Integer> result = new ArrayList<>(numRows);
        result.add(0, 1);
        for (int i = 1; i < numRows - 1; i++) {

            result.add(i, getValue(numRows, i));

        }
        result.add(numRows - 1, 1);
        return result;
    }

    private static Map<String, Integer> cache = new HashMap<>();

    private  static Integer getValue(int numRows, int i) {
        if (cache.containsKey(numRows + "" + i)) {
            Integer integer = cache.get(numRows + "" + i);
            System.out.println("缓存取值：  " + integer);
            return integer;
        }
        if (i == 0 || i == numRows - 1) {
            return 1;
        }
        Integer value = getValue(numRows - 1, i - 1) + getValue(numRows - 1, i);
        cache.put(numRows + "" + i, value);
        return value;
    }

    public static ListNode reverse(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode rest = head.next;
        head.next = null;
        ListNode reverse = reverse(rest);
        rest.next = head;
        return reverse;
    }


    private static Map<Integer, Integer> fibCache = new HashMap<>();
    public static int fib(int n) {
        if (fibCache.containsKey(n)) {
            return fibCache.get(n);
        }
        if (n == 0 || n == 1) {
            return n;
        }
        int result =  fib(n - 1) + fib(n - 2);
        fibCache.put(n, result);
        return result;
    }
}
