class Solution {
    /*
    오른쪽 (0, +1)
    아래(+1, 0)
    물에 잠긴 지역은 0개 이상 10개 이하
    */
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int [][] dp = new int[m+1][n+1];
        boolean [][] visited = new boolean[m+1][n+1];
        
        for(int i=1; i<=m; i++){
            dp[i][1] = 1;
        }
        for(int j=1; j<=n; j++){
            dp[1][j] = 1;
        }
        
        for(int i=0; i<puddles.length; i++){
            visited[puddles[i][0]][puddles[i][1]] = true;
        }
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(i==1 && j==1){
                    continue;
                }
                if(visited[i][j]){
                    dp[i][j] = 0;
                }else{
                    dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % 1000000007;
                }
            }
        }
        
        return dp[m][n];
    }
}