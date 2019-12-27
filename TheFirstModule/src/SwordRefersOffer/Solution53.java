package SwordRefersOffer;
/*
请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 */
public class Solution53 {
    public boolean isNumeric(char[] str) {
        /*
        String s=String.valueOf(str);
        return s.matches("[+-]?[0-9]*(\\.[0-9]*)?([eE][+-]?[0-9]+)?");
        */
        boolean symFlag = false, pointFlag = false, numberFlag = false, EFlag = false;
        for (char temp : str){
            if (temp == '+' || temp == '-'){
                if (EFlag){
                    if (symFlag || numberFlag)
                        return false;
                }
                else{
                    if (symFlag || pointFlag || numberFlag)
                        return false;
                }
                symFlag = true;
            }
            else if (temp >= '0' && temp <= '9'){
                if(!numberFlag)
                    numberFlag = true;
            }
            else if (temp == '.'){
                if (pointFlag)
                    return false;
                numberFlag = false;
                pointFlag = true;
            }
            else if (temp == 'e' || temp == 'E'){
                if (!numberFlag || EFlag)
                    return false;
                symFlag = false;
                pointFlag = true;
                numberFlag = false;
                EFlag = true;
            }
            else
                return false;
        }
        if (!numberFlag)
            return false;
        return true;
    }
}
