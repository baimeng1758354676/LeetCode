package com.honor.week22;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * <p>
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * <p>
 * <p>
 * 说明：
 * <p>
 * 给定的 n 保证是有效的。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 执行用时 :
 * 1 ms
 * , 在所有 Java 提交中击败了
 * 90.07%
 * 的用户
 * 内存消耗 :
 * 34.8 MB
 * , 在所有 Java 提交中击败了
 * 86.72%
 * 的用户
 *
 * @Author: 白猛
 * @Date: 2019/10/8 13:54
 */
public class LeetCode_19_BM {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode head = node;
//        node.next = new ListNode(2);
//        node = node.next;
//        node.next = new ListNode(3);
//        node = node.next;
//        node.next = new ListNode(4);
//        node = node.next;
//        node.next = new ListNode(5);

        ListNode result = removeNthFromEnd1(head, 1);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 1;
        ListNode node = head;
        while (node.next != null) {
            node = node.next;
            length++;
        }
        int before = length - n - 1;
        int after = length - n + 1;
        ListNode beforeNode = null;
        ListNode afterNode = null;
        int count = 0;
        node = head;
        while (node != null) {
            if (count == before) {
                beforeNode = node;
            }
            if (count == after) {
                afterNode = node;
                break;
            }
            node = node.next;
            count++;

        }
        if (beforeNode != null) {
            beforeNode.next = afterNode;
        } else {
            head = head.next;
        }
        return head;
    }


    public static ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        for (int i = 0; i <= n; i++) {
            first = first.next;
        }

        while (first != null) {
            first = first.next;
            second = second.next;

        }
        second.next = second.next.next;
        return dummy.next;
    }
}





