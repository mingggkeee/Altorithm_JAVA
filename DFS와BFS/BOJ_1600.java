package DFS와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BOJ_1600_G4_말이 되고픈 원숭이
 * @author mingggkeee
 * BFS
 */

public class BOJ_1600 {
	
	static class Location{
		int r;
		int c;
		int cnt;
		int k;
		
		public Location(int r, int c, int cnt, int k) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.k = k;
		}
		
	}
	
	static int K;
	static int R,C;
	static int[][] map;
	static boolean[][][] isVisited;
	static int answer = Integer.MAX_VALUE;
	static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
	static int[][] horse = {{-1,-2},{-2,-1},{-2,1},{-1,2},{1,-2},{2,-1},{2,1},{1,2}};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		K = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		
		for(int r=0; r<R; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<C; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		isVisited = new boolean[R][C][K+1];

		bfs();
		
		if(answer==Integer.MAX_VALUE) {
			answer = -1;
		}
		
		System.out.println(answer);
	}
	
	static void bfs() {
		
		Queue<Location> queue = new LinkedList<>();
		isVisited[0][0][0] = true;
		queue.offer(new Location(0, 0, 0, 0));
		
		while(!queue.isEmpty()) {
			Location now = queue.poll();
			
//			System.out.println(now.r+" "+now.c);
			
			if(now.r==R-1 && now.c==C-1) {
				
				answer = Math.min(answer, now.cnt);
			}
			
			for(int i=0; i<4; i++) {
				int nr = now.r+dir[i][0];
				int nc = now.c+dir[i][1];
				
				if(nr>=0 && nc>=0 && nr<R && nc<C && map[nr][nc] != 1 && !isVisited[nr][nc][now.k]) {
					queue.offer(new Location(nr, nc, now.cnt+1, now.k));
					isVisited[nr][nc][now.k] = true; 
				}
			}
			
			if(now.k < K) {
				for(int i=0; i<8; i++) {
					int nr = now.r+horse[i][0];
					int nc = now.c+horse[i][1];
					
					if(nr>=0 && nc>=0 && nr<R && nc<C && map[nr][nc] != 1 && !isVisited[nr][nc][now.k+1]) {
						queue.offer(new Location(nr, nc, now.cnt+1, now.k+1));
						isVisited[nr][nc][now.k+1] = true;
					}
					
				}
			}
			
		}
	}

}
