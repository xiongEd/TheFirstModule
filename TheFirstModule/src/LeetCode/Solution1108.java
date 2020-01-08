package LeetCode;
/*
给你一个有效的 IPv4 地址 address，返回这个 IP 地址的无效化版本。

所谓无效化 IP 地址，其实就是用 "[.]" 代替了每个 "."。

 

示例 1：

输入：address = "1.1.1.1"
输出："1[.]1[.]1[.]1"
示例 2：

输入：address = "255.100.50.0"
输出："255[.]100[.]50[.]0"
 

提示：

给出的 address 是一个有效的 IPv4 地址
 */
public class Solution1108 {
    public String defangIPaddr(String address) {
        StringBuilder res = new StringBuilder(address);
        int i = 0;
        while (i < res.length()){
            if (res.charAt(i) == '.'){
                res.insert(i, '[');
                i += 2;
                res.insert(i, ']');
            }
            i ++;
        }
        return res.toString();
    }
}
