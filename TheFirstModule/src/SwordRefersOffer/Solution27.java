package SwordRefersOffer;
import java.util.*;

/*
输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
输入描述:
输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 */

public class Solution27 {
    public static ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<String>();
        ArrayList<Character> charList = new ArrayList<Character>();
        StringBuilder temp = new StringBuilder();

        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        for(char temp1 : chars)
            charList.add(temp1);

        SolveFunctionString(res, temp, charList, charList.size());
        return res;
    }

    public static void SolveFunctionString(ArrayList<String>res, StringBuilder temp, ArrayList<Character> nums, int size){
        System.out.println(temp);
        char member;
        for(int i = 0; i < nums.size(); i ++){
            member = nums.get(i);
            if(i > 0 && member == nums.get(i - 1))
                continue;
            temp.append(member);
            nums.remove(i);
            if(temp.length() == size){
                res.add(temp.toString());
                nums.add(i, member);
                temp.deleteCharAt(temp.length() - 1);
                return;
            }
            SolveFunctionString(res, temp, nums, size);
            nums.add(i, member);
            temp.deleteCharAt(temp.length() - 1);
        }
    }

    public static void main(String[] args){
        String asd = "DAF";
        ArrayList<String> res;
        res = Permutation(asd);
        for(String da: res){
            System.out.println(da);
        }
    }
}
