package DFS와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BOJ_1194_G1_달이 차오른다, 가자.
 * @author mingggkeee
 * BFS, 비트마스킹
 */

public class BOJ_1194 {
	
	static class Location{
		int r;
		int c;
		int count;
		int key;
		
		public Location(int r, int c, int count, int key) {
			this.r = r;
			this.c = c;
			this.count = count;
			this.key = key;
		}
		
	}
	
	static int R, C;
	static char[][] map;
	static boolean[][][] isVisited;
	static int startR, startC, answer;
	static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		
		for(int r=0; r<R; r++) {
			String input = br.readLine();
			for(int c=0; c<C; c++) {
				map[r][c] = input.charAt(c);
				if(map[r][c] == '0') {
					map[r][c] = '.';
					startR = r;
					startC = c;
				}
			}
		}
		
		answer = bfs(startR, startC);
		

		System.out.println(answer);

		
	}
	
	static int bfs(int startR, int startC) {
		
		Queue<Location> queue = new LinkedList<>();
		isVisited = new boolean[R][C][64];
		
		queue.offer(new Location(startR, startC, 0, 0));
		while(!queue.isEmpty()) {
			
			Location now = queue.poll();
			
//			System.out.println(now.r+" "+now.c+" "+now.count);
			
			if(map[now.r][now.c]=='1') {
				return now.count;
			}
			
			for(int i=0; i<4; i++) {
				int nr = now.r + dir[i][0];
				int nc = now.c + dir[i][1];
				
				if(nr<0 || nc<0 || nr>= R || nc >= C) {
					continue;
				}
				
				if(map[nr][nc] == '#' || isVisited[nr][nc][now.key]) {
					continue;
				}
				
				// key
				if(map[nr][nc] - 'a' >= 0 && map[nr][nc] - 'a' <= 5) {
					int nkey = (1 << map[nr][nc] - 'a') | now.key;
					
					if(!isVisited[nr][nc][nkey]) {
						isVisited[nr][nc][nkey] = true;
						queue.offer(new Location(nr, nc, now.count+1, nkey));
					}
				} else if(map[nr][nc] - 'A' >= 0 && map[nr][nc] -'A' <=5) {
					int door = (1 << map[nr][nc] - 'A') & now.key;
					if(door != 0) {
						isVisited[nr][nc][now.key] = true;
						queue.offer(new Location(nr, nc, now.count+1, now.key));
					}
				} else {
					isVisited[nr][nc][now.key] = true;
					queue.offer(new Location(nr, nc, now.count+1, now.key));
				}
				
				
				
			}
			
		}
		
		
		return -1;
	}

}
