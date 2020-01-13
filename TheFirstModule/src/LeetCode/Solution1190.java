package LeetCode;

import java.util.HashMap;
import java.util.Stack;

/*
给出一个字符串 s（仅含有小写英文字母和括号）。

请你按照从括号内到外的顺序，逐层反转每对匹配括号中的字符串，并返回最终的结果。

注意，您的结果中 不应 包含任何括号。

 

示例 1：

输入：s = "(abcd)"
输出："dcba"
示例 2：

输入：s = "(u(love)i)"
输出："iloveu"
示例 3：

输入：s = "(ed(et(oc))el)"
输出："leetcode"
示例 4：

输入：s = "a(bcdefghijkl(mno)p)q"
输出："apmnolkjihgfedcbq"
 

提示：

0 <= s.length <= 2000
s 中只有小写英文字母和括号
我们确保所有括号都是成对出现的
 */
public class Solution1190 {
    public String reverseParentheses(String s) {
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        Stack<Integer> stack = new Stack<Integer>();
        StringBuilder res = new StringBuilder();
        int len = s.length(), temp;
        boolean flag = true;
        char ch;

        for (int i = 0; i < s.length(); i ++){
            if (s.charAt(i) == '('){
                stack.add(i);
            } else if (s.charAt(i) == ')'){
                temp = stack.pop();
                hashMap.put(i, temp);
                hashMap.put(temp, i);
            }
        }

        temp = 0;
        while (temp < len){
            ch = s.charAt(temp);
            if (ch != '(' && ch != ')'){
                res.append(ch);
            } else {
                temp = hashMap.get(temp);
                flag = !flag;
            }

            if (flag){
                temp ++;
            } else {
                temp --;
            }
        }

        return res.toString();
    }
}
