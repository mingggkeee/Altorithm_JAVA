package 백트래킹;

import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * BOJ_10971_S2_외판원 순회2
 * @author mingggkeee
 * 구현, 백트래킹
 */

public class BOJ_10971 {
	
	static int N;
	static int[][] map;
	static int answer = Integer.MAX_VALUE;
	static boolean[] isVisited;
	static int end;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for(int r=0; r<N; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int c=0; c<N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		

		isVisited = new boolean[N];
		isVisited[0] = true;
		dfs(0,0,0,0);
		System.out.println(answer);

	}
	
	static void dfs(int start, int now, int sum, int cnt) {
		
		if(now == start && sum > 0) {
			answer = Math.min(sum, answer);
			return;
		}

		for(int i=0; i<N; i++) {
			
			if(map[now][i] > 0) {
			
				if(i == start && cnt == N-1) {
					sum += map[now][i];
					dfs(start, i, sum, cnt+1);
				}
				
				else if(!isVisited[i]) {
					isVisited[i] = true;
					sum += map[now][i];
					
					dfs(start, i, sum, cnt+1);
					
					sum -= map[now][i];
					isVisited[i] = false;
				}
			}
			
		}
		
		
	}

}
