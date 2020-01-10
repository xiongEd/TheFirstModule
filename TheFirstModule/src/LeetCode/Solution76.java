package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。

示例：

输入: S = "ADOBECODEBANC", T = "ABC"
输出: "BANC"
说明：

如果 S 中不存这样的子串，则返回空字符串 ""。
如果 S 中存在这样的子串，我们保证它是唯一的答案。
 */
public class Solution76 {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> source = new HashMap<Character, Integer>();
        HashMap<Character, Integer> target = new HashMap<Character, Integer>();
        int match = 0, cur = 0;
        int[] res = {0, s.length()};
        for (char c: t.toCharArray()){
            if (target.containsKey(c)){
                target.put(c, target.get(c) + 1);
            } else {
                target.put(c, 1);
                source.put(c, 0);
                match ++;
            }
        }
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < s.length(); i ++){
            if (target.containsKey(s.charAt(i))){
                list.add(i);
            }
        }
        char temp, temp2;
        int front = 0, behind = 0;
        while (front < list.size()){
            temp = s.charAt(list.get(front));
            source.put(temp, source.get(temp) + 1);
            if (source.get(temp).equals(target.get(temp))){
                if (++cur == match){
                    while (behind <= front){
                        temp2 = s.charAt(list.get(behind));
                        source.put(temp2, source.get(temp2) - 1);
                        if (source.get(temp2).equals(target.get(temp2) - 1)){
                            if (--cur == match - 1){
                                if (list.get(front) - list.get(behind) < res[1] - res[0]){
                                    res[0] = list.get(behind);
                                    res[1] = list.get(front);
                                }
                                behind ++;
                                break;
                            }
                        }
                        behind ++;
                    }
                }
            }
            front ++;
        }
        if (res[1] == s.length()) return "";
        return s.substring(res[0], res[1] + 1);
    }
}
