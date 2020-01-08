package LeetCode;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

/*
一行中有 N 张多米诺骨牌，我们将每张多米诺骨牌垂直竖立。

在开始时，我们同时把一些多米诺骨牌向左或向右推。



每过一秒，倒向左边的多米诺骨牌会推动其左侧相邻的多米诺骨牌。

同样地，倒向右边的多米诺骨牌也会推动竖立在其右侧的相邻多米诺骨牌。

如果同时有多米诺骨牌落在一张垂直竖立的多米诺骨牌的两边，由于受力平衡， 该骨牌仍然保持不变。

就这个问题而言，我们会认为正在下降的多米诺骨牌不会对其它正在下降或已经下降的多米诺骨牌施加额外的力。

给定表示初始状态的字符串 "S" 。如果第 i 张多米诺骨牌被推向左边，则 S[i] = 'L'；如果第 i 张多米诺骨牌被推向右边，则 S[i] = 'R'；如果第 i 张多米诺骨牌没有被推动，则 S[i] = '.'。

返回表示最终状态的字符串。

示例 1：

输入：".L.R...LR..L.."
输出："LL.RR.LLRRLL.."
示例 2：

输入："RR.L"
输出："RR.L"
说明：第一张多米诺骨牌没有给第二张施加额外的力。
提示：

0 <= N <= 10^5
表示多米诺骨牌状态的字符串只含有 'L'，'R'; 以及 '.';
 */
public class Solution838Ex2 {
    public String pushDominoes(String dominoes) {
        StringBuilder res = new StringBuilder(dominoes);
        boolean LastFlag = false;   // 'left'
        boolean CurFlag = true;     // 'right'
        int last = -1, cur = 0, temp;
        for (int i = 0; i < dominoes.length(); i ++){
            temp = i - last - 1;
            if (res.charAt(i) == 'L'){
                if (temp > 0){
                    if (LastFlag){
                        temp /= 2;
                        for (int j = 1; j <= temp; j ++){
                            res.setCharAt(last + j, 'R');
                            res.setCharAt(i - j, 'L');
                         }
                    }else {
                        for (int j = 1; j <= temp; j ++){
                            res.setCharAt(last + j, 'L');
                        }
                    }
                }
                LastFlag = false;
                last = i;
                continue;
            }

            if (res.charAt(i) == 'R'){
                if (temp > 0){
                    if (LastFlag){
                        for (int j = 1; j <= temp; j ++){
                            res.setCharAt(last + j, 'R');
                        }
                    }
                }
                LastFlag = true;
                last = i;
            }
        }

        if (LastFlag){
            for (int i = last + 1; i < res.length(); i ++){
                res.setCharAt(i, 'R');
            }
        }
        return res.toString();
    }
}
