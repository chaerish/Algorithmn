import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[] parents;
    static List<Node> nodes = new ArrayList<>();
    static int V, E = 0;

    private static class Node implements Comparable<Node> {
        int go;
        int to;
        int weight;

        public Node(int go, int to, int weight) {
            this.go = go;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight; //오름차순
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken()); //정점
        E = Integer.parseInt(st.nextToken()); //간선

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken()); //정점
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken()); //가중치 C
            nodes.add(new Node(A, B, C));
        }

        Collections.sort(nodes);
        parents = new int[V + 1];

        for (int i = 1; i <= V; i++) {
            parents[i] = i; //부모를 자신으로 초기화한다.
        }

        long totalWeight = 0;
        int connect = 0;

        //krustal

        for (Node node : nodes) {
            if (find(node.go) != find(node.to)) {
                union(node.go, node.to);
                totalWeight += node.weight;
                connect++;
            }
            if (connect == V - 1) {
                break;
            }
        }
        System.out.println(totalWeight);
    }

    private static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            parents[rootB] = rootA; //부모가 다르다면 같게 만들어준다.
        }
    }

    private static int find(int x) {
        if (parents[x] == x) {
            return x;
        }
        return parents[x] = find(parents[x]); //경로압축
    }
}
