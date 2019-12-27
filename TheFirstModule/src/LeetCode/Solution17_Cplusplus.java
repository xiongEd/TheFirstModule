package LeetCode;
/*
给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。

给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。



示例:

输入："23"
输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class Solution17_Cplusplus {
    /*
    public:

    vector<string> letterCombinations(string digits) {
		vector<string>res;
		int n = digits.size();
		if(n == 0)
			{
			return res;
			}


			switch (digits[0])
				{
				case '2':
					res.push_back("a");
					res.push_back("b");
					res.push_back("c");
					break;

				case '3':
					res.push_back("d");
					res.push_back("e");
					res.push_back("f");
					break;

				case '4':
					res.push_back("g");
					res.push_back("h");
					res.push_back("i");
					break;

				case '5':
					res.push_back("j");
					res.push_back("k");
					res.push_back("l");
					break;

				case '6':
					res.push_back("m");
					res.push_back("n");
					res.push_back("o");
					break;

				case '7':
					res.push_back("p");
					res.push_back("q");
					res.push_back("r");
					res.push_back("s");
					break;

				case '8':
					res.push_back("t");
					res.push_back("u");
					res.push_back("v");
					break;

				case '9':
					res.push_back("w");
					res.push_back("x");
					res.push_back("y");
					res.push_back("z");
					break;

				defaule:
					break;
				}

			int k =1;
			while (k < n)
				{
					int m = res.size();
					switch (digits[k])
					{
					case '2':
						for(int i = 0;i<m;i++)
							{
							res.push_back(res[i]);
							}
						for(int i = 0;i<m;i++)
							{
							res.push_back(res[i]);
							res[i] += 'a';
							res[i + m] += 'b';
							res[i + 2*m] += 'c';
							}
						break;

					case '3':
						for(int i = 0;i<m;i++)
							{
							res.push_back(res[i]);
							}
						for(int i = 0;i<m;i++)
							{
							res.push_back(res[i]);
							res[i] += 'd';
							res[i + m] += 'e';
							res[i + 2*m] += 'f';
							}
						break;

					case '4':
						for(int i = 0;i<m;i++)
							{
							res.push_back(res[i]);
							}
						for(int i = 0;i<m;i++)
							{
							res.push_back(res[i]);
							res[i] += 'g';
							res[i + m] += 'h';
							res[i + 2*m] += 'i';
							}
						break;

					case '5':
						for(int i = 0;i<m;i++)
							{
							res.push_back(res[i]);
							}
						for(int i = 0;i<m;i++)
							{
							res.push_back(res[i]);
							res[i] += 'j';
							res[i + m] += 'k';
							res[i + 2*m] += 'l';
							}
						break;

					case '6':
						for(int i = 0;i<m;i++)
							{
							res.push_back(res[i]);
							}
						for(int i = 0;i<m;i++)
							{
							res.push_back(res[i]);
							res[i] += 'm';
							res[i + m] += 'n';
							res[i + 2*m] += 'o';
							}
						break;

					case '7':
						for(int i = 0;i<m;i++)
							{
							res.push_back(res[i]);
							}
						for(int i = 0;i<m;i++)
							{
							res.push_back(res[i]);
							}
						for(int i = 0;i<m;i++)
							{
							res.push_back(res[i]);
							res[i] += 'p';
							res[i + m] += 'q';
							res[i + 2*m] += 'r';
							res[i + 3*m] += 's';
							}
						break;

					case '8':
						for(int i = 0;i<m;i++)
							{
							res.push_back(res[i]);
							}
						for(int i = 0;i<m;i++)
							{
							res.push_back(res[i]);
							res[i] += 't';
							res[i + m] += 'u';
							res[i + 2*m] += 'v';
							}
						break;

					case '9':
						for(int i = 0;i<m;i++)
							{
							res.push_back(res[i]);
							}
						for(int i = 0;i<m;i++)
							{
							res.push_back(res[i]);
							}
						for(int i = 0;i<m;i++)
							{
							res.push_back(res[i]);
							res[i] += 'w';
							res[i + m] += 'x';
							res[i + 2*m] += 'y';
							res[i + 3*m] += 'z';
							}
						break;

					default:
						break;
					}
				++ k ;
				}
			return res;
    }
     */
}
