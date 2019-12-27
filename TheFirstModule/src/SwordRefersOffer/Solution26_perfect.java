package SwordRefersOffer;

import java.util.ArrayDeque;
import java.util.Queue;

/*
输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class Solution26_perfect {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null)
            return null;
        Queue<TreeNode>queue = new ArrayDeque<TreeNode>();
        queue.add(pRootOfTree);

        TreeNode temppoll, tempNode;

        while (!queue.isEmpty()){
            temppoll = queue.poll();

            if (temppoll.left != null && !(temppoll.left.right != null && temppoll.left.right.val == temppoll.val)){
                queue.add(temppoll.left);
                tempNode = temppoll.left;
                while(tempNode.right != null){
                    tempNode = tempNode.right;
                }
                tempNode.right = temppoll;
                temppoll.left = tempNode;
            }

            if(temppoll.right != null && !(temppoll.right.left != null && temppoll.val == temppoll.right.left.val)){
                queue.add(temppoll.right);
                tempNode = temppoll.right;
                while(tempNode.left != null){
                    tempNode = tempNode.left;
                }
                tempNode.left = temppoll;
                temppoll.right = tempNode;
            }
        }
        tempNode = pRootOfTree;
        while (tempNode.left != null){
            tempNode = tempNode.left;
        }
        return tempNode;
    }
}
