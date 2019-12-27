package SwordRefersOffer;
/*
输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */
public class Solution39 {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }
    public boolean IsBalanced_Solution(TreeNode root) {
        int temp = 0;
        int[] res = new int[1];
        Depth(root, temp, res);
        return res[0] == 0;
    }

    private int Depth(TreeNode root, int temp, int[] res){
        if (root == null)
            return temp;
        int a,b;
        a = Depth(root.left, temp + 1, res);
        b = Depth(root.right, temp + 1, res);
        if(a-b > 1 || a-b < -1)
            res[0] = 1;
        return Math.max(a, b);
    }
}
