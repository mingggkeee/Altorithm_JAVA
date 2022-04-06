package DFS와BFS;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BOJ_16933_G1_벽 부수고 이동하기 3
 * @Author mingggkeee
 * @Date 2022. 4. 6.
 * @Category : BFS
 */

public class BOJ_16933 {
	
	static class Location{
		int r;
		int c;
		int bc;	// breakCount
		int count;
		boolean night;
		
		public Location(int r, int c, int bc, int count, boolean night) {
			this.r = r;
			this.c = c;
			this.bc = bc;
			this.count = count;
			this.night = night;
		}
		
		
	}
	
	static int R, C, K;
	static int[][] map;
	static boolean[][][] isVisited;
	static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		
		for(int r=0; r<R; r++) {
			String input = br.readLine();
			for(int c=0; c<C; c++) {
				map[r][c] = input.charAt(c)-'0';
			}
		}
		
		System.out.println(bfs());
	}
	
	static int bfs() {
		
		isVisited = new boolean[R][C][K+1];
		
		Queue<Location> queue = new LinkedList<>();
		
		queue.offer(new Location(0, 0, 0, 1, false));
		isVisited[0][0][0] = true;
		
		while(!queue.isEmpty()) {
			
			Location now = queue.poll();
			if(now.bc > K)
				continue;
			
			if(now.r == R-1 && now.c == C-1) {
				return now.count;
			}
			

			
			for(int i=0; i<4; i++) {
				
				int nr = now.r + dir[i][0];
				int nc = now.c + dir[i][1];
				
				if(nr<0 || nc<0 || nr>=R || nc>=C) {
					continue;
				}
				
				if(map[nr][nc] == 1 && now.bc+1<=K &&!isVisited[nr][nc][now.bc+1]) {
					
					if(now.night) {
						queue.offer(new Location(now.r, now.c, now.bc, now.count+1, !now.night));
					} else {
						isVisited[nr][nc][now.bc+1] = true;
						queue.offer(new Location(nr, nc, now.bc+1, now.count+1, !now.night));
					}
					
					
				} else if(map[nr][nc] == 0 && !isVisited[nr][nc][now.bc]){
					
					isVisited[nr][nc][now.bc] = true; 
					queue.offer(new Location(nr, nc, now.bc, now.count+1, !now.night));
				}
				
			}
			
			
			
			
		}
		
		
		
		
		return -1;
	}

}
