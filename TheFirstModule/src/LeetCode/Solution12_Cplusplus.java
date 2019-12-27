package LeetCode;
/*
罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。

字符          数值
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。

通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：

I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。

示例 1:

输入: 3
输出: "III"
示例 2:

输入: 4
输出: "IV"
示例 3:

输入: 9
输出: "IX"
示例 4:

输入: 58
输出: "LVIII"
解释: L = 50, V = 5, III = 3.
示例 5:

输入: 1994
输出: "MCMXCIV"
解释: M = 1000, CM = 900, XC = 90, IV = 4.
 */
public class Solution12_Cplusplus {
    /*
    public:
    string intToRoman(int num) {
        int d0 = num % 10;
        string s0 = "";
        switch (d0) {
            case 1:
                s0 = "I";
                break;
            case 2:
                s0 = "II";
                break;
            case 3:
                s0 = "III";
                break;
            case 4:
                s0 = "IV";
                break;
            case 5:
                s0 = "V";
                break;
            case 6:
                s0 = "VI";
                break;
            case 7:
                s0 = "VII";
                break;
            case 8:
                s0 = "VIII";
                break;
            case 9:
                s0 = "IX";
        }

        num /= 10;
        int d1 = num % 10;
        string s1;
        switch (d1) {
            case 1:
                s1 = "X";
                break;
            case 2:
                s1 = "XX";
                break;
            case 3:
                s1 = "XXX";
                break;
            case 4:
                s1 = "XL";
                break;
            case 5:
                s1 = "L";
                break;
            case 6:
                s1 = "LX";
                break;
            case 7:
                s1 = "LXX";
                break;
            case 8:
                s1 = "LXXX";
                break;
            case 9:
                s1 = "XC";
        }

        num /= 10;
        int d2 = num % 10;
        string s2;
        switch (d2) {
            case 1:
                s2 = "C";
                break;
            case 2:
                s2 = "CC";
                break;
            case 3:
                s2 = "CCC";
                break;
            case 4:
                s2 = "CD";
                break;
            case 5:
                s2 = "D";
                break;
            case 6:
                s2 = "DC";
                break;
            case 7:
                s2 = "DCC";
                break;
            case 8:
                s2 = "DCCC";
                break;
            case 9:
                s2 = "CM";
        }

        num /= 10;
        int d3 = num % 10;
        string s3;
        switch (d3) {
            case 1:
                s3 = "M";
                break;
            case 2:
                s3 = "MM";
                break;
            case 3:
                s3 = "MMM";
        }

        return s3 + s2 + s1 + s0;
    }
     */
}
