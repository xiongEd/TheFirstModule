package LeetCode;
/*
给你一个字符串 s，找出它的所有子串并按字典序排列，返回排在最后的那个子串。

 

示例 1：

输入："abab"
输出："bab"
解释：我们可以找出 7 个子串 ["a", "ab", "aba", "abab", "b", "ba", "bab"]。按字典序排在最后的子串是 "bab"。
示例 2：

输入："leetcode"
输出："tcode"
 

提示：

1 <= s.length <= 4 * 10^5
s 仅含有小写英文字符。
 */
public class Solution1163_Cplusplus {
    /*
    public:
    string lastSubstring(string s) {
        string res;
		int i = 1,k;
		int n = s.size();
		if(n < 2)
			return s;
		int flag = 0;
        int c,b;
        char max = s[0];
		while(i < n)
			{
			if(s[i] > max)
				{
				flag = i;
				max = s[i];
				}
			if(s[i] == max)
				{
                k = 1;
				while(i+k < n)
					{
					if(s[flag + k] > s[i + k])
						{
                        break;
						}
                    if(s[flag +k] < s[i + k])
                    {
                        flag = i;
                        break;
                    }
                    if(!c)
                    c = s[flag + k] != max ? 1 : 0;
                 //   b = s[flag + k] > max ? 1 : 0;
					++ k;
					}
                if(i + k == n && c == 0 )
                {
                   break;
                }
               c = 0;
             //   b = 1;
				}
			++i;
			}
		for(int j = flag; j < n; ++ j)
			{
			res += s[j];
			}
		return res;
    }
     */
}
