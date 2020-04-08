package com.honor.week37;

import java.util.Arrays;

/**
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @version V1.0
 * @author: LuoGuang
 * @Package com.honor.week37
 * @Description:
 * @date: 2020/3/5 14:39
 */
public class LeetCode_105_LG {

    public static void main(String[] args){  
        int[] preorder = new int[]{3,9,20,15,7};
        int[] inorder = new int[]{9,3,15,20,7};
        TreeNode treeNode = buildTree(preorder, inorder);
        System.out.println("LuoGuang:LeetCode_105_LG.main():"+treeNode);
    }

    /**
     * 执行用时 :
     * 27 ms
     * , 在所有 Java 提交中击败了
     * 7.50%
     * 的用户
     * 内存消耗 :
     * 69.7 MB
     * , 在所有 Java 提交中击败了
     * 9.26%
     * 的用户
     * @param preorder
     * @param inorder
     * @return
     */
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0){
            return null;
        }

        TreeNode treeNode = new TreeNode(preorder[0]);

        int[] left = new int[0];
        int[] right = new int[0];
        while (true){
            boolean tag = false;
            for (int i = 0; i < inorder.length;i++){
                if (treeNode.val == inorder[i]){
                    left = Arrays.copyOfRange(inorder,0,i);
                    right = Arrays.copyOfRange(inorder,i+1,inorder.length);
                    tag = true;
                }
            }
            if (tag){
                break;
            }
            preorder = Arrays.copyOfRange(preorder,1,preorder.length);
            if (preorder.length == 0){
                return null;
            }
            treeNode.val = preorder[0];
        }


        treeNode.left = buildTree(Arrays.copyOfRange(preorder,1,preorder.length),left);
        treeNode.right = buildTree(Arrays.copyOfRange(preorder,1,preorder.length),right);
        return treeNode;
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
