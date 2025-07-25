import java.util.*;
class Solution {
    public int[] solution(String s) {
        StringBuilder sb = new StringBuilder();
        int change = 0;
        int zero = 0;
        if(s.equals("1")){
            return new int[]{0,0};
        }
        int len = 0;
        int tempZero = 0;
        while(s.length()>=1){
            tempZero = 0;
            if(s.length()==1 && s.equals("1")){
                return new int[]{change,zero};
            }
            change++;
            char [] org = s.toCharArray();
            for(int i=0; i<org.length;i++){
                char word = org[i];
                if(word=='0'){
                    tempZero++;
                }
            }
            len = s.length() - tempZero;
            zero += tempZero;
            s = Integer.toBinaryString(len);
        }
        return new int[]{change,zero};
    }
}