package DFS와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BOJ_2636_G5_치즈
 * @author mingggkeee
 * BFS
 */

public class BOJ_2636 {

	static int R,C;
	static int[][] map;
	static boolean[][] isVisited;
	static int time;
	static int count;
	static int cheese;
	static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
	
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
				if(map[r][c]==1) {
					cheese++;
				}
			}
		}
		
		while(cheese != 0) {

			time++;
			count = cheese;
			melt();
		}
		
		System.out.println(time);
		System.out.println(count);
		
	}
	
	static void melt() {
		Queue<Location> queue = new LinkedList<>();
		queue.offer(new Location(0, 0));
		isVisited = new boolean[R][C];
		isVisited[0][0] = true;
		
		while(!queue.isEmpty()) {
			Location now = queue.poll();
			for(int i=0; i<4; i++) {
				int nr = now.r+dir[i][0];
				int nc = now.c+dir[i][1];
				if(nr>=0 && nc>=0 && nr<R && nc<C && !isVisited[nr][nc]) {
					
					if(map[nr][nc] == 1) {
						cheese--;
						map[nr][nc] = 0;
					}
					else if(map[nr][nc] == 0) {
						queue.offer(new Location(nr, nc));
					}
					isVisited[nr][nc] = true;
					
				}
			}
		}
	}
	
	static class Location{
		int r;
		int c;
		
		public Location(int r, int c) {
			this.r = r;
			this.c = c;
		}
		
	}
}
