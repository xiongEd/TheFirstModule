package LeetCode;
/*
给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。

示例 1:

输入: num1 = "2", num2 = "3"
输出: "6"
示例 2:

输入: num1 = "123", num2 = "456"
输出: "56088"
说明：

num1 和 num2 的长度小于110。
num1 和 num2 只包含数字 0-9。
num1 和 num2 均不以零开头，除非是数字 0 本身。
不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 */
public class Solution43 {
    public String multiply(String num1, String num2) {
        int n = num1.length(), m = num2.length(),cur;
        StringBuilder Ret = new StringBuilder();
        if(n == 0 || m == 0){
            return "0";
        }
        int[]res = new int[n + m];
        int temp_1,temp_2,temp;
        for(int i = n - 1; i >= 0 ; i --){
            temp_1 = (int)(num1.charAt(i) - '0');
            for(int j = m - 1; j >= 0; j--){
                temp_2 = (int)(num2.charAt(j) - '0');
                temp = temp_1 * temp_2;
                res[i + j + 1] += temp%10;
                if(res[i + j + 1] > 9){
                    res[i + j] += res[i + j + 1]/10;
                    res[i + j + 1] = res[i + j + 1]%10;
                }
                res[i + j] += temp/10;
            }
        }
        for(cur = 0; cur < n + m; cur++){
            if(res[cur] > 0){
                break;
            }
        }
        if(cur == m + n){
            return "0";
        }
        for(int x = cur; x < n + m; x++){
            Ret.append(res[x]);
        }
        return Ret.toString();
    }
}
