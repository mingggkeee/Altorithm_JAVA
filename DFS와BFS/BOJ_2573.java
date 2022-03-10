package DFS와BFS;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BOJ_2573_G4_빙산
 * @author mingggkeee
 * DFS, BFS
 */

public class BOJ_2573 {
	
	static class Location{
		int r;
		int c;
		
		public Location(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
	static int R, C;
	static int[][] map;
	static int[][] temp;
	static int time;
	static boolean[][] isVisited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		
		for(int r=0; r<R; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<C; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		melt();
		
		System.out.println(time);
		
	}
	
	static void melt() {
		
		while(true) {
			temp = new int[R][C];
			
			for(int r=0; r<R; r++) {
				for(int c=0; c<C; c++) {
					if(map[r][c] > 0) {
						int count = 0;
						for(int i=0; i<4; i++) {
							int nr = r + dir[i][0];
							int nc = c + dir[i][1];
							if(nr>=0 && nc>=0 && nr<R && nc<C) {
								if(map[nr][nc] == 0) {
									count++;
								}
							}
						}
						int input = map[r][c] - count;
						if(input<0) {
							input = 0;
						}
						temp[r][c] = input;
					}
				}
			}
			
			for(int r=0; r<R; r++) {
				for(int c=0; c<C; c++) {
					map[r][c] = temp[r][c];
				}
			}
			time++;
			
			isVisited = new boolean[R][C];
			
			int cnt = 0;
			for(int r=0; r<R; r++) {
				for(int c=0; c<C; c++) {
					if(map[r][c] != 0 && !isVisited[r][c]) {
						bfs(r, c);
						cnt++;
					}
				}
			}
			
			if(cnt==0) {
				time=0;
				break;
			}
			
			if(cnt>=2) {
				break;
			}
			
		}
		
	}
	
	static void bfs(int r, int c) {
		Queue<Location> queue = new LinkedList<>();
		isVisited[r][c] = true;
		queue.offer(new Location(r, c));
		
		while(!queue.isEmpty()) {
			
			Location now = queue.poll();
			
			for(int i=0; i<4; i++) {
				int nr = now.r + dir[i][0];
				int nc = now.c + dir[i][1];
				
				if(nr>=0 && nc>=0 && nr<R && nc<C && map[nr][nc] != 0 && !isVisited[nr][nc]) {
					isVisited[nr][nc] = true;
					queue.offer(new Location(nr, nc));
				}
				
			}
			
		}
		
	}

}
