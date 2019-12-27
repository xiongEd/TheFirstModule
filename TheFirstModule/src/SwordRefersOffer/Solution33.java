package SwordRefersOffer;
/*
把只包含质因子2、3和5的数称作丑数（Ugly Number）。
例如6、8都是丑数，但14不是，因为它包含质因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */
public class Solution33 {
    public int GetUglyNumber_Solution(int index) {
        if(index < 1)
            return 0;
        int[]ints = new int[index];
        ints[0] = 1;
        int two = 0, three = 0, five = 0, temp;
        for(int i = 1; i < index; i ++){
            temp = min(ints[two] * 2, ints[three] * 3, ints[five] *5);
            if(temp == ints[two] *2) two ++;
            if(temp == ints[three] *3) three ++;
            if(temp == ints[five] *5) five ++;
            ints[i] = temp;
        }
        return ints[index - 1];
    }

    public int min(int a, int b, int c){
        int temp = a < b ? a : b;
        return temp < c ? temp : c;
    }
}
