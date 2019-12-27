package LeetCode;
/*
给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

示例 1:

输入: "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:

输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class Solution3_Cplusplus {
    /*
    public:
    int lengthOfLongestSubstring(string s) {
        unordered_map<char,int>Hash;
		int i = 0;
		int res = 0;
		int flag = 0;
		int sum = 0;
		int r = s.size();
		while(i < s.size()){
			if(Hash.count(s[i]) == 0){
				Hash[s[i]] = i;
				sum ++;
				res = res < sum ? sum : res;
			}
			else{
				if(Hash[s[i]] >= flag){
					sum = i - Hash[s[i]];
					res = res < sum ? sum : res;
					flag = Hash[s[i]];
					Hash[s[i]] = i;
				}
				else{
					sum ++;
					res = res < sum ? sum : res;
					Hash[s[i]] = i;
				}
			}
            ++ i;
		}
		return res;
    }
     */
}
