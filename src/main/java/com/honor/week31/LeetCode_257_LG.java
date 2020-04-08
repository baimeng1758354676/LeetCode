package com.honor.week31;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 输入:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * 输出: ["1->2->5", "1->3"]
 *
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @version V1.0
 * @author: LuoGuang
 * @Package com.honor.week31
 * @Description:
 * @date: 2020/1/14 14:19
 */
public class LeetCode_257_LG {

    public static void main(String[] args){
        TreeNode p1 = new TreeNode(1);
        p1.left = new TreeNode(2);
        p1.right = new TreeNode(3);
        p1.left.right = new TreeNode(5);
        List<String> list = binaryTreePaths(p1);
        System.out.println("LuoGuang:LeetCode_257_LG.main():"+list);
    }

    /**
     * 执行用时 :
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗 :
     * 36.2 MB
     * , 在所有 Java 提交中击败了
     * 97.17%
     * 的用户
     * @param root
     * @return
     */
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        if (root != null) {
            addTreePath(list, root, "");
        }
        return list;
    }

    private static void addTreePath(List<String> list, TreeNode root, String path) {
        if (root.left == null && root.right == null){
            path = path + root.val;
            list.add(path);
            return;
        }
        String nextPath = path + root.val + "->";
        if (root.left != null){
            addTreePath(list,root.left,nextPath);
        }
        if (root.right != null){
            addTreePath(list,root.right,nextPath);
        }


    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
