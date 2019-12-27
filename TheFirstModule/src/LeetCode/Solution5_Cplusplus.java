package LeetCode;
/*
给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

示例 1：

输入: "babad"
输出: "bab"
注意: "aba" 也是一个有效答案。
示例 2：

输入: "cbbd"
输出: "bb"
 */
public class Solution5_Cplusplus {
    /*
    public:
    string longestPalindrome(string s) {
        int  cur ,i=0,j=0,sum = 0,n= s.size(),max;
		string res;
		res += s[0];

		if(n == 1){return res;}

		if(n == 2){
			if(s[0] == s[1])
			{
				res += s[1];
				return res;
			}
			else
			{
				return res;
			}
        }
        max = 0;
        if(s[0] == s[1])
			{
			res += s[1];
			max = 2;
			}
		i = 3;
		while(i <= n)
		{
		cur = i-1;
		sum = 0;
			if(s[cur] == s[cur-1])
				{
				j = cur -1;
				sum = 2;
				++cur;--j;
				while(j>=0&&cur<n)
					{
					if(s[cur] != s[j])
						{
						break;
						}
					sum += 2;
					++cur;--j;
					}
				if(sum > max)
					{
                    res = "";
					max = sum;
                     int m;
					for( m = 0; m<sum;m++)
						{
                        res += s[j + 1 + m];
						}
					}
				}

			cur = i-1;
			sum = 0;
			if(s[cur] == s[cur -2])
				{
				j = cur-2;
				sum = 3;
				++cur;--j;
				while(j>=0&&cur<n)
					{
					if(s[cur] != s[j])
						{
						break;
						}
					sum += 2;
					++cur;--j;
					}
				if(sum > max)
					{
                    res = "";
					max = sum;
                    int m;
					for(m = 0; m<sum;m++)
						{
                        res += s[j + 1 + m];
						}
					}
				}
			++i;
			}
		return res;
	}
     */
}
