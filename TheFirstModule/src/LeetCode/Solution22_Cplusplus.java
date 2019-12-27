package LeetCode;
/*
给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。

例如，给出 n = 3，生成结果为：

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
 */
public class Solution22_Cplusplus {
    /*
    public:
    vector<string> generateParenthesis(int n) {
        int i,j;
		string s;
		i = j = n;
		vector<string> res;
		function(res, i, j ,s);
		return res;
    }

	void function(vector<string>&a,int q, int p,string s)
		{
		if(q == 0)
			{
			while(p --)
				{
				s += ')';
				}
			a.push_back(s);
			return;
			}
		if(q == p)
			{
			s += '(';
			-- q;
			function(a, q, p, s);
			return;
			}
		function(a, q - 1, p, s + '(');
		function(a, q, p - 1, s + ')');
		return;
		}
     */
}
