package SwordRefersOffer;

/*
在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
输入描述:
题目保证输入的数组中没有的相同的数字
数据范围：
	对于%50的数据,size<=10^4
	对于%75的数据,size<=10^5
	对于%100的数据,size<=2*10^5
示例1
输入

复制
1,2,3,4,5,6,7,0
输出

复制
7
 */
public class Solution35 {
    public int InversePairs(int [] array) {
        long res = SolveFunction(array, 0, array.length - 1);
        return (int)res%1000000007;
    }

    public long SolveFunction(int[] array, int start, int end){
        int mid = (start + end) / 2;
        long Ret = 0;
        if(end - start != 0){
            Ret = SolveFunction(array,start,mid) + SolveFunction(array, mid + 1, end);
            if(Ret > 1000000007)
                Ret %= 1000000007;
        }
        else{
            return Ret;
        }
        int[]temp = new int[end - start + 1];
        int ahead = mid, after = end, point = temp.length - 1;
        while(ahead >= start && mid + 1 <= after){
            if(array[ahead] > array[after]){
                temp[point--] = array[ahead--];
                Ret += (after - mid);
            }
            else{
                temp[point--] = array[after--];
            }
        }
        while (ahead >= start){
            temp[point --] = array[ahead --];
        }
        while (mid + 1 <= after){
            temp[point --] = array[after --];
        }
        for (int i = start, j = 0; i <= end; i ++, j++){
            array[i] = temp[j];
        }
        if(Ret > 1000000007)
            Ret %= 1000000007;
        return Ret;
    }

}
