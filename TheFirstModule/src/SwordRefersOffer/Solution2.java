package SwordRefersOffer;

/*
请实现一个函数，将一个字符串中的每个空格替换成“%20”。
例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */

public class Solution2 {
    public String replaceSpace(StringBuffer str) {
        String target = "%20";
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
