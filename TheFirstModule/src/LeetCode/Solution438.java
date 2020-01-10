package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。

字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。

说明：

字母异位词指字母相同，但排列不同的字符串。
不考虑答案输出的顺序。
示例 1:

输入:
s: "cbaebabacd" p: "abc"

输出:
[0, 6]

解释:
起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
 示例 2:

输入:
s: "abab" p: "ab"

输出:
[0, 1, 2]

解释:
起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
 */
public class Solution438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<Integer>();
        int front = 0, behind = 0;
        HashMap<Character, Integer> source = new HashMap<Character, Integer>();
        HashMap<Character, Integer> target = new HashMap<Character, Integer>();
        List<Character> chars = new ArrayList<Character>();

        for (char temp: p.toCharArray()){
            if (target.containsKey(temp)){
                target.put(temp, target.get(temp) + 1);
            } else {
                target.put(temp, 1);
                source.put(temp, 0);
                chars.add(temp);
            }
        }

        char temp;
        while (front < s.length()){
            temp = s.charAt(front);

            if (source.containsKey(temp)){
                source.put(temp, source.get(temp) + 1);
            } else {
                for (char c: chars){
                    source.put(c, 0);
                }
                behind = front + 1;
                front = front + 1;
                continue;
            }

            if (front - behind < p.length() - 1){
                front ++;
                continue;
            }

            if (source.values().toString().hashCode() == target.values().toString().hashCode()){
                res.add(behind);
            }
            source.put(s.charAt(behind), source.get(s.charAt(behind)) - 1);
            front ++;
            behind ++;
        }
        return res;
    }
}
