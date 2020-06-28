package LeetCode;

import java.util.ArrayList;

/*
1371. 每个元音包含偶数次的最长子字符串
难度
中等

191

收藏

分享
切换为英文
关注
反馈
给你一个字符串 s ，请你返回满足以下条件的最长子字符串的长度：每个元音字母，即 'a'，'e'，'i'，'o'，'u' ，在子字符串中都恰好出现了偶数次。



示例 1：

输入：s = "eleetminicoworoep"
输出：13
解释：最长子字符串是 "leetminicowor" ，它包含 e，i，o 各 2 个，以及 0 个 a，u 。
示例 2：

输入：s = "leetcodeisgreat"
输出：5
解释：最长子字符串是 "leetc" ，其中包含 2 个 e 。
示例 3：

输入：s = "bcbcbc"
输出：6
解释：这个示例中，字符串 "bcbcbc" 本身就是最长的，因为所有的元音 a，e，i，o，u 都出现了 0 次。
 */
public class Solution1371 {
    public int findTheLongestSubstring(String s) {
        ArrayList<Integer> subscriptList = new ArrayList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        int result = 0, temp;
        subscriptList.add(-1);
        arrayList.add(0);
        for (int k = 0; k < s.length(); k ++) {
            switch (s.charAt(k)) {
                case 'a':
                    subscriptList.add(k);
                    arrayList.add(16);
                    break;
                case 'e':
                    subscriptList.add(k);
                    arrayList.add(8);
                    break;
                case 'i':
                    subscriptList.add(k);
                    arrayList.add(4);
                    break;
                case 'o':
                    subscriptList.add(k);
                    arrayList.add(2);
                    break;
                case 'u':
                    subscriptList.add(k);
                    arrayList.add(1);
                    break;
                default:
                    break;
            }
        }
        subscriptList.add(s.length());

        for (int k = 1; k < subscriptList.size(); k ++) {
            result = Math.max(result, subscriptList.get(k) - subscriptList.get(k - 1) - 1);

            for (int m = 1; m < k - 1; m ++) { //基点为arraylist.get(k - 1),起始坐标为1
                temp = arrayList.get(m) ^ arrayList.get(k - 1);
                arrayList.set(m, temp);
                if (temp == 0) {
                    result = Math.max(result, subscriptList.get(k) - subscriptList.get(m - 1) - 1);
                }
            }
        }

        return result;
    }
}
