import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static String str = "";

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        int count = 0;
        char current = str.charAt(0);
        for (int i = 1; i < str.length(); i++) {
            if (current != str.charAt(i)) {
                count++;
                current = str.charAt(i);
            }
        }
        if (count % 2 == 0) {
            System.out.println(count / 2);
        } else {
            System.out.println((int) Math.ceil((double) count / 2));
        }
    }
}