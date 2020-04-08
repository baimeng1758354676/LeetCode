package com.honor.week36;

/**
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过根结点。
 *
 * 示例 :
 * 给定二叉树
 *
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 *
 * 注意：两结点之间的路径长度是以它们之间边的数目表示。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/diameter-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @version V1.0
 * @author: LuoGuang
 * @Package com.honor.week36
 * @Description:
 * @date: 2020/2/24 16:56
 */
public class LeetCode_543_LG {
    public static void main(String[] args){
        TreeNode p1 = new TreeNode(5);
        p1.right = new TreeNode(13);
        p1.left = new TreeNode(2);
        p1.left.left = new TreeNode(3);
        System.out.println("LuoGuang:LeetCode_543_LG.main():"+diameterOfBinaryTree(p1));
    }

    static int max = 0;
    /**
     * 执行用时 :
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗 :
     * 39 MB
     * , 在所有 Java 提交中击败了
     * 5.03%
     * 的用户
     * @param root
     * @return
     */
    public static int diameterOfBinaryTree(TreeNode root) {
        if (root == null){
            return 0;
        }
        depth(root);

        return max;
    }

    private static int depth(TreeNode root) {
        if (null == root){
            return 0;
        }
        int leftD = depth(root.left);
        int rightD = depth(root.right);
        max = Math.max(max,leftD+rightD);
        return Math.max(leftD,rightD)+1;
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
