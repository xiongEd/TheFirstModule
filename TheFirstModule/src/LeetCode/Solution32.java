package LeetCode;
/*
* 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。

示例 1:

输入: "(()"
输出: 2
解释: 最长有效括号子串为 "()"
示例 2:

输入: ")()())"
输出: 4
解释: 最长有效括号子串为 "()()"
*/
public class Solution32 {
    public int longestValidParentheses(String s) {
        int left = 0,right = 0, n = s.length(), sum = 0 , count = 0, temp;
        int looptime;
        char[] str = s.toCharArray();
        int[] a = new int[n + 1];
        int[] b = new int[n + 1];
        for(looptime = 0; looptime < n; ++ looptime){
            if('(' == str[looptime]){
                left ++;
                count ++;
                a[left] = count;
            }
            else if(')' == str[looptime]){
                right ++;
                count ++;
                b[right] = count;
                if(right > left){
                    for(int k = 1; k <= left; ++k){
                        a[k] = 0;
                    }
                    for(int k = 1; k <= right; ++k){
                        b[k] = 0;
                    }
                    left = 0;
                    right = 0;
                    count = 0;
                }
                else{
                    a[left --] = 0;
                    temp = b[right] - a[left];
                    b[right --] = 0;
                    sum = temp > sum ? temp : sum;
                }
            }
            else
            {
                return sum;
            }
        }
        return sum;
    }
}

