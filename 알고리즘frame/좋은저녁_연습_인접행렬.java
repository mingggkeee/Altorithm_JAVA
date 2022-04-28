package 알고리즘frame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


/**
 * @author 은서파
 * @since 2020. 2. 18.
 * @see https://www.acmicpc.net/problem/1260
 * @git
 * @youtube
 * @performance 19408, 224
 * @category #그래프이론
 * @note
 */
public class 좋은저녁_연습_인접행렬 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static StringTokenizer tokens;

    static int N; // 정점의 개수: 1<=N<=1000
    static int M; // 간선의 개수: 1<=N<=10000
    static int V;// 탐색을 시작할 정점의 번호

    static boolean[] visited;
    static boolean[][] graph;

    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));

        input = new BufferedReader(new StringReader(src));
        tokens = new StringTokenizer(input.readLine());

        N = Integer.parseInt(tokens.nextToken());
        M = Integer.parseInt(tokens.nextToken());
        V = Integer.parseInt(tokens.nextToken());

        // 그래프 구성하기
        graph = graphLinkNode();

        // dfs는 처리하기 전에 초기화 작업 진행
        visited = new boolean[N + 1];
        visited[V] = true;
        // 출발지를 넣어주면서 출발~~
        dfs(V);

        output.append("\n");

        bfs1(V);
        System.out.println(output);
    }

    static void dfs(int node) {
        // 사용
        output.append(node).append(" ");

        // 자식 탐색
        for (int c = 1; c < N + 1; c++) {
            if (graph[node][c] && !visited[c]) {
                visited[c] = true;
                dfs(c);
            }
        }
    }

    public static void bfs1(int start) {
        // 방문을 위한 초기 작업
        visited = new boolean[N + 1];
        Queue<Integer> queue = new LinkedList<>();
        // 출발점에 대한 방문 준비
        visited[start] = true;
        queue.add(start);

        // depth 별 처리를 위한 변수 
        int depth = 0;
        while (!queue.isEmpty()) {
            // 현재 depth만 처리하기 위한 처리
            int size = queue.size();
            while (size-- > 0) {
                int head = queue.poll();
                // 실제 사용
                output.append(head).append(" ");
                // 자식 탐색
                for (int c = 1; c < N + 1; c++) {
                    if (graph[head][c] && !visited[c]) {
                        visited[c] = true;
                        queue.add(c);
                    }
                }
            }
            // size까지 돌렸다면 depth 증가
            depth++;
        }
        System.out.println("최종 depth: " + depth);
    }

    static boolean[][] graphLinkNode() throws IOException {
        graph = new boolean[N + 1][N + 1];
        for (int m = 0; m < M; m++) {
            tokens = new StringTokenizer(input.readLine());
            int from = Integer.parseInt(tokens.nextToken());
            int to = Integer.parseInt(tokens.nextToken());
            // 양방향 그래프 구성
            graph[from][to] = graph[to][from] = true;
        }
        return graph;
    }

    static String src = "5 5 3\n" +
                        "5 4\n" +
                        "5 2\n" +
                        "1 2\n" +
                        "3 4\n" +
                        "3 1";

}
