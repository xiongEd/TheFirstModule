package SwordRefersOffer;
import java.util.ArrayList;

/*
输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */

public class Solution19 {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer>res = new ArrayList<Integer>();
        int row = matrix.length;
        if(row == 0)
            return res;
        int col = matrix[0].length,index = 0,i;
        while(row >= 2 && col >= 2){
            for(i = index; i < index + col - 1;i ++)
                res.add(matrix[index][i]);
            for(i = index;i < index + row - 1; i ++)
                res.add(matrix[i][index + col - 1]);
            for(i = index + col - 1; i > index; i --)
                res.add(matrix[index + row - 1][i]);
            for(i = index + row - 1; i > index; i --)
                res.add(matrix[i][index]);
            index ++;
            row -= 2;
            col -= 2;
        }
        if(row == 1 && col != 0){
            for(i = index; i < index + col;i++)
                res.add(matrix[index][i]);
            row = 0;col = 0;
        }
        if(col == 1 && row != 0){
            for(i = index; i < index + row; i++)
                res.add(matrix[i][index]);
        }
        return res;
    }
}
