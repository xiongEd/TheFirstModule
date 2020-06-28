package LeetCode;
/*
你有两个字符串，即pattern和value。 pattern字符串由字母"a"和"b"组成，用于描述字符串中的模式。例如，字符串"catcatgocatgo"匹配模式"aabab"（其中"cat"是"a"，"go"是"b"），该字符串也匹配像"a"、"ab"和"b"这样的模式。但需注意"a"和"b"不能同时表示相同的字符串。编写一个方法判断value字符串是否匹配pattern字符串。

示例 1：

输入： pattern = "abba", value = "dogcatcatdog"
输出： true
示例 2：

输入： pattern = "abba", value = "dogcatcatfish"
输出： false
示例 3：

输入： pattern = "aaaa", value = "dogcatcatdog"
输出： false
示例 4：

输入： pattern = "abba", value = "dogdogdogdog"
输出： true
解释： "a"="dogdog",b=""，反之也符合规则
提示：

0 <= len(pattern) <= 1000
0 <= len(value) <= 1000
你可以假设pattern只包含字母"a"和"b"，value仅包含小写字母。
 */
public class 面试16_18 {
    public boolean patternMatching(String pattern, String value) {
        //字符串长度为0时
        if (value.length() == 0) {
            //匹配串长度不为0
            if (pattern.length() != 0) {
                for (int i = 1; i < pattern.length(); i++) {
                    //如果匹配串不是只有a或者只有b
                    if (pattern.charAt(i - 1) != pattern.charAt(i))
                        return false;
                }
            }
            //匹配串长度为0
            return true;
        }
        //匹配串长度为0，或者1时，不需要多余判断
        if (pattern.length() == 0) return false;
        if (pattern.length() == 1) return true;
        //出现在首个位置的，无论是a还是b，都视为a
        char a = pattern.charAt(0);
        //匹配串中a，b的个数
        int ca = 0, cb = 0;
        for (int i = 0; i < pattern.length(); i++) {
            if (pattern.charAt(i) == a) ca++;
            else cb++;
        }
        int lv = value.length(), lp = pattern.length();
        //b没有出现，此处的真实情况可能为'a'没出现，也可能为'b'没出现，但只会被视为b没出现
        if (cb == 0) {
            //满足ca*la=lv即可
            if (lv % ca != 0) return false;
            int la = lv / ca;
            String aa = value.substring(0, la);
            for (int i = aa.length(); i < value.length(); i += aa.length()) {
                if (!value.substring(i, i + aa.length()).equals(aa)) return false;
            }
            return true;
        }
        //lv=ca*la+cb*lb
        for (int la = 0; la * ca <= value.length(); ++la) {
            //以上方程中lv,ca,la,cb均已知，那么就可以计算出lb
            int rest = lv - ca * la;
            //la的值不满足方程，跳过此次判定
            if (rest % cb != 0) continue;
            int lb = rest / cb, ci = 0;
            //匹配标识
            boolean isMatch = true;
            //aa，bb设定默认值
            String aa = "", bb = "";
            //开始匹配
            for (char c : pattern.toCharArray()) {
                if (c == a) {
                    String cur_a = value.substring(ci, ci += la);
                    //此处理论上有两个入口会进这个if
                    // 1.初次进入
                    // 2.不是初次进入，但la长度为0
                    if (aa.length() == 0)
                        aa = cur_a;
                        //字符串不相同，退出匹配串遍历
                    else if (!aa.equals(cur_a)) {
                        isMatch = false;
                        break;
                    }
                } else {
                    //同上
                    String cur_b = value.substring(ci, ci += lb);
                    if (bb.length() == 0)
                        bb = cur_b;
                    else if (!bb.equals(cur_b)) {
                        isMatch = false;
                        break;
                    }
                }
            }
            //如果此次已经全部匹配，那么就不用继续枚举，通过匹配
            if (isMatch && !aa.equals(bb)) return true;
        }
        //都不满足，默认出口
        return false;
    }
}
