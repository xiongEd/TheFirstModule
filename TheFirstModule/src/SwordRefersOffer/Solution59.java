package SwordRefersOffer;
import java.util.*;

/*
请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 */
public class Solution59 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>>res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer>temp = new ArrayList<Integer>();
        ArrayList<TreeNode>Nodetemp = new ArrayList<TreeNode>();
        TreeNode pNode;
        int count;
        boolean flag = true;
        if (pRoot == null) return res;
        temp.add(pRoot.val);
        res.add(new ArrayList<Integer>(temp));
        temp.clear();
        if (pRoot.left != null) Nodetemp.add(pRoot.left);
        if (pRoot.right != null) Nodetemp.add(pRoot.right);
        while (Nodetemp.size() != 0){
            if (flag){
                count = Nodetemp.size();
                while (count -- > 0){
                    pNode = Nodetemp.remove(0);
                    temp.add(0, pNode.val);
                    if (pNode.left != null) Nodetemp.add(pNode.left);
                    if (pNode.right != null) Nodetemp.add(pNode.right);
                }
                res.add(new ArrayList<Integer>(temp));
                temp.clear();
                flag = !flag;
            }
            else {
                count = Nodetemp.size();
                while (count -- > 0){
                    pNode = Nodetemp.remove(0);
                    temp.add(pNode.val);
                    if (pNode.left != null) Nodetemp.add(pNode.left);
                    if (pNode.right != null) Nodetemp.add(pNode.right);
                }
                res.add(new ArrayList<Integer>(temp));
                temp.clear();
                flag = !flag;
            }
        }
        return res;
    }
}
