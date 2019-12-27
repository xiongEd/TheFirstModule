package SwordRefersOffer;
/*
请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 */
public class Solution52 {
    public static boolean match(char[] str, char[] pattern) {
        int row = str.length, col = pattern.length;
        boolean[][]res = new boolean[row + 1][col + 1];
        for (int i = row; i >= 0; i--){
            for (int j = col; j >= 0; j--){
                if (i == row && j == col){
                    res[i][j] = true;
                    continue;
                }

                if (j < col - 1 && pattern[j + 1] == '*'){
                    //后一位为*的情况，判断模式串的下一位是否匹配成功或者当前模式与后一个主串字符匹配
                    res[i][j] = res[i][j + 2] || (i < row && (pattern[j] == '.' || pattern[j] == str[i]) && res[i + 1][j]);
                }
                else {
                    //正常情况，必须在后一个字符匹配的情况下，当前字符匹配则为true
                    res[i][j] = i < row && j < col &&   (pattern[j] == '.' || pattern[j] == str[i]) && res[i + 1][j + 1];
                }
            }
        }
        return res[0][0];
    }

    public static void main(String[] args){
        char[]a1 = new char[1];
        char[]a2 = new char[1];
        a1[0] = 'a';
        a2[0] = '.';
     //   a2[1] = '*';
        System.out.println(match(a1, a2));
    }
}
