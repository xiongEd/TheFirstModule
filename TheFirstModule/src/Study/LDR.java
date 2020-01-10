package Study;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
中序遍历
莫里斯遍历 - 线索二叉树
 */
public class LDR {
    public static class TreeNode {
        int val;
        public TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static List<Integer> inorder(TreeNode root){
        List<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.add(root);
        TreeNode cur;
        boolean flag = false;

        while (!stack.empty()){
            cur = stack.peek();

            if (cur.left != null && !flag){
                stack.add(cur.left);
                flag = false;
                continue;
            }

            res.add(cur.val);
            stack.pop();
            if (cur.right != null){
                stack.add(cur.right);
                flag = false;
                continue;
            }

            flag = true;
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode next = root;
        next.left = new TreeNode(2);
        next.right = new TreeNode(3);
        next = next.left;
        next.left = new TreeNode(4);
        next.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        next.left.left = new TreeNode(7);
        List<Integer> res;
        res = inorder(root);
        for (int a: res)
            System.out.print(a + "  ");

    }
}
