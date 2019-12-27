package SwordRefersOffer;
import java.util.*;
/*
从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */
public class Solution60 {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        Queue<TreeNode> Nodetemp = new ArrayDeque<TreeNode>();
        if (pRoot == null) return res;
        TreeNode pNode;
        int count;
        Nodetemp.add(pRoot);

        while (Nodetemp.size() != 0) {
            count = Nodetemp.size();
            while (count-- > 0) {
                pNode = Nodetemp.poll();
                assert pNode != null;
                temp.add(pNode.val);
                if (pNode.left != null) Nodetemp.add(pNode.left);
                if (pNode.right != null) Nodetemp.add(pNode.right);
            }
            res.add(new ArrayList<Integer>(temp));
            temp.clear();
        }
        return res;
    }
}
