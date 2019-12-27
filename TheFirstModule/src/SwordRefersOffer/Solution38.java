package SwordRefersOffer;
/*
输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */
public class Solution38 {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }
    public int TreeDepth(TreeNode root) {
        int temp = 0;
        return Depth(root, temp);
    }

    private int Depth(TreeNode root, int temp){
        if (root == null)
            return temp;
        int a,b;
        a = Depth(root.left, temp + 1);
        b = Depth(root.right, temp + 1);
        return Math.max(a, b);
    }
}
