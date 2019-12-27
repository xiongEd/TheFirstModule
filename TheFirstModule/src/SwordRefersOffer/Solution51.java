package SwordRefersOffer;

/*
给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 */

public class Solution51 {
    public int[] multiply(int[] A) {
        int temp = 1, count = 1, n = A.length;
        if (n == 0) return null;
        int[] res = new int[n];
        res[0] = A[0];
        while (count < n){
            res[count] = temp * A[count - 1];
            temp = res[count ++];
        }
        count = n - 2;
        temp = 1;
        while (count >= 0){
            temp = temp * A[count + 1];
            res[count] = res[count] * temp;
            count --;
        }
        return res;
    }
}
