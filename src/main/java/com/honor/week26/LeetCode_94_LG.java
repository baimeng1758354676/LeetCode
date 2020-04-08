package com.honor.week26;

import java.util.*;

/**
 * 给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @version V1.0
 * @author: LuoGuang
 * @Package com.honor.week26
 * @Description:
 * @date: 2019/12/3 16:21
 */
public class LeetCode_94_LG {


    public static void main(String[] args){
        TreeNode p = new TreeNode(1);
        p.right = new TreeNode(2);
        p.right.left = new TreeNode(3);

        System.out.println("LuoGuang:LeetCode_94_LG.main():"+inorderTraversal(p));
    }
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 执行用时 :
     * 1 ms
     * , 在所有 java 提交中击败了
     * 84.73%
     * 的用户
     * 内存消耗 :
     * 34.7 MB
     * , 在所有 java 提交中击败了
     * 39.36%
     * 的用户
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode treeNode = root;
        List<Integer> result = new ArrayList<>();
        while (stack.size() > 0 || treeNode != null){
            while (null != treeNode){
                stack.push(treeNode);
                treeNode = treeNode.left;
            }
            TreeNode pop = stack.pop();
            result.add(pop.val);
            treeNode = pop.right;

        }

        return result;
    }
}
