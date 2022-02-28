package DFS와BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BOJ_4963_S2_섬의 개수
 * @author mingggkeee
 * DFS, BFS
 */

public class BOJ_4963 {
	
	static class Location{
		int r;
		int c;
		
		public Location(int r, int c) {
			this.r = r;
			this.c = c;
		}
		
		
	}
	
	static int R,C;
	static int[][] map;
	static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}, {1,1},{1,-1},{-1,1},{-1,-1}};
	static boolean[][] isVisited;
	static int answer;
	static Queue<Location> queue;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		while(true) {
			answer = 0;
			st = new StringTokenizer(br.readLine());
			
			C = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			
			if(C==0 && R == 0) {
				break;
			}
			
			map = new int[R][C];
			isVisited = new boolean[R][C];
			
			for(int r=0; r<R; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c=0; c<C; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int r=0; r<R; r++) {
				for(int c=0; c<C; c++) {
					if(map[r][c] == 1 && !isVisited[r][c]) {
						// bfs(r,c);
						dfs(r,c);
						answer++;
					}
				}
			}
			
			
			bw.write(answer+"\n");
			
		}
		
		bw.flush();
		bw.close();
		br.close();
		
		
	}
	
	static void bfs(int r, int c) {
		queue = new LinkedList<>();
		queue.offer(new Location(r,c));
		
		while(!queue.isEmpty()) {
			Location now = queue.poll();
			isVisited[now.r][now.c] = true;
			
			for(int i=0; i<8; i++) {
				int nr = now.r + dir[i][0];
				int nc = now.c + dir[i][1];
				
				if(nr>=0 && nc>=0 && nr<R && nc<C && !isVisited[nr][nc] && map[nr][nc] == 1) {
					isVisited[nr][nc] = true;
					queue.offer(new Location(nr,nc));
				}
			}
			
		}
		
		
	}
	
	static void dfs(int r, int c) {
		isVisited[r][c] = true;
		
		for(int i=0; i<8; i++) {
			int nr = r + dir[i][0];
			int nc = c + dir[i][1];
			
			if(nr>=0 && nc>=0 && nr<R && nc<C && !isVisited[nr][nc] && map[nr][nc] == 1) {
				dfs(nr,nc);
			}
		}
	}

}
