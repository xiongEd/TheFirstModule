package SwordRefersOffer;
/*
求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */
public class Solution47 {
    public int Sum_Solution(int n) {
        int m = n + 1, temp = 0;
        boolean ans2 = ((m & 1) > 0) && (temp = n)> 0;
        return (temp + SolveFunction(n, m >> 1)) >> 1;
    }
    public int SolveFunction (int n, int m){
        int temp = 0, flag = 0;
        boolean ans1 = (n = (n << 1)) > 0 && ((m & 1) > 0) &&  (flag = n) > 0;
        boolean ans2 =  (m = (m >> 1)) > 0 && (temp = SolveFunction(n,m)) > 0;
        return temp + flag;
    }
}
