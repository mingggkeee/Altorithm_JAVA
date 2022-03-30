package DFS와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BOJ_2468_S1_안전 영역
 * @author mingggkeee
 * BFS
 */

public class BOJ_2468 {
	
	static class Location{
		int r;
		int c;
		
		public Location(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static int N;
	static int[][] map;
	static boolean[][] isVisited;
	static int answer = Integer.MIN_VALUE;
	static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
	static int compare;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		isVisited = new boolean[N][N];
		
		int idx = 0;
		
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if(map[r][c] > idx) {
					idx = map[r][c];
				}
			}
		}
		
		for(int i=0; i<=idx; i++) {
			isVisited = new boolean[N][N];
			compare = 0;
			
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					if(map[r][c] <= i) {
						isVisited[r][c] = true;
					}
				}
			}
			
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					if(!isVisited[r][c]) {
						compare++;
						bfs(r, c);
					}
				}
			}
			
			answer = Math.max(compare, answer);
		}
		
		System.out.println(answer);
		
		
	}
	
	static void bfs(int r, int c) {
		Queue<Location> queue = new LinkedList<>();
		
		isVisited[r][c] = true;
		
		queue.offer(new Location(r, c));
		
		while(!queue.isEmpty()) {
			
			Location now = queue.poll();
			
			for(int i=0; i<4; i++) {
				int nr = now.r+dir[i][0];
				int nc = now.c+dir[i][1];
				
				if(nr>=0 && nc>=0 && nr<N && nc<N && !isVisited[nr][nc]) {
					queue.offer(new Location(nr, nc));
					isVisited[nr][nc] = true;
				}
			}
			
			
		}
		
		
	}
		
	

}
