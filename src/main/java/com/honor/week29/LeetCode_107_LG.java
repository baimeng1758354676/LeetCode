package com.honor.week29;

import java.util.*;

/**
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其自底向上的层次遍历为：
 *
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @version V1.0
 * @author: LuoGuang
 * @Package com.honor.week29
 * @Description:
 * @date: 2020/1/2 16:10
 */
public class LeetCode_107_LG {

    public static void main(String[] args){
//        TreeNode p = new TreeNode(3);
//        p.left = new TreeNode(9);
//        p.right = new TreeNode(20);
//        p.right.right = new TreeNode(7);
//        p.right.left = new TreeNode(15);

        TreeNode p1 = new TreeNode(1);
        p1.left = new TreeNode(2);
        p1.right = new TreeNode(3);
        p1.right.right = new TreeNode(5);
        p1.left.left = new TreeNode(4);
        System.out.println("LuoGuang:LeetCode_107_LG.main():"+levelOrderBottom(p1));
    }

    /**
     * 执行用时 :
     * 4 ms
     * , 在所有 Java 提交中击败了
     * 7.78%
     * 的用户
     * 内存消耗 :
     * 36.5 MB
     * , 在所有 Java 提交中击败了
     * 39.42%
     * 的用户
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null){
            return result;
        }
        stack.add(root);

        List<TreeNode> next = new ArrayList<>();
        while (!stack.empty() || next.size() != 0){
            if (stack.empty()){
                List<Integer> list = new ArrayList<>();
                for (TreeNode t: next){
                    list.add(t.val);

                    if (t.left != null) {
                        stack.push(t.left);
                    }
                    if (t.right != null) {
                        stack.push(t.right);
                    }

                }
                result.add(0,list);
                next = new ArrayList<>();

            }else {
                next.add(0,stack.pop());
            }
        }

        return result;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
