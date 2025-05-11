import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int V, E, start = 0;
    static List<Node>[] graph;
    static int[] dist;

    public static class Node {
        int to;
        int w;

        public Node(int to, int w) {
            this.to = to;
            this.w = w;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        start = Integer.parseInt(br.readLine());
        graph = new ArrayList[V+1]; //인접리스트
        dist = new int[V + 1];

        /*
        초기화
         */
        Arrays.fill(dist, (int) 1e9); //가장큰값으로 초기화
        dist[start] = 0; //start 는 시작지점이므로 0으로 초기화함.

        for (int i = 0; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            graph[Integer.parseInt(st.nextToken())].add(
                    new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.w)); //가중치 최소 정렬
        pq.add(new Node(start, 0)); //0으로가는거 가중치는 0
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int cto = node.to;
            int cw = node.w;

            if (dist[cto] < cw) {
                continue;
            }

            for (Node next : graph[cto]) {
                int nto = next.to;
                int nw = next.w;
                int newDist = nw + dist[cto];
                if (newDist < dist[nto]) {
                    dist[nto] = newDist;
                    pq.add(new Node(nto,newDist));
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            int value = dist[i];
            if (value == (int) 1e9) {
                sb.append("INF");
            } else {
                sb.append(value);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}