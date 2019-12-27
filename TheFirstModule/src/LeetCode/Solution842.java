package LeetCode;

import java.util.ArrayList;
import java.util.List;

/*
给定一个数字字符串 S，比如 S = "123456579"，我们可以将它分成斐波那契式的序列 [123, 456, 579]。

形式上，斐波那契式序列是一个非负整数列表 F，且满足：

0 <= F[i] <= 2^31 - 1，（也就是说，每个整数都符合 32 位有符号整数类型）；
F.length >= 3；
对于所有的0 <= i < F.length - 2，都有 F[i] + F[i+1] = F[i+2] 成立。
另外，请注意，将字符串拆分成小块时，每个块的数字一定不要以零开头，除非这个块是数字 0 本身。

返回从 S 拆分出来的所有斐波那契式的序列块，如果不能拆分则返回 []。

示例 1：

输入："123456579"
输出：[123,456,579]
示例 2：

输入: "11235813"
输出: [1,1,2,3,5,8,13]
示例 3：

输入: "112358130"
输出: []
解释: 这项任务无法完成。
示例 4：

输入："0123"
输出：[]
解释：每个块的数字不能以零开头，因此 "01"，"2"，"3" 不是有效答案。
示例 5：

输入: "1101111"
输出: [110, 1, 111]
解释: 输出 [11,0,11,11] 也同样被接受。
提示：

1 <= S.length <= 200
字符串 S 中只含有数字。
 */
public class Solution842 {
    public static char[] chars;
    public static List<Integer> splitIntoFibonacci(String S) {
        List<Integer>res = new ArrayList<Integer>();
        List<Integer>temp = new ArrayList<Integer>();
        chars = S.toCharArray();
        int first, second;
        for (int i = 0; i < S.length() - 2; i ++){
            for (int j = i + 1; j < S.length() - 1; j ++){
                if ((first = getInteger(0, i)) == -1)
                    continue;
                if ((second = getInteger(i + 1, j)) == -1)
                    continue;

                temp.add(first);
                temp.add(second);
                if (isFibonacci(j + 1, temp, res)){
                    return res;
                }
                temp.clear();
            }
        }
        return res;
    }

   public static boolean isFibonacci(int index, List<Integer>temp, List<Integer>res){
        int Number, target, bit;
        while (index < chars.length){
            target = temp.get(temp.size() - 1) + temp.get(temp.size() - 2);
            if (target < 0) return false;
            bit = getCount(target);
            if (index + bit - 1 >= chars.length)
                return false;
            if ((Number = getInteger(index, index + bit - 1)) == -1)
                return false;
            if (Number != target)
                return false;
            temp.add(target);
            index += bit;
        }
        res.addAll(temp);
         return true;
    }

    public static int getCount(int number){
        int res = 1;
        while ((number = (number/10)) != 0){
            res ++;
        }
        return res;
    }
    public static int getInteger(int i, int j){
        if (i == j)
            return chars[i] - '0';
        if (chars[i] == '0')
            return -1;
        int res = 0;
        for (int loop = i; loop <= j; loop ++){
            res = res * 10 + (int) (chars[loop] - '0');
        }
        return res;
    }

    public static void main(String[] args){
        String a = "3611537383985343591834441270352104793375145479938855071433500231900737525076071514982402115895535257195564161509167334647108949738176284385285234123461518508746752631120827113919550237703163294909";
        List<Integer>res;
        res = splitIntoFibonacci(a);
        for (int i = 0; i < res.size(); i ++){
            System.out.println(res.get(i));
        }
    }
}
