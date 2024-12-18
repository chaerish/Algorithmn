 import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
    static String S = "";
    static String T = "";

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        T = br.readLine();
        while (S.length() < T.length()) {
            if (T.charAt((T.length() - 1)) == 'A') {
                T = T.substring(0, T.length() - 1);
            } else {
                T = T.substring(0, T.length() - 1);
                T = new StringBuilder(T).reverse().toString();
            }
        }
        if (T.equals(S)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
