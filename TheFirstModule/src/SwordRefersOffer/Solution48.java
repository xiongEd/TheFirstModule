package SwordRefersOffer;
/*
写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 */
public class Solution48 {
    public int Add(int num1,int num2) {
        int source, add;
        do {
            source = num1 ^ num2; // 异或留下，01 10 得1保留
            add = (num1 & num2) * 2; // 相同的进位，11 00 得1 0 左移一位存入进制数。
            num1 = source;
            num2 = add;
        }while (add != 0);
        return num1;
    }
}
