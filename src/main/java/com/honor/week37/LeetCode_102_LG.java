package com.honor.week37;

import java.util.*;

/**
 *
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @version V1.0
 * @author: LuoGuang
 * @Package com.honor.week37
 * @Description:
 * @date: 2020/3/3 16:27
 */
public class LeetCode_102_LG {

    public static void main(String[] args){
        TreeNode p1 = new TreeNode(1);
        p1.right = new TreeNode(3);
        p1.left = new TreeNode(2);
        p1.left.left = new TreeNode(4);
        List<List<Integer>> lists = levelOrder(p1);
        System.out.println("LuoGuang:LeetCode_102_LG.main():"+lists);
    }

    /**
     * 执行用时 :
     * 2 ms
     * , 在所有 Java 提交中击败了
     * 21.42%
     * 的用户
     * 内存消耗 :
     * 38.9 MB
     * , 在所有 Java 提交中击败了
     * 5.08%
     * 的用户
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        List<Integer> nextList = new ArrayList<>();
        List<TreeNode> afterList = new LinkedList();
        while (queue.peek() != null || afterList.size() != 0){
            if (queue.peek() == null){
                lists.add(nextList);
                nextList = new ArrayList<>();
                queue.addAll(afterList);
                afterList = new ArrayList<>();
            }else {
                TreeNode now = queue.poll();
                nextList.add(now.val);
                if (now.left != null){
                    afterList.add(now.left);
                }
                if (now.right != null){
                    afterList.add(now.right);
                }
            }

        }
        if (nextList.size() != 0) {
            lists.add(nextList);
        }
        return lists;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
