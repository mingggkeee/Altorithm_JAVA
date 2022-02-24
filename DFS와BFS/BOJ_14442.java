package DFS와BFS;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


/**
 * BOJ_14442_G3_벽 부수고 이동하기 2
 * @author mingggkeee
 * BFS
 */

public class BOJ_14442 {
	static int R,C,K;
	static int[][] map;
	static boolean[][][] isVisited;
	static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		isVisited = new boolean[R][C][K+1];
		
		for(int r=0; r<R; r++) {
			String input = br.readLine();
			for(int c=0; c<C; c++) {
				map[r][c] = input.charAt(c)-'0';
			}
		}
		
		System.out.println(bfs());
		
		
	}
	
	static int bfs() {
		
		Queue<Location> queue = new LinkedList<>();
		queue.offer(new Location(0,0,1,0));
		isVisited[0][0][0] = true;
		
		while(!queue.isEmpty()) {
			
			Location now = queue.poll();
			
			if(now.r==R-1 && now.c==C-1) {
				return now.dis;
			}
			
			for(int i=0; i<4; i++) {
				int nr = now.r + dir[i][0];
				int nc = now.c + dir[i][1];
				
				if(nr>=0 && nc>=0 && nr<R && nc<C) {
					if(map[nr][nc] == 0 && !isVisited[nr][nc][now.drill]) {
						isVisited[nr][nc][now.drill] = true;
						queue.offer(new Location(nr,nc,now.dis+1,now.drill));
					} 
					
					if(now.drill + 1> K)
						continue;
					
					if(map[nr][nc] == 1 && !isVisited[nr][nc][now.drill+1]) {
						isVisited[nr][nc][now.drill+1] = true;
						queue.offer(new Location(nr,nc,now.dis+1,now.drill+1));
					
					
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
