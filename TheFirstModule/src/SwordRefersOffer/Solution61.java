package SwordRefersOffer;
import java.util.*;
public class Solution61 {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    String Serialize(TreeNode root) {
        StringBuilder res = new StringBuilder();

        ArrayList<TreeNode> temp = new ArrayList<TreeNode>();

        if (root == null) return res.toString();

        TreeNode pNode;
        int count = 1;
        boolean flag = true;
        temp.add(root);

        while (!temp.isEmpty()){
            if (!flag) break;
            flag = false;
            for (int i = 0; i < count; i ++){
                pNode = temp.remove(0);
                if (pNode != null){
                    res.append(pNode.val);
                    res.append('!');
                    temp.add(pNode.left);
                    temp.add(pNode.right);
                    if (pNode.left != null || pNode.right != null)
                        flag = true;
                }
                else {
                    temp.add(null);
                    temp.add(null);
                    res.append('#');
                }
            }
            count *= 2;
        }
        return res.toString();
    }

    TreeNode Deserialize(String str) {
        if (str.length() == 0) return null;

        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
        int temp = 0;
        char[]chars = str.toCharArray();
        for (char aChar : chars) {
            if (aChar >= '0' && aChar <= '9') {
                temp = temp * 10 + (aChar - '0');
            } else if (aChar == '!') {
                list.add(new TreeNode(temp));
                temp = 0;
            } else {
                list.add(null);
            }
        }
        for (int i = 0; i < list.size() / 2; i ++){
            if (list.get(i) != null){
                list.get(i).left = list.get((i + 1) * 2 - 1);
                list.get(i).right = list.get((i + 1) * 2);
            }
        }
        return list.get(0);
    }
}
