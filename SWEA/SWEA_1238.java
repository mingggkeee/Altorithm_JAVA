package SWEA;

import java.util.*;

/**
 * SWEA_1238_D4_Contact
 * @author mingggkeee
 * bfs
 */

public class SWEA_1238 {
    static int [][] graph;

    static int bfs(int start) {
        int [] visited = new int[101];
        int maxCnt = 0, answer = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = 1;

        while(!q.isEmpty()) {
            int cur = q.poll();

            for(int i = 1; i< 101; i++) {
                if(graph[cur][i] != 1 || visited[i] != 0) continue;

                visited[i] = visited[cur]+1;
                q.offer(i);
            }
            maxCnt = visited[cur];
        }

        for(int i = 1 ; i< 101; i++) {
            if(maxCnt != visited[i]) continue;
            answer = answer > i ? answer : i;
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = 10;

        for(int t= 1; t <= T; t++) {
            int N = sc.nextInt();
            int start = sc.nextInt();
            graph = new int[101][101];

            for(int i = 0; i < N/2; i++) {
                graph[sc.nextInt()][sc.nextInt()] = 1;
            }

            System.out.println("#" + t + " " + bfs(start));
        }
        
        sc.close();
    }
}
