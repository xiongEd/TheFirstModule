package LeetCode;
/*
给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。

如果不存在最后一个单词，请返回 0 。

说明：一个单词是指由字母组成，但不包含任何空格的字符串。

示例:

输入: "Hello World"
输出: 5
 */
public class Solution58 {
    public int lengthOfLastWord(String s) {
        int res = 0, last = -1, len = s.length();
        if(len == 0)
            return res;
        for(int i = len - 1; i >= 0; i--){
            if(s.charAt(i) != ' '){
                if(last == -1){
                    last = i;
                }
                else{
                    continue;
                }
            }
            else{
                if(last == -1){
                    continue;
                }
                else{
                    res = last - i;
                    break;
                }
            }
        }
        if(res == 0 && last != -1)
            res = last + 1;
        return res;
    }
}
