import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int N = 0;
    static int LEN = 0;
    static String str = "";
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st = "";
        while ((st = br.readLine()) != null && !st.isEmpty()) {
            N = Integer.parseInt(st);
            LEN = (int) Math.pow(3, N); //길이
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < LEN; i++) {
                result.append('-');
            }
            makeCantor(result, 0, LEN - 1, N);
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }

    private static void makeCantor(StringBuilder sb, int start, int end, int depth) {
        if (depth == 0) {
            return;
        }
        int third = (end - start + 1) / 3; //구간 길이 3등분
        int midStart = start + third; // 가운데 구간의 시작 인덱스
        int midEnd = midStart + third - 1; //가운데 구간의 끝 인덱스
        for (int i = midStart; i <= midEnd; i++) {
            sb.setCharAt(i, ' ');
        }
        makeCantor(sb, start, midStart - 1, depth - 1); //왼쪽
        makeCantor(sb, midEnd + 1, end, depth - 1); //오른쪽
    }
}