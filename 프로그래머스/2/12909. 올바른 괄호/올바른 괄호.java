import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = false;
        int count1 = 0;
        int count2 = 0;
        Deque <Character> dq = new ArrayDeque<>();
        char [] arr = s.toCharArray();
        for(int i=0; i<arr.length;i++){
            if(arr[i] == '('){ //열린 괄호이면
                dq.addLast(arr[i]);
            }else if(arr[i] == ')'){
                if(dq.isEmpty()){
                    return false; //여는괄호없이 닫힘.
                }
                dq.pollLast();
            }
        }
        
    
        return dq.isEmpty();
    }
}