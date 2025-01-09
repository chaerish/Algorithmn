import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int[] heights = new int[N];
        for (int i = 0; i < N; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }

        if (K == 1) {
            System.out.println(heights[N - 1] - heights[0]);
            return;
        }
        int[] diffs = new int[N - 1];
        for (int i = 0; i < N - 1; i++) {
            diffs[i] = heights[i + 1] - heights[i];
        }
        Arrays.sort(diffs);
       
        int totalCost = heights[N - 1] - heights[0];
        for (int i = 0; i < K - 1; i++) {
            totalCost -= diffs[N - 2 - i];
        }
        System.out.println(totalCost);
    }
}
