import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        StringTokenizer st = new StringTokenizer(s, " ");
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int num = 0;
        
        while(st.hasMoreTokens()){
            num = Integer.parseInt(st.nextToken());
            max = Math.max(num,max);
            min = Math.min(num,min);
        }
        answer = min + " " + max;
        
        return answer;
    }
}