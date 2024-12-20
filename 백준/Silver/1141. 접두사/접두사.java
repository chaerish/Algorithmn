import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    static Set<String> set = new HashSet<>();
    static List<String> remove = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }
        List<String> arr = new ArrayList<>(set);
        for (int i = 0; i < arr.size(); i++) {
            String prefix = arr.get(i);
            boolean flag = false;
            for (int j = 0; j < arr.size(); j++) {
                if (i == j) {
                    continue;
                } else if (arr.get(j).startsWith(prefix)) {
                    flag = true;
                }
            }
            if (flag) {
                remove.add(prefix);
            }
        }
        for (int i = 0; i < remove.size(); i++) {
            arr.remove(remove.get(i));
        }
        System.out.println(arr.size());
    }
}