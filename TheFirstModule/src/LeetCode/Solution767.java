package LeetCode;
/*
给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。

若可行，输出任意可行的结果。若不可行，返回空字符串。

示例 1:

输入: S = "aab"
输出: "aba"
示例 2:

输入: S = "aaab"
输出: ""
注意:

S 只包含小写字母并且长度在[1, 500]区间内。
 */
public class Solution767 {
    public String reorganizeString(String S) {
        StringBuilder res = new StringBuilder();
        int[] words = new int[26];
        for (int i = 0; i < S.length(); i ++){
            words[S.charAt(i) - 'a'] ++;
        }

        for (int temp: words){
            if (temp > (S.length() + 1) / 2){
                return res.toString();
            }
        }

        int max, last = -1;
        int maxIndex = -1;

        for (int i = 0; i < S.length(); i ++){
            max = -1;
            for (int j = 0; j < 26 ; j ++){
                if (last != j){
                    if (words[j] > max){
                        max = words[j];
                        maxIndex = j;
                    }
                }
            }
            last = maxIndex;
            words[maxIndex] --;
            res.append((char) ((char)'a' + maxIndex));
        }

        return res.toString();
    }
}
