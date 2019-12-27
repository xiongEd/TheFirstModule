package SwordRefersOffer;

import java.util.ArrayList;
import java.util.HashMap;

/*
请实现一个函数用来找出字符流中第一个只出现一次的字符。
例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
输出描述:
如果当前字符流没有存在出现一次的字符，返回#字符。
 */
public class Solution54 {
    //Insert one char from stringstream
    HashMap<Character, Integer>charmap = new HashMap<Character, Integer>();
    ArrayList<Character>firstChar = new ArrayList<Character>();
    public void Insert(char ch) {
        if (charmap.containsKey(ch)){
            int temp = charmap.get(ch);
            if (temp > 1){
                charmap.put(ch, temp + 1);
            }
            else {
                charmap.put(ch, temp + 1);
                firstChar.remove(firstChar.indexOf(ch));
            }
        }
        else{
            firstChar.add(ch);
            charmap.put(ch, 1);
        }
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        if (firstChar.size() != 0)
            return firstChar.get(0);
        else
            return '#';
    }
}
