import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static String str;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        System.out.println(getLength(0, str.length()));
    }

    // 재귀적으로 괄호 안의 길이를 계산
    public static int getLength(int start, int end) {
        int length = 0;

        for (int i = start; i < end; i++) {
            if (str.charAt(i) == '(') {
                int multiplier = str.charAt(i - 1) - '0';
                length--; // multiplier 문자 제거
                int open = i;
                int close = findClosing(i);
                length += multiplier * getLength(i + 1, close);
                i = close;
            } else {
                length++;
            }
        }

        return length;
    }

    // 괄호에 맞는 닫는 위치를 찾음
    public static int findClosing(int open) {
        int count = 0;
        for (int i = open; i < str.length(); i++) {
            if (str.charAt(i) == '(') count++;
            else if (str.charAt(i) == ')') count--;
            if (count == 0) return i;
        }
        return -1; // 에러
    }
}
