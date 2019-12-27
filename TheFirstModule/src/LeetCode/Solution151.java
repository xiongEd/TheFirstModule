package LeetCode;
/*
给定一个字符串，逐个翻转字符串中的每个单词。

 

示例 1：

输入: "the sky is blue"
输出: "blue is sky the"
示例 2：

输入: "  hello world!  "
输出: "world! hello"
解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
示例 3：

输入: "a good   example"
输出: "example good a"
解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 

说明：

无空格字符构成一个单词。
输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 

进阶：

请选用 C 语言的用户尝试使用 O(1) 额外空间复杂度的原地解法。
 */
public class Solution151 {
    public String reverseWords(String str) {
        StringBuilder res = new StringBuilder();
        int last = -1, cur = 0, n = str.length();
        if(n == 0) return str;
        while (cur < n){
            if(str.charAt(cur) == ' '){
                if (last + 1 != cur){
                    res.insert(0, str.substring(last + 1, cur));
                    res.insert(0, ' ');
                }
                last = cur;
            }
            cur ++;
        }
        if(last != n - 1){
            res.insert(0, str.substring(last + 1, cur));
        }
        while (res.length() != 0 && res.charAt(0) == ' '){
            res.deleteCharAt(0);
        }
        return res.toString();
    }
}
