public class Main{
    static int N = 10000;
    static StringBuilder sb = new StringBuilder();
    static boolean[] map = new boolean[N + 1];

    public static void main(String[] args) throws Exception {
        for (int i = 1; i <= N; i++) {
            int key = divide(i, 0) + i;
            if (key == 0 || key == i || key >= N) {
                continue;
            }
            map[key] = true;
        }
        for (int i = 1; i < N; i++) {
            if (!map[i]) {
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb);
    }

    private static int divide(int i, int result) {
        if (len(i) == 1) {
            return result + i;
        }
        double divideNum = Math.pow(10, len(i) - 1); //100
        int value = (int) (i / divideNum); //1
        int remain = (int) (i % divideNum);
        return divide(remain, result + value);
    }

    private static int len(int x) {
        if (x / 10 == 0) {
            return 1;
        } else if (x / 100 == 0) {
            return 2;
        } else if (x / 1000 == 0) {
            return 3;
        } else if (x / 10000 == 0) {
            return 4;
        }
        return 0;
    }
}
