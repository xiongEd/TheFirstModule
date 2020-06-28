package LeetCode;
/*
给定一个经过编码的字符串，返回它解码后的字符串。

编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。

你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。

此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。

示例:

s = "3[a]2[bc]", 返回 "aaabcbc".
s = "3[a2[c]]", 返回 "accaccacc".
s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
 */
public class Solution394 {
    public String decodeString(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilderTemp = new StringBuilder();
        int time = 0, repetition = 0;
        for (char ch : s.toCharArray()) {
            if (ch > '0' && ch <= '9') {
                time = time *10 + (ch - '0');
                if (stringBuilderTemp.length() != 0) {
                    stringBuilder.append(stringBuilderTemp);
                    stringBuilderTemp.setLength(0);
                }
            } else if (ch == '[') {
                repetition = time;
                stringBuilderTemp.setLength(0);
                time = 0;
            } else if (ch == ']') {
                for (int i = 0; i < repetition; i ++) {
                    stringBuilder.append(stringBuilderTemp);
                }
                stringBuilderTemp.setLength(0);
            } else {
                stringBuilderTemp.append(ch);
            }
        }
        return stringBuilder.toString();
    }
}
class Solution394_ {
    public String decodeString(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilderTemp = new StringBuilder();
        int time = 0, repetition = 0;
        for (char ch : s.toCharArray()) {
            if (ch > '0' && ch <= '9') {
                time = time *10 + (ch - '0');
                if (stringBuilderTemp.length() != 0) {
                    stringBuilder.append(stringBuilderTemp);
                    stringBuilderTemp.setLength(0);
                }
            } else if (ch == '[') {
                repetition = time;
                stringBuilderTemp.setLength(0);
                time = 0;
            } else if (ch == ']') {
                for (int i = 0; i < repetition; i ++) {
                    stringBuilder.append(stringBuilderTemp);
                }
                stringBuilderTemp.setLength(0);
            } else {
                stringBuilderTemp.append(ch);
            }
        }
        return stringBuilder.toString();
    }

    public StringBuilder SolveFunction(String string) {
        int time = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (char ch : string.toCharArray()) {
            if (ch > '0' && ch <= '9') {
                time = time * 10 + (ch - '0');
                continue;
            }

        }

        return stringBuilder;
    }
}
