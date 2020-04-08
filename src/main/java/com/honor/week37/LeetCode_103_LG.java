package com.honor.week37;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回锯齿形层次遍历如下：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @version V1.0
 * @author: LuoGuang
 * @Package com.honor.week37
 * @Description:
 * @date: 2020/3/4 15:06
 */
public class LeetCode_103_LG {

    public static void main(String[] args){
        TreeNode p1 = new TreeNode(3);
        p1.right = new TreeNode(20);
        p1.left = new TreeNode(9);
        p1.right.right = new TreeNode(15);
        p1.left.left = new TreeNode(12);

        List<List<Integer>> lists = zigzagLevelOrder(p1);
        System.out.println("LuoGuang:LeetCode_103_LG.main():"+lists);
    }

    /**
     * 执行用时 :
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 98.62%
     * 的用户
     * 内存消耗 :
     * 38 MB
     * , 在所有 Java 提交中击败了
     * 5.16%
     * 的用户
     * @param root
     * @return
     */
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (result == null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (queue.peek() != null){
            int queueSize = queue.size();
            List<Integer> temp = new ArrayList<>();
            while (queueSize > 0){
                TreeNode now = queue.poll();

                if (result.size() % 2 == 0){
                    temp.add(now.val);
                }else {
                    temp.add(0,now.val);
                }

                if (now.left != null){
                    queue.add(now.left);
                }
                if (now.right != null){
                    queue.add(now.right);
                }
                queueSize--;
            }
            result.add(temp);
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
