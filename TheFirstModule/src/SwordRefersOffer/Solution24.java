package SwordRefersOffer;
import java.util.*;
/*
输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
(注意: 在返回值的list中，数组长度大的数组靠前)
 */
public class Solution24 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer>temp = new ArrayList<Integer>();
        if(root == null) return res;
        SolveFunction(root, target, temp, res);
        return res;
    }

    public void SolveFunction(TreeNode root, int target,  ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> res){
        if (target == root.val){
            if(root.right == null && root.left == null) {
                temp.add(root.val);
                res.add(new ArrayList<Integer>(temp));
                temp.remove(temp.size() - 1);
                return;
            }
            else{
                return;
            }
        }
        else if(target < root.val)
            return;
        else{
            temp.add(root.val);
            target = target - root.val;
            if(root.left != null)
                SolveFunction(root.left, target, temp, res);
            if(root.right != null)
                SolveFunction(root.right, target, temp, res);
            temp.remove(temp.size() - 1);
            return;
        }
    }
}
