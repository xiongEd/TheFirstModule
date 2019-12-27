package SwordRefersOffer;
/*
汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。
是不是很简单？OK，搞定它！
 */
public class Solution43 {
    public String LeftRotateString(String str,int n) {
        if (str.length() == 0)
            return str;
        StringBuilder res = new StringBuilder(str);
        int loop = n % (str.length());
        char temp;
        while (loop-- > 0){
            temp = res.charAt(0);
            res.deleteCharAt(0);
            res.append(temp);
        }
        return res.toString();
    }
}
