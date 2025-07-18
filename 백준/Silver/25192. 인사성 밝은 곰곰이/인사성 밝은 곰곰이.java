import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    /**
     * 사람 입장 표시 -> 엔터 사람 이름 저장 key값으로해서 존재하는지 보고, 곰곰티콘이 사용된 횟수를 셈.
     */
    static Set<String> set = new HashSet<>();
    static int count = 0;
    static String ENTER = "ENTER";

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        for (int i = 0; i < size; i++) {
            String input = br.readLine();
            if (input.equals(ENTER)) {
                set.clear();
            } else {
                if (!set.contains(input)) {
                    set.add(input);
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
