package DFS와BFS;

/**
 * BOJ_20304_P5_비밀번호 제작
 * @author mingggkeee
 * 비트마스킹, BFS
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class BOJ_20304 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Queue<int[]> q = new LinkedList<>();
    static int visit[];
    static int N, M, ans;
 
    static void bfs() {
        while (!q.isEmpty()) {
            int x = q.peek()[0];
            int cnt = q.poll()[1];
 
            ans = Math.max(ans, cnt);
            for (int i = 1; i <= N; i = i << 1) {
                int y = x & i;
 
                if (y > 0) {
                    if (visit[x - i] != -1)
                        continue;
                    q.add(new int[] { x - i, cnt + 1 });
                    visit[x - i] = cnt + 1;
                } else {
                    if (x + i > N || visit[x + i] != -1)
                        continue;
                    q.add(new int[] { x + i, cnt + 1 });
                    visit[x + i] = cnt + 1;
                }
            }
        }
 
        System.out.println(ans);
    }
 
    static void input() throws Exception {
        int x;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        visit = new int[N + 1];
        Arrays.fill(visit, -1);
 
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
 
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            x = Integer.parseInt(st.nextToken());
            q.add(new int[] { x, 0 });
            visit[x] = 0;
        }
    }
 
    public static void main(String[] args) throws Exception {
        input();
        bfs();
    }
}

