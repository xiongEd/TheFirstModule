package SwordRefersOffer;
/*
将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
输入描述:
输入一个字符串,包括数字字母符号,可以为空
输出描述:
如果是合法的数值表达则返回该数字，否则返回0
示例1
输入

复制
+2147483647
    1a33
输出

复制
2147483647
    0
 */
public class Solution49 {
    public int StrToInt(String str) {
        int n = str.length();
        if (n == 0) return 0;
        int res = 0,i = 0,res_flag = 0;
        int flag = 0;
        while(i < n)
        {

            if(str.charAt(i) == ' ')
            {
                if(res == 0 && flag == 0 && res_flag == 0)
                {
                    ++i;
                    continue;
                }
                else
                {
                    break;
                }
            }
            if(str.charAt(i) == '+')
            {
                if(flag == 0 && res == 0 && res_flag == 0)
                {
                    flag = 1;
                    ++i;
                    continue;
                }
                else
                {
                    break;
                }
            }
            else if(str.charAt(i) == '-')
            {
                if(flag == 0 && res == 0 && res_flag == 0)
                {
                    flag = -1;
                    ++i;
                    continue;
                }
                else
                {
                    break;
                }
            }
            else if(str.charAt(i) >= '0' && str.charAt(i) <= '9')
            {
                if (res > Integer.MAX_VALUE/10 || ( res == Integer.MAX_VALUE / 10 && (str.charAt(i) - '0') > 7) ) {
                    if (flag != -1)
                        return 0;
                    if ((str.charAt(i) - '0') == 8)
                        return Integer.MIN_VALUE;
                    return 0;
                }
                res_flag = 1;
                res = res * 10 + (str.charAt(i) - '0');
                ++i;
                continue;
            }
            else
            {
                return 0;
            }
        }
        if(res > 0 && flag != 0)
            return res * flag ;
        else if(res > 0 && flag == 0)
            return res;
        else
            return 0;
    }
}
