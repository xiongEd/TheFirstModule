package LeetCode;

import com.sun.source.tree.BreakTree;
import jdk.nashorn.api.tree.Tree;

import java.util.ArrayList;

/*
我们从二叉树的根节点 root 开始进行深度优先搜索。

在遍历中的每个节点处，我们输出 D 条短划线（其中 D 是该节点的深度），然后输出该节点的值。（如果节点的深度为 D，则其直接子节点的深度为 D + 1。根节点的深度为 0）。

如果节点只有一个子节点，那么保证该子节点为左子节点。

给出遍历输出 S，还原树并返回其根节点 root。

 

示例 1：



输入："1-2--3--4-5--6--7"
输出：[1,2,5,3,4,6,7]
示例 2：



输入："1-2--3---4-5--6---7"
输出：[1,2,5,3,null,6,null,4,null,7]
示例 3：



输入："1-401--349---90--88"
输出：[1,401,null,349,88,90]
 

提示：

原始树中的节点数介于 1 和 1000 之间。
每个节点的值介于 1 和 10 ^ 9 之间。
 */
public class Solution1028 {
    private class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
   }
    public TreeNode recoverFromPreorder(String S) {
        ArrayList<ArrayList<TreeNode>> lists = new ArrayList<>();
        int index = 0, sum = 0, cur = 0, deep = 0;
        TreeNode temp, lastNode;
        do {
            if (cur == S.length() || S.charAt(cur) == '-') {
                deep++;
                if (sum != 0) {
                    temp = new TreeNode(sum);
                    if (lists.size() <= index) {
                        lists.add(new ArrayList<>());
                    }
                    lists.get(index).add(temp);
                    if (index > 0) {
                        lastNode = lists.get(index - 1).get(lists.get(index - 1).size() - 1);
                        if (lastNode.left == null) {
                            lastNode.left = temp;
                        } else {
                            lastNode.right = temp;
                        }
                    }
                    sum = 0;
                }

            } else {
                if (deep != 0) {
                    index = deep;
                    deep = 0;
                }
                sum = sum * 10 + (S.charAt(cur) - '0');
            }
        } while (cur++ < S.length());
        return lists.get(0).get(0);
    }
}
