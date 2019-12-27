package LeetCode;
import java.util.*;
/*
外国友人仿照中国字谜设计了一个英文版猜字谜小游戏，请你来猜猜看吧。

字谜的迷面 puzzle 按字符串形式给出，如果一个单词 word 符合下面两个条件，那么它就可以算作谜底：

单词 word 中包含谜面 puzzle 的第一个字母。
单词 word 中的每一个字母都可以在谜面 puzzle 中找到。
例如，如果字谜的谜面是 "abcdefg"，那么可以作为谜底的单词有 "faced", "cabbage", 和 "baggage"；而 "beefed"（不含字母 "a"）以及 "based"（其中的 "s" 没有出现在谜面中）。
返回一个答案数组 answer，数组中的每个元素 answer[i] 是在给出的单词列表 words 中可以作为字谜迷面 puzzles[i] 所对应的谜底的单词数目。

 

示例：

输入：
words = ["aaaa","asas","able","ability","actt","actor","access"],
puzzles = ["aboveyz","abrodyz","abslute","absoryz","actresz","gaswxyz"]
输出：[1,1,3,2,4,0]
解释：
1 个单词可以作为 "aboveyz" 的谜底 : "aaaa"
1 个单词可以作为 "abrodyz" 的谜底 : "aaaa"
3 个单词可以作为 "abslute" 的谜底 : "aaaa", "asas", "able"
2 个单词可以作为 "absoryz" 的谜底 : "aaaa", "asas"
4 个单词可以作为 "actresz" 的谜底 : "aaaa", "asas", "actt", "access"
没有单词可以作为 "gaswxyz" 的谜底，因为列表中的单词都不含字母 'g'。
 

提示：

1 <= words.length <= 10^5
4 <= words[i].length <= 50
1 <= puzzles.length <= 10^4
puzzles[i].length == 7
words[i][j], puzzles[i][j] 都是小写英文字母。
每个 puzzles[i] 所包含的字符都不重复。
 */
public class Solution1178Ex {
    public static List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        //变量声明定义
        List<Integer>res = new ArrayList<Integer>(); //用于存储答案
        int WordCount = words.length, PuzzlesCount = puzzles.length, count = 0, Tempdata;
        HashMap<Integer,Integer>Hashmap = new HashMap<Integer, Integer>();  //存放words的哈希表

        //遍历单词，将words的所有单词通过二进制转换为int类型数字存储在hash表里（相同key时value增加计数）
        for(String tempString : words){
            Tempdata = 0;
            for(char tempchar : tempString.toCharArray()){
                Tempdata |= 1 << ('z' - tempchar); //或运算转化为int类型
            }
            if(Hashmap.containsKey(Tempdata)){
                //判断hashmap里是否有该key，有就累加，没有就填入
                Hashmap.put(Tempdata,Hashmap.get(Tempdata) + 1);
            }
            else{
                Hashmap.put(Tempdata,1);
            }
        }

        //遍历谜面，对每一个谜面累加该谜面每一个子模式对应的哈希值，将该值加入返回容器里
        for(String tempString : puzzles){
            Tempdata = 0;
            count = 0;
            for(char tempchar : tempString.toCharArray()){
                Tempdata |= 1 << ('z' - tempchar);//或运算转化为int类型
            }
            for(int child = Tempdata; child > 0; child = (child - 1)&Tempdata){ //遍历每一个子模式
                if((child | (1<<('z' - tempString.charAt(0)))) == child && Hashmap.containsKey(child)){  //判断是否有首字母
                    count += Hashmap.get(child);
                }
            }
            res.add(count);
        }
        return res;
    }

    public static void main(String str[]){
        String[] a = {"aaaa","asas","able","ability","actt","actor","access"};
        String[] b = {"aboveyz","abrodyz","abslute","absoryz","actresz","gaswxyz"};
        List<Integer> res = findNumOfValidWords(a,b);
        for(int c : res){
            System.out.print(c);
        }
    }
}
