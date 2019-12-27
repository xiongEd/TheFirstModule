package LeetCode;

public class Solution44Ex {
    public boolean isMatch(String s, String p){
        int[][]res = new int[s.length() + 1][p.length() + 1];
        int i,j;
        res[s.length()][p.length()] = 1;
        for(i = p.length() - 1; i >= 0; i--){
            if(p.charAt(i) == '*'){
                for(j = s.length(); j >= 0; j--){
                    if(res[j][i + 1] == 1){
                        res[j][i] = 1;
                        break;
                    }
                }
                while(--j >= 0){
                    res[j][i] = 1;
                }
            }
            else if(p.charAt(i) == '?'){
                for(j = s.length() - 1; j >= 0; j--){
                    if(res[j + 1][i + 1] == 1){
                        res[j][i] = 1;
                    }
                }
            }
            else {
                for (j = s.length() - 1; j >= 0; j--) {
                    if (res[j + 1][i + 1] == 1 && p.charAt(i) == s.charAt(j)) {
                        res[j][i] = 1;
                    }
                }
            }
        }
        if(res[0][0] == 1)
            return true;
        else
            return false;
    }
}
