package DFS와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BOJ_4179_G4_불!
 * @Author mingggkeee
 * @Date 2022. 5. 2.
 * @Category : BFS
 */

public class BOJ_4179 {

	static class Location {
		int r;
		int c;
		int type;
		
		public Location(int r, int c, int type) {
			this.r = r;
			this.c = c;
			this.type = type;
		}
	}
	
	static int R, C, time;
	static int startR, startC;
	static char[][] map;
	static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
	static boolean[][][] isVisited;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
			
		time = 0;
		st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		
		for(int r=0; r<R; r++) {
			String input = br.readLine();
			for(int c=0; c<C; c++) {
				map[r][c] = input.charAt(c);
				if(map[r][c] == 'J') {
					startR = r;
					startC = c;
					map[r][c] = '.';
				}
			}
		}
		
		time = bfs(startR, startC);
		
		if(time == -1) {
			sb.append("IMPOSSIBLE\n");
		} else {
			sb.append(time+"\n");
		}
		
		
	
	
		System.out.println(sb.toString());
	}
		
	
	
	static int bfs(int startR, int startC) {
		
		isVisited = new boolean[R][C][2];
		
		Queue<Location> queue = new LinkedList<>();
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				if(map[r][c] == 'F') {
					queue.offer(new Location(r, c, 1));
					isVisited[r][c][1] = true;
				}
			}
		}
		
		queue.offer(new Location(startR, startC, 0));
		isVisited[startR][startC][0] = true;
		
		while(!queue.isEmpty()) {
			
			int size = queue.size();
			
			while(size-->0) {
				
				Location now = queue.poll();
				
				for(int i=0; i<4; i++) {
					
					int nr = now.r + dir[i][0];
					int nc = now.c + dir[i][1];
					
					if(nr<0 || nc<0 || nr>=R || nc>=C) {
						if(now.type==0) {
							return time+1;
						} else {
							continue;
						}
						
					}
					
					if(map[nr][nc] == '#') {
						continue;
					}
					
					if(!isVisited[nr][nc][now.type]) {
						if(now.type==0 && map[nr][nc] == '.') {
							isVisited[nr][nc][now.type] = true;
							queue.offer(new Location(nr, nc, now.type));
						} else if(now.type==1) {
							isVisited[nr][nc][now.type] = true;
							map[nr][nc] = '*';
							queue.offer(new Location(nr, nc, now.type));
						}
						
					}
					
					
				}
				
				
				
			}
			
			time++;
		}
		
		return -1;
	}
	
}
