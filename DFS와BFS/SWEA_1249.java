package DFS와BFS;

import java.io.*;
import java.util.PriorityQueue;

/**
 * SWEA_1249_D4_보급로
 * @Author mingggkeee
 * @Date 2022. 4. 7.
 * @Category : 우선순위 큐, BFS
 */

public class SWEA_1249 {
	
	static class Tank implements Comparable<Tank>{
		int r;
		int c;
		int cost;
		
		public Tank(int r, int c, int cost) {
			this.r = r;
			this.c = c;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Tank o) {
			return this.cost-o.cost;
		}
		
		
	}
	
	static int T,N;
	static int[][] map;
	static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
	static boolean[][] isVisited;
	static int answer;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			answer = Integer.MAX_VALUE;
			map = new int[N][N];
			
			for(int r=0; r<N; r++) {
				String input = br.readLine();
				for(int c=0; c<N; c++) {
					map[r][c] = input.charAt(c) - '0';
				}
			}
			
			bfs();
			
			sb.append("#"+t+" "+answer+"\n");
			
		}
		
		System.out.println(sb.toString());
		
	}
	
	static void bfs() {
		
		PriorityQueue<Tank> queue = new PriorityQueue<>();
		isVisited = new boolean[N][N];
		queue.offer(new Tank(0, 0, 0));
		

		isVisited[0][0] = true;

		
		
		while(!queue.isEmpty()) {
			
			Tank now = queue.poll();
			
			if(now.r == N-1 && now.c == N-1) {
				answer = now.cost;
				break;
			}
			
			for(int i=0; i<4; i++) {
				
				int nr = now.r+dir[i][0];
				int nc = now.c+dir[i][1];
				
				if(nr<0 || nc<0 || nr>=N || nc>=N || isVisited[nr][nc]) {
					continue;
				}
				
				isVisited[nr][nc] = true;
				queue.offer(new Tank(nr, nc, now.cost+map[nr][nc]));
				
			}
			
		}
		
		
	}
	
	

}
