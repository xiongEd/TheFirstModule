package LeetCode;
/*
给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。

注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。

 

示例 1：

输入：
  s = "barfoothefoobarman",
  words = ["foo","bar"]
输出：[0,9]
解释：
从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
输出的顺序不重要, [9,0] 也是有效答案。
示例 2：

输入：
  s = "wordgoodgoodgoodbestword",
  words = ["word","good","best","word"]
输出：[]
 */
public class Solution30_Cplusplus {
    /*
    public:
    vector<int> findSubstring(string s, vector<string>& words) {
        map<string,int>Hash_word;
		vector<int>count_vector;
		vector<int>mark;
		vector<int>res;
		string temp,last;
		int m,n,k,cur,begin,bit = 0, count,i;
		k = s.size();
		n = words.size();
		if(n == 0 || k == 0)
			return res;
		m = words[0].size();
		for(cur = 0; cur < n;cur ++)
			{
			if(Hash_word.count(words[cur]) == 0)
				{
				Hash_word[words[cur]] = bit;
				mark.push_back(1);
				++ bit;

				}
			else
				{
				mark[Hash_word[words[cur]]] += 1;
				}
			}

		count_vector.assign(mark.begin(),mark.end());
		cout << count_vector[0]<<endl;
		for(begin = 0; begin < m; ++ begin)
			{
			count = 0;
			mark.assign(count_vector.begin(),count_vector.end());
			for(cur = 0; cur < (k - begin)/m; ++ cur)
				{
				temp.assign(s,begin + cur * m,m);
				if(Hash_word.count(temp) != 0)
				{
					++ count;
					if(count < n)
						{
						mark[Hash_word[temp]] -= 1;
						}
					else if(count == n)
						{
							mark[Hash_word[temp]] -= 1;
						for(i = 0; i < mark.size(); ++ i)
							{
							if(mark[i] != 0)
							{
								break;
							}
							}
						if(i == mark.size())
							res.push_back((cur - n + 1) * m + begin);
						}
					else
						{
						last.assign(s,begin + (cur - n) * m, m);
						mark[Hash_word[temp]] --;
						mark[Hash_word[last]] ++;
						for(i = 0; i < mark.size(); ++ i)
							{
							if(mark[i] != 0)
								break;
							}
						if(i == mark.size())
							res.push_back((cur - n + 1) * m + begin);
					}
				}
				else
					{
					mark.assign(count_vector.begin(),count_vector.end());
					count = 0;
					}
				}
			}
		return res;
    }
     */
}
