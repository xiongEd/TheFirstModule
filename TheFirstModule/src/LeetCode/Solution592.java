package LeetCode;
/*
给定一个表示分数加减运算表达式的字符串，你需要返回一个字符串形式的计算结果。 这个结果应该是不可约分的分数，即最简分数。 如果最终结果是一个整数，例如 2，你需要将它转换成分数形式，其分母为 1。所以在上述例子中, 2 应该被转换为 2/1。

示例 1:

输入:"-1/2+1/2"
输出: "0/1"
 示例 2:

输入:"-1/2+1/2+1/3"
输出: "1/3"
示例 3:

输入:"1/3-1/2"
输出: "-1/6"
示例 4:

输入:"5/3+1/3"
输出: "2/1"
说明:

输入和输出字符串只包含 '0' 到 '9' 的数字，以及 '/', '+' 和 '-'。 
输入和输出分数格式均为 ±分子/分母。如果输入的第一个分数或者输出的分数是正数，则 '+' 会被省略掉。
输入只包含合法的最简分数，每个分数的分子与分母的范围是  [1,10]。 如果分母是1，意味着这个分数实际上是一个整数。
输入的分数个数范围是 [1,10]。
最终结果的分子与分母保证是 32 位整数范围内的有效整数。
 */
public class Solution592 {
    public String fractionAddition(String expression) {
        StringBuilder res = new StringBuilder();
        int n = (expression.length() + 1) / 4;
        int[]son = new int[n];
        int[]parent = new int[n];
        int parents = 1, flag = 1;
        boolean isSon = true;
        int count = 0;
        int sum = 0;
        char temp;

        for (int i = 0; i < expression.length(); i ++){
            temp = expression.charAt(i);

            if (temp >= '0' && temp <= '9'){
                sum = sum * 10 + (temp - '0'); //处理数字
            } else {
                //是符号时先保存数据
                if (isSon){
                    son[count ++] = sum * flag;
                } else {
                    parent[count - 1] = sum;
                    parents *= sum;
                    isSon = true;
                }
                sum = 0;

                //处理符号
                switch (temp){
                    case '+':
                        flag = 1;
                        break;

                    case '-':
                        if (i == 0)
                            count --;
                        flag = -1;
                        break;

                    case '/':
                        isSon = false;
                        break;

                    default:
                        break;
                }
            }
        }

        //保存最后一个分母
        parent[count - 1] = sum;
        parents *= sum;

        //使所有分数同分母相加
        sum = 0;
        for (int i = 0; i < count; i ++){
            son[i] = son[i] * (parents / parent[i]);
            sum += son[i];
        }

        //提出分子的符号
        flag = 1;
        if (sum < 0){
            sum = -sum;
            flag = -1;
        }

        //辗转相除法求分子分母的最大公约数
        int up = sum, down = parents;
        if (parents != 0)
        do {
            count = up % down;
            up = down;
            down = count;
        }while (down != 0);

        //通过最大公约数化简分数
        if (up  != 1){
            sum /= up;
            parents /= up;
        }

        //构造返回值
        if (flag == -1)
            res.append('-');
        res.append(sum);
        res.append('/');
        res.append(parents);
        return res.toString();
    }
}
