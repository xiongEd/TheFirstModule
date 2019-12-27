package LeetCode;

import java.util.*;

/*
给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。

示例:

输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
输出:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
说明：

所有输入均为小写字母。
不考虑答案输出的顺序。
 */
public class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<List<String>>();
        Map<Integer,Integer>Hash = new HashMap<Integer, Integer>();
        byte[] temp;
        String temp_str = new String();
        int count = 0,hash;
        for(String str : strs){
            temp = str.getBytes();
            Arrays.sort(temp);
            temp_str = new String(temp);
            hash = temp_str.hashCode();
            if(Hash.containsKey(hash)){
                res.get(Hash.get(hash)).add(str);
            }
            else{
                Hash.put(hash,count);
                res.add(new ArrayList<String>());
                res.get(count).add(str);
                count ++;
            }
        }
        return res;
    }
}
