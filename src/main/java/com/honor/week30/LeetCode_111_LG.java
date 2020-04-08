package com.honor.week30;

/**
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最小深度  2.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @version V1.0
 * @author: LuoGuang
 * @Package com.honor.week30
 * @Description:
 * @date: 2020/1/9 15:47
 */
public class LeetCode_111_LG {

    public static void main(String[] args){
        TreeNode p1 = new TreeNode(3);
        p1.left = new TreeNode(9);
        p1.right = new TreeNode(20);
        p1.right.right = new TreeNode(7);
        p1.right.left = new TreeNode(15);
        p1.right.right.left = new TreeNode(3);
        System.out.println("LuoGuang:LeetCode_111_LG.main():"+minDepth(p1));
    }


    /**
     * 执行用时 :
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 53.70%
     * 的用户
     * 内存消耗 :
     * 38 MB
     * , 在所有 Java 提交中击败了
     * 49.42%
     * 的用户
     * @param root
     * @return
     */
    public static int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return getMinDepth(root,1);
    }
    private static int getMinDepth(TreeNode treeNode,int index){
        if (treeNode == null){
            return index;
        }
        if (treeNode.left == null && treeNode.right == null){
            return index;
        }
        int left=0,right=0;
        if (treeNode.left != null){
            left = getMinDepth(treeNode.left, index+1);
        }
        if (treeNode.right != null){
            right = getMinDepth(treeNode.right,index+1);
        }

        return Math.min(left==0?Integer.MAX_VALUE:left,right==0?Integer.MAX_VALUE:right);
    }
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
