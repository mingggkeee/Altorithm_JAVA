package DFS와BFS;

import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * SWEA_5643_D4_키 순서
 * @Author mingggkeee
 * @Date 2022. 4. 6.
 * @Category : BFS..
 */

public class SWEA_5643 {
	
	static int T, N, M, answer;
	static int[][] map;
	static boolean[] isVisited;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			answer = 0;
			
			N = Integer.parseInt(br.readLine());
			map = new int[N+1][N+1];
			
			M = Integer.parseInt(br.readLine());
			
			for(int i=0; i<M; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int num1 = Integer.parseInt(st.nextToken());	// 작은 거
				int num2 = Integer.parseInt(st.nextToken());	// 큰거
				map[num1][num2] = 1;
			}
			
			for(int i=1; i<=N; i++) {
				
				if(bfs(i)) {
					answer++;
				}
			}
			
			sb.append("#"+t+" "+answer+"\n");
		}
		
		System.out.println(sb.toString());
		
	}
	
	static boolean bfs(int r) {

		isVisited = new boolean[N+1];
		Queue<Height> queue = new LinkedList<>();
		queue.offer(new Height(r, false));
		isVisited[r] = true;
		for(int i=1; i<=N; i++) {
			if(map[r][i] == 1 && !isVisited[i]) {
				isVisited[i] = true;
				queue.offer(new Height(i, false));
			}
		}
		
		for(int i=1; i<=N; i++) {
			if(map[i][r] == 1 && !isVisited[i]) {
				isVisited[i] = true;
				queue.offer(new Height(i, true));
			}
		}
		
		
		while(!queue.isEmpty()) {
			
			Height now = queue.poll();
			if(now.min) {
				
				for(int i=1; i<=N; i++) {
					if(map[i][now.r] == 1 && !isVisited[i]) {
						isVisited[i] = true;
						queue.offer(new Height(i, true));
					}
				}
				
			} else {
				
				for(int i=1; i<=N; i++) {
					
					if(map[now.r][i] == 1 && !isVisited[i]) {
						isVisited[i] = true;
						queue.offer(new Height(i, false));
					}
				}
				
			}
			
			
		}
		for(int i=1; i<=N; i++) {
			if(!isVisited[i]) {
				return false;
			}
		}
			
		return true;
	}
	
	static class Height{
		int r;
		boolean min;
		
		public Height(int r, boolean min) {
			this.r = r;
			this.min = min;
		}
		
		
		
		
	}

}

