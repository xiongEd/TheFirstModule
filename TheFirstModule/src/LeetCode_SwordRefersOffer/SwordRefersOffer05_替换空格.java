package LeetCode_SwordRefersOffer;
/*
请实现一个函数，把字符串 s 中的每个空格替换成"%20"。

 

示例 1：

输入：s = "We are happy."
输出："We%20are%20happy."
 */
public class SwordRefersOffer05_替换空格 {
    public String replaceSpace(String s) {
        String target = new String("%20");
        StringBuilder str = new StringBuilder(s);
        int index  = 0;
        while(index < str.length()){
            if (str.charAt(index) == ' '){
                str.deleteCharAt(index);
                str.insert(index,target);
                index += 3;
            }
            else
                index ++;
        }
        return str.toString();
    };
}
