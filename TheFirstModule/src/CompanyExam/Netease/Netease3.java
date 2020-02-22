package CompanyExam.Netease;

import java.util.Scanner;

/*

https://www.nowcoder.com/question/next?pid=6910869&qid=126949&tid=30408259

[编程题]字符串碎片
时间限制：C/C++ 1秒，其他语言2秒
空间限制：C/C++ 32M，其他语言64M
一个由小写字母组成的字符串可以看成一些同一字母的最大碎片组成的。例如,"aaabbaaac"是由下面碎片组成的:'aaa','bb','c'。牛牛现在给定一个字符串,请你帮助计算这个字符串的所有碎片的平均长度是多少。

输入描述:

输入包括一个字符串s,字符串s的长度length(1 ≤ length ≤ 50),s只含小写字母('a'-'z')

输出描述:

输出一个整数,表示所有碎片的平均长度,四舍五入保留两位小数。

如样例所示: s = "aaabbaaac"
所有碎片的平均长度 = (3 + 2 + 3 + 1) / 4 = 2.25

输入例子1:

aaabbaaac

输出例子1:

2.25
 */
public class Netease3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.next();
        double count = 0;
        for (int i = 0; i < string.length(); i ++) {
            if (i == 0) {
                count ++;
                continue;
            }

            if (string.charAt(i) != string.charAt(i - 1)){
                count ++;
            }
        }
        count = string.length() / count;
        count = (double) Math.round(count * 100) / 100;
        System.out.println(String.format("%.2f",count));
    }
}
