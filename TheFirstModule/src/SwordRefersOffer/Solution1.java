package SwordRefersOffer;

/*
在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */

public class Solution1 {
    public boolean Find(int target, int [][] array) {
        int row = array.length;
        if(row == 0)
            return false;
        int low = array[0].length;
        int y = 0,x = row - 1;
        while(x >= 0 && y < low){
            if(target > array[x][y])
                y ++;
            else if(target < array[x][y])
                x --;
            else
                return true;
        }
        return false;
    };
}
    