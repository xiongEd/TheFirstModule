package LeetCode;
/*
给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。

'.' 匹配任意单个字符
'*' 匹配零个或多个前面的那一个元素
所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。

说明:

s 可能为空，且只包含从 a-z 的小写字母。
p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
示例 1:

输入:
s = "aa"
p = "a"
输出: false
解释: "a" 无法匹配 "aa" 整个字符串。
示例 2:

输入:
s = "aa"
p = "a*"
输出: true
解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
示例 3:

输入:
s = "ab"
p = ".*"
输出: true
解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
示例 4:

输入:
s = "aab"
p = "c*a*b"
输出: true
解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
示例 5:

输入:
s = "mississippi"
p = "mis*is*p*."
输出: false
 */
public class Solution10_perfect {
    public boolean isMatch(String s, String p) {
        char[] str = s.toCharArray();
        char[] pattern = p.toCharArray();
        int row = str.length, col = pattern.length;
        boolean[][]res = new boolean[row + 1][col + 1];
        for (int i = row; i >= 0; i--){
            for (int j = col; j >= 0; j--){
                if (i == row && j == col){
                    res[i][j] = true;
                    continue;
                }

                if (j < col - 1 && pattern[j + 1] == '*'){
                    //后一位为*的情况
                    res[i][j] = res[i][j + 2] || (i < row && (pattern[j] == '.' || pattern[j] == str[i]) && res[i + 1][j]);
                }
                else {
                    //正常情况
                    res[i][j] = i < row && j < col &&   (pattern[j] == '.' || pattern[j] == str[i]) && res[i + 1][j + 1];                }
            }
        }
        return res[0][0];
    }
    /*
    bool isMatch(char * s, char * p) {
    int sl = strlen(s);
    int pl = strlen(p);
    bool dp[sl + 1][pl + 1];
    memset(dp, 0, sizeof(dp));
    for (int i = sl; i > -1; --i) {
        for (int j = pl; j > -1; --j) {
            if (i == sl && j == pl) {
                dp[i][j] = true;
                continue;
            }
            if (pl - j > 1 && p[j + 1] == '*') {
                dp[i][j] = dp[i][j + 2] || (i < sl && (p[j] == '.' || p[j] == s[i]) && dp[i + 1][j]);
            } else {
                dp[i][j] = i < sl && (p[j] == '.' || p[j] == s[i]) && dp[i + 1][j + 1];
            }
        }
    }
    return dp[0][0];
}
     */
}
