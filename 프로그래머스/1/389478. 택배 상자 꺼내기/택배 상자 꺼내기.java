class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        
        // 꺼내려는 상자의 열(Column) 위치를 구함
        int targetCol = getColumn(num, w);
        
        // 현재 num 상자부터 시작하여 n 이하인 동안 위층을 탐색합니다.
        // 한 층 위로 갈 때마다 상자 번호는 계속 커집니다.
        int currentNum = num;
        while (currentNum <= n) {
            // 현재 상자의 열 위치가 targetCol과 같다면 꺼내야 하는 상자입니다.
            if (getColumn(currentNum, w) == targetCol) {
                answer++;
            }
            
            
            int currentRow = (currentNum - 1) / w;
            int nextRow = currentRow + 1;
            
            if (nextRow * w >= n + w) break; 
            int nextNum;
            if (nextRow % 2 == 0) { // 짝수 층 (왼 -> 오)
                nextNum = nextRow * w + targetCol + 1;
            } else { // 홀수 층 (오 -> 왼)
                nextNum = nextRow * w + (w - 1 - targetCol) + 1;
            }
            
            currentNum = nextNum;
        }
        
        return answer;
    }
    
    // 상자 번호와 w가 주어졌을 때 0부터 w-1까지의 열 인덱스를 반환하는 메서드
    private int getColumn(int num, int w) {
        int row = (num - 1) / w;
        int mod = (num - 1) % w;
        
        if (row % 2 == 0) {
            return mod; // 왼쪽 -> 오른쪽
        } else {
            return w - 1 - mod; // 오른쪽 -> 왼쪽
        }
    }
}