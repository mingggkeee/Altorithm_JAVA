package DFS와BFS;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BOJ_2206_G4_벽 부수고 이동하기
 * @author mingggkeee
 *
 */

public class BOJ_2206 {
	static int R,C;
	static int[][] map;
	static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
	static int answer = Integer.MAX_VALUE;
	static int[][] isVisited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		isVisited = new int[R][C];
		
		for(int r=0; r<R; r++) {
			String input = br.readLine();
			for(int c=0; c<C; c++) {
				map[r][c] = input.charAt(c) - '0';
				isVisited[r][c] = Integer.MAX_VALUE;
			}
		}
		
		System.out.println(bfs());
		
	}
	
	static int bfs() {
		Queue<Location> queue = new LinkedList<>();
		queue.offer(new Location(0,0,1,0));
		

		
		isVisited[0][0] = 0;	// 벽공사 횟수
		
		while(!queue.isEmpty()) {
			Location now = queue.poll();
			if(now.r==R-1 && now.c==C-1) {
				return now.dis;
			}
			
			for(int i=0; i<4; i++) {
				int nr = now.r + dir[i][0];
				int nc = now.c + dir[i][1];
				
				if(nr>=0 && nc>=0 && nr<R && nc<C) {
					if(isVisited[nr][nc] > now.drill) {
						if(map[nr][nc] == 0) {
							isVisited[nr][nc] = now.drill;
							queue.offer(new Location(nr,nc,now.dis+1,now.drill));
						} else {
							// 한번도 드릴 안썼으면?
							if(now.drill == 0) {
								isVisited[nr][nc] = now.drill+1;
								queue.offer(new Location(nr,nc,now.dis+1,now.drill+1));
							}
						}
					}
				}
			}
			
		}
		
		return -1;
		
		
	}
	
	static class Location{
		int r;
		int c;
		int dis;
		int drill;
		
		public Location(int r, int c, int dis, int drill) {
			this.r = r;
			this.c = c;
			this.dis = dis;
			this.drill = drill;
		}
		
	}
	
}
