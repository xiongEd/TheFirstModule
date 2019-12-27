package SwordRefersOffer;
import java.util.*;
/*
给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。
 */
public class Solution62 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    TreeNode KthNode(TreeNode pRoot, int k){
        ArrayList<Integer>res = new ArrayList<Integer>();
        Queue<TreeNode>queue = new ArrayDeque<TreeNode>();
        if (pRoot == null) return null;
        queue.add(pRoot);
        res.add(pRoot.val);
        TreeNode pNode;
        while (!queue.isEmpty()) {
            pNode = queue.poll();

            if (pNode.left != null) {
                res.add(res.indexOf(pNode.val), pNode.left.val);
                queue.add(pNode.left);
            }

            if (pNode.right != null) {
                res.add(res.indexOf(pNode.val) + 1, pNode.right.val);
                queue.add(pNode.right);
            }
        }
        if (k > res.size() || k <= 0)
            return null;
        int target = res.get(k - 1);
        pNode = pRoot;

        while (true){
            if (target < pNode.val){
                pNode = pNode.left;
            }
            else if (target > pNode.val){
                pNode = pNode.right;
            }
            else {
                return pNode;
            }
        }
    }
}
