package 백트래킹;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * JO_1681_해밀턴 순환회로
 * @author mingggkeee
 * 백트래킹
 */

public class JO_1681 {
	
	static int N, cost;
	static int[][] map;
	static int answer = Integer.MAX_VALUE;
	static boolean [] isVisited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer  st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		isVisited = new boolean[N];
		map = new int[N][N];
		
		for(int r = 0 ; r < N ; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0 ; c < N ; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		isVisited[0] = true;
		dfs(0,0,0);
		System.out.println(answer);
	}
	
	static void dfs(int now, int cnt, int cost) {
		if(cnt == N-1) {
			if(map[now][0] == 0) {
				return;
			}
			cost += map[now][0];
			answer = Math.min(cost, answer);
			return;
		}
		
		if(cost > answer) {
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(!isVisited[i] && map[now][i] != 0) {
				isVisited[i] = true;
				dfs(i, cnt+1, cost+map[now][i]);
				isVisited[i] = false;
			}
		}
		
	}
	
}
