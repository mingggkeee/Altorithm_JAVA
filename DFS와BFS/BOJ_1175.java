package DFS와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BOJ_1175_G1_배달
 * @author mingggkeee
 * BFS
 */

public class BOJ_1175 {
	
	static class Point{
		int r;
		int c;
		
		public Point(int r, int c) {
			this.r=r;
			this.c=c;
		}
	}
	
	static class Location{
		int r;
		int c;
		int count;
		int dir;
		int stack;
		
		public Location(int r, int c, int count, int dir, int stack) {
			this.r = r;
			this.c = c;
			this.count = count;
			this.dir = dir;
			this.stack = stack;
		}
		
	}
	
	static int R,C;
	static char[][] map;
	static boolean[][][][] isVisited;
	static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
	static int startR, startC;
	static Point C1, C2;
	static boolean isEmpty = true;
	
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		isVisited = new boolean[R][C][4][3];
		
		for(int r=0; r<R; r++) {
			String input = br.readLine();
			for(int c=0; c<C; c++) {
				map[r][c] = input.charAt(c);
				if(map[r][c] == 'S') {
					startR = r;
					startC = c;
					map[r][c] = '.';
				}
				if(map[r][c] == 'C') {
					if(isEmpty) {
						C1 = new Point(r, c);
						isEmpty = false;
					} else {
						C2 = new Point(r, c);
						
					}
					map[r][c] = '.';
				}
			
			}
		}
		
		System.out.println(bfs(startR, startC));
		
	}
	
	static int bfs(int startR, int startC) {

		Queue<Location> queue = new LinkedList<>();
		
		queue.offer(new Location(startR, startC, 0, -1, 0));
		
		isVisited[startR][startC][0][0] = true;
		isVisited[startR][startC][1][0] = true;
		isVisited[startR][startC][2][0] = true;
		isVisited[startR][startC][3][0] = true;
		
		while(!queue.isEmpty()) {
			
			Location now = queue.poll();
			
//			System.out.println(now.r+" "+now.c+" "+now.count+" "+now.stack);
			
			// stack이 0 : 둘다 방문 X 1 : C1만 방문 2 : C2만 방문
			if(now.r==C1.r && now.c == C1.c) {
				if(now.stack!=1)
					now.stack++;
			}
			
			if(now.r==C2.r && now.c == C2.c) {
				if(now.stack<=1) {
					now.stack += 2;
				}
			}
			
			if(now.stack == 3) {
				return now.count;
			}
			
			for(int i=0; i<4; i++) {
				if(i == now.dir) {
					continue;
				}
				
				int nr = now.r + dir[i][0];
				int nc = now.c + dir[i][1];
				
				if(nr>=0 && nc>=0 && nr<R && nc<C && map[nr][nc] != '#' && !isVisited[nr][nc][i][now.stack]) {
					
					isVisited[nr][nc][i][now.stack] = true;
					queue.offer(new Location(nr, nc, now.count+1, i, now.stack));
					
				}
			}
			
		}
		
		
		return -1;
	}
	
}
