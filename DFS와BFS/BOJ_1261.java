package DFS와BFS;

import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * BOJ_1261_G4_알고스팟
 * @author mingggkeee
 * BFS, 우선순위 큐
 */

public class BOJ_1261 {
	
	static class Location implements Comparable<Location>{
		int r;
		int c;
		int count;
		
		public Location(int r, int c, int count) {
			this.r = r;
			this.c = c;
			this.count = count;
		}

		@Override
		public int compareTo(Location o) {
			// TODO Auto-generated method stub
			return this.count-o.count;
		}
	}
	
	static int R,C;
	static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
	static int[][] map;
	static boolean[][] isVisited;
	static int answer = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		
		for(int r=0; r<R; r++) {
			String input = br.readLine();
			for(int c=0; c<C; c++) {
				map[r][c] = input.charAt(c)-'0';
			}
		}
		
		bfs();
		
		System.out.println(answer);
		
	}
	
	static void bfs() {
		isVisited = new boolean[R][C];
		PriorityQueue<Location> queue = new PriorityQueue<>();
		
		queue.offer(new Location(0, 0, 0));
		isVisited[0][0] = true;
		
		while(!queue.isEmpty()) {
			
			Location now = queue.poll();
			
			if(now.r == R-1 && now.c == C-1) {
				answer = Math.min(now.count, answer);
				continue;
			}
			
			for(int i=0; i<4; i++) {
				int nr = now.r + dir[i][0];
				int nc = now.c + dir[i][1];
				
				if(nr>=0 && nc>=0 & nr<R && nc<C) {
					if(map[nr][nc] == 0 && !isVisited[nr][nc]) {
						isVisited[nr][nc] = true;
						queue.offer(new Location(nr, nc, now.count));
					} 
					if(map[nr][nc] == 1 && !isVisited[nr][nc]) {
						isVisited[nr][nc] = true;
						queue.offer(new Location(nr, nc, now.count+1));
					}
					
				}
			}
			
		}
		
		
	}

}
