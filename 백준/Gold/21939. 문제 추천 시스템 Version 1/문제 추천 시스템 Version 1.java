import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {
    static TreeMap<Integer, TreeSet<Integer>> list = new TreeMap<>();
    static String add = "add";
    static String recommend = "recommend";
    static String solved = "solved";

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int solvedNumber = Integer.parseInt(st.nextToken());
            int level = Integer.parseInt(st.nextToken());
            list.putIfAbsent(level, new TreeSet<>());
            list.get(level).add(solvedNumber);
        }
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String console = st.nextToken();
            if (console.equals(add)) { //add 문제번호 문제난이도
                int solvedNumber = Integer.parseInt(st.nextToken());
                int level = Integer.parseInt(st.nextToken());
                list.putIfAbsent(level, new TreeSet<>());
                list.get(level).add(solvedNumber);
            } else if (console.equals(recommend)) {
                int level = Integer.parseInt(st.nextToken());
                if (level == 1) { //가장 어려운거
                    int num = list.lastKey();
                    sb.append(list.get(num).last()).append("\n");
                } else if (level == -1) {//가장 쉬운거
                    int num = list.firstKey();
                    sb.append(list.get(num).first()).append("\n");
                }
            } else if (console.equals(solved)) {
                int solvedNumber = Integer.parseInt(st.nextToken());
                Iterator<Entry<Integer, TreeSet<Integer>>> iterator = list.entrySet().iterator();
                while (iterator.hasNext()) {
                    Map.Entry<Integer, TreeSet<Integer>> entry = iterator.next();
                    int level = entry.getKey();
                    TreeSet<Integer> set = entry.getValue();
                    if (set.size() == 1 && set.contains(solvedNumber)) {
                        iterator.remove(); // 안전하게 level과 set 삭제
                    } else {
                        set.remove(solvedNumber);
                    }
                }
            }
        }
        System.out.println(sb);
    }
}
