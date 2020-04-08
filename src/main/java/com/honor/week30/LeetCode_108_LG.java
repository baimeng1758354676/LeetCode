package com.honor.week30;

/**
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定有序数组: [-10,-3,0,5,9],
 *
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @version V1.0
 * @author: LuoGuang
 * @Package com.honor.week30
 * @Description:
 * @date: 2020/1/6 14:15
 */
public class LeetCode_108_LG {

    
    public static void main(String[] args){  
        int[] test1 = new int[]{-10,-3,0,5,9};
        TreeNode treeNode1 = sortedArrayToBST(test1);
        System.out.println("LuoGuang:LeetCode_108_LG.main():"+treeNode1);
    }

    /**
     * 执行用时 :
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 50.06%
     * 的用户
     * 内存消耗 :
     * 36.4 MB
     * , 在所有 Java 提交中击败了
     * 98.89%
     * 的用户
     * @param nums
     * @return
     */
    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0){
            return null;
        }
        if (nums.length == 1){
            return new TreeNode(nums[0]);
        }
        int mid = nums.length / 2;
        int[] left = new int[mid];
        int leftIndex = 0;
        int[] right = new int[nums.length - mid - 1];
        int rightIndex = 0;
        for (int i = 0;i < nums.length; i++){
            if (i<mid){
                left[leftIndex] = nums[i];
                leftIndex++;
            }
            if (i>mid){
                right[rightIndex] = nums[i];
                rightIndex++;
            }
        }
        TreeNode treeNode = new TreeNode(nums[mid]);
        TreeNode treeNodeLeft = sortedArrayToBST(left);
        TreeNode treeNodeRight = sortedArrayToBST(right);
        treeNode.left = treeNodeLeft;
        treeNode.right = treeNodeRight;

        return treeNode;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
