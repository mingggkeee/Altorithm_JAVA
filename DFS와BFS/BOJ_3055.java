package DFS와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BOJ_3055_G4_탈출
 * @author mingggkeee
 * BFS
 * 비어있는 곳은  '.' 물이 차있는 곳은 '*' 돌은 'X' 비버의 굴 'D' 고슴도치 위치 'S'
 */

public class BOJ_3055 {
	
	static class Location {
		int r;
		int c;
		char type;
		int count;
		
		public Location(int r, int c, char type, int count) {
			this.r = r;
			this.c = c;
			this.type = type;
			this.count = count;
		}
		
	}
	
	static int R,C;
	static char[][] map;
	static Queue<Location> queue;
	static boolean[][] isVisited;
	static int startR, startC;
	static int endR, endC;
	static int dir[][] = {{0,1},{0,-1},{1,0},{-1,0}};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		queue = new LinkedList<>();
		isVisited = new boolean[R][C];
		
		for(int r=0; r<R; r++) {
			String input = br.readLine();
			for(int c=0; c<C; c++) {
				map[r][c] = input.charAt(c);
				if(map[r][c] == 'S') {
					startR = r;
					startC = c;
					isVisited[r][c] = true;
				}
				if(map[r][c] == '*') {
					queue.offer(new Location(r, c,'*',0));
					isVisited[r][c] = true;
				}
				
				if(map[r][c] == 'D') {
					endR = r;
					endC = c;
				}
			}
		}
		
		queue.offer(new Location(startR, startC, 'S', 0));
		
		int result = bfs();
		
		if(result == -1) {
			System.out.println("KAKTUS");
		} else {
			System.out.println(result);
		}
		
	}
	
	static int bfs() {
		
		while(!queue.isEmpty()) {
			
			Location now = queue.poll();
			
			if(now.type == 'S' && now.r==endR && now.c==endC) {
				return now.count;
			}
			
			for(int i=0; i<4; i++) {
				int nr = now.r + dir[i][0];
				int nc = now.c + dir[i][1];
				
				if(nr>=0 && nc>=0 && nr<R && nc<C && map[nr][nc] != 'X') {
					if(now.type=='*' && map[nr][nc] != 'D' && !isVisited[nr][nc]) {
						isVisited[nr][nc] = true;
						map[nr][nc] = '*';
						queue.offer(new Location(nr, nc, '*', now.count+1));
					}
					
					if(now.type=='S' && map[nr][nc] != '*' && !isVisited[nr][nc] ) {
						isVisited[nr][nc] = true;
						map[now.r][now.c] = '.';
						if(map[nr][nc] != 'D')
							map[nr][nc] = 'S';
						queue.offer(new Location(nr, nc, 'S', now.count+1));
					}
				}
				
			}
			
			
			
		}
	
	return -1;
	}

}
