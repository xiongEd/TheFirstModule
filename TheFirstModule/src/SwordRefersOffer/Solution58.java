package SwordRefersOffer;

import java.util.ArrayList;

/*
请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
public class Solution58 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    boolean isSymmetrical(TreeNode pRoot) {
        ArrayList<TreeNode> temp = new ArrayList<TreeNode>();
        TreeNode p1, p2;
        if (pRoot == null) return true;
        if (pRoot.right != null ) temp.add(pRoot.right);
        if (pRoot.left != null ) temp.add(pRoot.left);

        while (temp.size() >= 2){
            p1 = temp.remove(0);
            p2 = temp.remove(0);
            if (p1.val != p2.val) return false;
            if (p1.left != null ) temp.add(p1.left);
            if (p2.right != null ) temp.add(p2.right);
            if ((temp.size() & 1) == 1) return false;
            if (p1.right != null ) temp.add(p1.right);
            if (p2.left != null ) temp.add(p2.left);
        }
        if (temp.size() == 0)
            return true;
        return false;
    }
}
