package com.honor.pre;

/**
 * @Author: 白猛
 * @Date: 2020/1/13 11:57
 */
public class TreeDepth {

     public class TreeNode {
      int val;
     TreeNode left;
      TreeNode right;
     TreeNode(int x) { val = x; }
     }
    public static void main(String[] args) {

    }
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(maxDepth(root.left), maxDepth(root.right)) +1;
    }

    public static double myPow(double x, int n) {
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }

        return fastRow(x, n);
    }

    private static double fastRow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double half = fastRow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
}
