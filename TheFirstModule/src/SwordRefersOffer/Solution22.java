package SwordRefersOffer;

import java.util.*;

/*
从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */

public class Solution22 {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer>res = new ArrayList<Integer>();
        Queue<TreeNode>queue = new ArrayDeque<TreeNode>();
        if(root == null)
            return res;

        TreeNode temp;
        queue.add(root);

        while(!queue.isEmpty()){
            temp = queue.poll();
            res.add(temp.val);
            if (temp.left != null)
                queue.add(temp.left);
            if (temp.right != null)
                queue.add(temp.right);
        }
        return res;
    }
}
