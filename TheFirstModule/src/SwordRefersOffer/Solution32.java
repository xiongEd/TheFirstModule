package SwordRefersOffer;
import java.util.*;

/*
输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */

public class Solution32 {
    public String PrintMinNumber(int [] numbers) {
        String res = "";
        ArrayList<Integer> temp = new ArrayList<Integer>();
        for(int tempint : numbers)
            temp.add(tempint);
        Collections.sort(temp, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = ""+ o1 + o2;
                String s2 = ""+ o2 + o1;
                return s1.compareTo(s2);
            }
        });
        for(int tempint : temp)
            res += tempint;
        return res;
    }
}
