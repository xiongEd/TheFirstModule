package SwordRefersOffer;
/*
牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，
正确的句子应该是“I am a student.”。
Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 */
public class Solution44 {
    public String ReverseSentence(String str) {
        StringBuilder res = new StringBuilder();
        int last = -1, cur = 0, n = str.length();
        if(n <= 1) return str;
        while (cur < n){
            if(str.charAt(cur) == ' '){
                res.insert(0, str.substring(last + 1, cur));
                res.insert(0, ' ');
                last = cur;
            }
            cur ++;
        }
        if(last != n - 1){
            res.insert(0, str.substring(last + 1, cur));
        }
        return res.toString();
    }
}
