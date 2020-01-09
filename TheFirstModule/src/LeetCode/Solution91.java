package LeetCode;
/*
一条包含字母 A-Z 的消息通过以下方式进行了编码：

'A' -> 1
'B' -> 2
...
'Z' -> 26
给定一个只包含数字的非空字符串，请计算解码方法的总数。

示例 1:

输入: "12"
输出: 2
解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
示例 2:

输入: "226"
输出: 3
解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 */
public class Solution91 {
    public int numDecodings(String s) {
        if (s.length() < 1)
            return 0;
        int[] res = new int[s.length() + 1];
        int other;
        res[0] = 1;
        for (int i = 0; i < s.length(); i ++){
            if (i > 0 && (s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && (s.charAt(i) - '0') <= 6 ))){
                other = res[i - 1];
            } else {
              other = 0;
            }

            if (s.charAt(i) == '0'){
                if (other == 0){
                    return 0;
                } else {
                    res[i + 1] = other;
                }
            } else {
                res[i + 1] = res[i] + other;
            }
        }
        return res[s.length()];
    }
}
