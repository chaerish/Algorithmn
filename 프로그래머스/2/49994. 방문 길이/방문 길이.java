import java.util.*;

class Solution {
    public int solution(String dirs) {
        int x = 0, y = 0;
        Set<String> visited = new HashSet<>();
        int answer = 0;

        for (char dir : dirs.toCharArray()) {
            int nx = x, ny = y;

            if (dir == 'U') ny++;
            else if (dir == 'D') ny--;
            else if (dir == 'R') nx++;
            else if (dir == 'L') nx--;

            // 경계 확인
            if (nx < -5 || nx > 5 || ny < -5 || ny > 5) continue;

            // 경로 문자열 생성 (양방향 저장)
            String path1 = x + "," + y + "," + nx + "," + ny;
            String path2 = nx + "," + ny + "," + x + "," + y;

            if (!visited.contains(path1)) {
                visited.add(path1);
                visited.add(path2);
                answer++;
            }

            x = nx;
            y = ny;
        }

        return answer;
    }
}