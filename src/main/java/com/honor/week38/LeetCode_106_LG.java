package com.honor.week38;

import java.util.HashMap;
import java.util.Map;

/**
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @version V1.0
 * @author: LuoGuang
 * @Package com.honor.week38
 * @Description:
 * @date: 2020/3/9 14:29
 */
public class LeetCode_106_LG {

    public static void main(String[] args){
        int[] inorder = new int[]{9,3,15,20,7};
        int[] postorder = new int[]{9,15,7,20,3};

        int[] inorder2 = new int[]{3,2,1};
        int[] postorder2 = new int[]{3,2,1};
        TreeNode treeNode = buildTree(inorder, postorder);
        System.out.println("LuoGuang:LeetCode_106_LG.main():"+treeNode);
    }
    static int[] inorders;
    static int[] postorders;
    static int post_idx;
    static Map<Integer, Integer> map = new HashMap<>();

    /**
     * 执行用时 :
     * 2 ms
     * , 在所有 Java 提交中击败了
     * 96.74%
     * 的用户
     * 内存消耗 :
     * 41.3 MB
     * , 在所有 Java 提交中击败了
     * 37.98%
     * 的用户
     * @param inorder
     * @param postorder
     * @return
     */
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        inorders = inorder;
        postorders = postorder;
        for (int i = 0 ; i < inorder.length;i++){
            map.put(inorder[i],i);
        }
        post_idx =postorder.length-1;
        return build(0,inorder.length-1);
    }

    public static TreeNode build(int left, int right) {
        if (left > right){
            return null;
        }
        int num = postorders[post_idx];

        int centerIndex = map.get(num);
        TreeNode treeNode = new TreeNode(num);
        post_idx --;
        treeNode.right = build(centerIndex+1,right);
        treeNode.left = build(left,centerIndex-1);
        return treeNode;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
