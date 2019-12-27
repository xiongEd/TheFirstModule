package LeetCode;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;

/*
你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。每个拨轮可以自由旋转：例如把 '9' 变为  '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。

锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。

列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。

字符串 target 代表可以解锁的数字，你需要给出最小的旋转次数，如果无论如何不能解锁，返回 -1。

 

示例 1:

输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
输出：6
解释：
可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，
因为当拨动到 "0102" 时这个锁就会被锁定。
示例 2:

输入: deadends = ["8888"], target = "0009"
输出：1
解释：
把最后一位反向旋转一次即可 "0000" -> "0009"。
示例 3:

输入: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
输出：-1
解释：
无法旋转到目标数字且不被锁定。
示例 4:

输入: deadends = ["0000"], target = "8888"
输出：-1
 */
public class Solution752 {
    public int openLock(String[] deadends, String target) {
        double flag = 0, pond = 0;
        int  count = 0;
        char ch;
        StringBuilder stringBuilder;
        HashMap<String, Integer>Hash = new HashMap<String, Integer>();
        StringBuilder cur = new StringBuilder("0000");
        Queue<StringBuilder>queue = new ArrayDeque<StringBuilder>();

        queue.add(cur);
        for (String temp : deadends){
            Hash.put(temp, 1);
        }
        if (Hash.containsKey(target) || Hash.containsKey("0000")){
            return -1;
        }

        while (!queue.isEmpty()){
            stringBuilder = queue.poll();
            flag ++;
            if (flag > Math.pow(8, count)){
                flag -= Math.pow(8, count);
                flag += pond;
                pond = pond * 8;
                count ++;
            }

            if (Hash.containsKey(stringBuilder.toString())){
                pond += 8;
                continue;
            }
            if (target.equals(stringBuilder.toString())){
                return count;
            }

            for (int i = 0; i < 4; i ++){
                ch = stringBuilder.charAt(i);
                if (ch < '9'){
                    stringBuilder.setCharAt(i, (char) (ch + 1));
                    queue.add(new StringBuilder(stringBuilder));
                } else {
                    stringBuilder.setCharAt(i, '0');
                    queue.add(new StringBuilder(stringBuilder));
                }

                if (ch > '0'){
                    stringBuilder.setCharAt(i, (char) (ch - 1));
                    queue.add(new StringBuilder(stringBuilder));
                } else {
                    stringBuilder.setCharAt(i, '9');
                    queue.add(new StringBuilder(stringBuilder));
                }
                stringBuilder.setCharAt(i, ch);
            }

            Hash.put(stringBuilder.toString(), 1);
        }

        return -1;
    }
}
