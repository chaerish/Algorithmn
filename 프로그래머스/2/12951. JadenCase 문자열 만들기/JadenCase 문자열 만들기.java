import java.util.*;
class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        String [] arr = s.split(" ",-1);
        char first = ' ';
        String line = "";
        for(int i=0; i<arr.length; i++){
                line = arr[i];
                if(line.length()>0){
                                char [] word = line.toCharArray();
                first = word[0];
                if((first>='A' && first <='Z') || first >='a' && first<='z'){
                    sb.append(Character.toUpperCase(first));
                }else{
                    sb.append(first);
                }
                for(int j=1;j<word.length;j++){
                    sb.append(Character.toLowerCase(word[j]));
                }
            }
            if(i<arr.length-1){
                sb.append(" ");
            }

        }
        return sb.toString();
    }
}