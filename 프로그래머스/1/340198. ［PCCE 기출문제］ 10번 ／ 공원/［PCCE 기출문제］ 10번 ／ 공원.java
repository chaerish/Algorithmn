import java.util.*;
class Solution {
    public int solution(int[] mats, String[][] park) {     
        /*
        한변이 i인 점부터 k인 돗자리를 배치하려면?
        가로: i ~ i+k 가 빈칸이 아니여야 한다.
        세로: i ~ i+k 
        시간 널널하니까 완탐
        */
        Arrays.sort(mats);
        int MAX = -1;
        for(int i=mats.length - 1; i>=0; i--){
            int m = mats[i];
            for(int j=0; j<= park.length - m; j++){
                for(int k=0; k<=park[0].length - m; k++){
                    if(!park[j][k].equals("-1")){
                        continue;
                    }
                    boolean isPossible = true;
                    for(int a=j; a<j+m; a++){
                        for(int b=k; b<k+m; b++){
                            if(!park[a][b].equals("-1")){
                                isPossible = false;    
                            }
                        }     
                    }
                    if(isPossible){
                         MAX = Math.max(m, MAX);
                        break;
                    }
                }
            }
        }
        return MAX;
    }
}