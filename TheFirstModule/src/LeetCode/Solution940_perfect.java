package LeetCode;

import java.util.Arrays;
import java.util.HashMap;

/*
给定一个字符串 S，计算 S 的不同非空子序列的个数。

因为结果可能很大，所以返回答案模 10^9 + 7.

 

示例 1：

输入："abc"
输出：7
解释：7 个不同的子序列分别是 "a", "b", "c", "ab", "ac", "bc", 以及 "abc"。
示例 2：

输入："aba"
输出：6
解释：6 个不同的子序列分别是 "a", "b", "ab", "ba", "aa" 以及 "aba"。
示例 3：

输入："aaa"
输出：3
解释：3 个不同的子序列分别是 "a", "aa" 以及 "aaa"。
 

 

提示：

S 只包含小写字母。
1 <= S.length <= 2000
 */
public class Solution940_perfect {
    public int distinctSubseqII(String S) {
        int[] end = new int[26];    //记录以a、b、c...结尾的不同序列个数
        int res = 0;                //各种不同序列总数
        int added;                  //新添加的不同序列数
        int mod = (int)1e9 + 7;     //模

        for (char temp : S.toCharArray()) {
            added = (res + 1 - end[temp - 'a']) % mod;             // 新添加以temp结尾的不同序列： "... + temp" + temp - 已有的以c结尾的序列
            res = (res + added) % mod;                             //将新添加的序列加入总序列和中
            end[temp - 'a'] = (end[temp - 'a'] + added) % mod;     //更新以temp结尾的不同序列数目
        }
        return (res + mod) % mod;
    }
}
