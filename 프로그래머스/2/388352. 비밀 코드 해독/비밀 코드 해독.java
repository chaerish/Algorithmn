class Solution {
    int answer = 0;
    public int solution(int n, int[][] q, int[] ans) {
        backtrack(1, new int[5], 0, n, q, ans);
        return answer;
    }
    private void backtrack(int start, int [] selected, int depth, int n, int [][] q, int [] ans){
        if(depth == 5){
            if(isValid(selected,q,ans)){
                answer++;
            }
            return;
        }
        
        for(int i= start; i <=n; i++){
            selected[depth] = i;
            backtrack(i+1, selected, depth+1, n,q,ans);
        }
    }
    
    private boolean isValid(int [] selected, int [][] q, int [] ans){
        for(int i=0; i<q.length; i++){
            int matchCount = 0;
            for(int s: selected){
                for(int val: q[i]){
                    if(s==val) matchCount++;
                }
            }
            if(matchCount != ans[i]) return false;
        }
        return true;
    }
    
}