import java.util.*;

class Solution {
    public int solution(String s) {
        Map<String, String> map = new HashMap<>();

        map.put("zero", "0");
        map.put("one", "1");
        map.put("two", "2");
        map.put("three", "3");
        map.put("four", "4");
        map.put("five", "5");
        map.put("six", "6");
        map.put("seven", "7");
        map.put("eight", "8");
        map.put("nine", "9");

        StringBuilder word = new StringBuilder();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // 현재 문자가 숫자라면 바로 결과에 추가
            if (Character.isDigit(c)) {
                result.append(c);
                continue;
            }

            // 숫자가 아니라면 영어 단어를 누적
            word.append(c);

            // 누적한 단어가 map에 있으면 숫자로 변환
            if (map.containsKey(word.toString())) {
                result.append(map.get(word.toString()));
                word = new StringBuilder();
            }
        }

        return Integer.parseInt(result.toString());
    }
}