package SwordRefersOffer;
import java.util.*;

/*
给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}，
{2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 */

public class Solution64 {
    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer>res = new ArrayList<Integer>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        int n = num.length;
        if (n < size || size <= 0) return res;

        for(int i = 0; i < n; i ++){
            if (i < size){
                temp.add(num[i]);
                if (i == size - 1){
                    Collections.sort(temp);
                    res.add(temp.get(temp.size() - 1));
                }
                continue;
            }
            temp.remove(temp.indexOf(num[i - size]));
            temp.add(num[i]);
            Collections.sort(temp);
            res.add(temp.get(temp.size() - 1));
        }
        return res;
    }
}
