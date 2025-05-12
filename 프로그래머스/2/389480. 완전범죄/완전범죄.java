import java.util.*;

class Solution {
    // 그리디 -> [a,b] -> a가 최소여야해. 그래서 a가 큰순으로 정렬하고, 만약에 a가같다면
    // b가 작은순으로 정렬해 -> b가 작은순으로 정렬하는 이유는, m이 더 클수도 있으니까
    public int solution(int[][] info, int n, int m) {
        Arrays.sort(info,(o1,o2)->{
            int a1 = o1[0];
            int a2 = o2[0];
            
            int b1 = o1[1];
            int b2 = o2[1];
            
            return (a2 - b2) - (a1 - b1);
        });
        int aValue = 0;
        int bValue = 0;
        for(int i=0; i<info.length;i++){
            int a = info[i][0];
            int b = info[i][1];
            if(bValue + b < m){
                bValue+=b;
                continue;
            }else if(aValue + a < n){
                aValue +=a;
                continue;
            }else{
                return -1;
            }
        }
        return aValue;
    }
}