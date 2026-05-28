import java.util.*;

class Solution {
    public int solution(String[][] relation) {
        int rowLen = relation.length;
        int colLen = relation[0].length;
        
        List<Integer> candidateKeys = new ArrayList<>();
        
        // 1부터 (1 << colLen) - 1 까지 모든 컬럼 조합을 비트로 탐색
        // 예: colLen이 4이면 0001 부터 1111 까지
        for (int i = 1; i < (1 << colLen); i++) {
            
            // 1. 최소성 검사
            if (!checkMinimality(i, candidateKeys)) {
                continue;
            }
            
            // 2. 유일성 검사
            if (checkUniqueness(i, relation, rowLen, colLen)) {
                candidateKeys.add(i);
            }
        }
        
        return candidateKeys.size();
    }
    
    // 최소성 확인: 기존 후보키가 현재 비트(set)에 완전히 포함되는지 확인
    private boolean checkMinimality(int current, List<Integer> candidateKeys) {
        for (int key : candidateKeys) {
            if ((current & key) == key) {
                return false; 
            }
        }
        return true;
    }
    
    // 유일성 확인: 선택된 컬럼 조합으로 만든 데이터에 중복이 없는지 확인
    private boolean checkUniqueness(int current, String[][] relation, int rowLen, int colLen) {
        Set<String> set = new HashSet<>();
        
        for (int r = 0; r < rowLen; r++) {
            StringBuilder sb = new StringBuilder();
            for (int c = 0; c < colLen; c++) {
                // current 비트열의 c번째 비트가 1인지 확인 (컬럼 선택 여부)
                if ((current & (1 << c)) != 0) {
                    sb.append(relation[r][c]).append("/"); // 값 구분자 추가
                }
            }
            set.add(sb.toString());
        }
        
        return set.size() == rowLen;
    }
}