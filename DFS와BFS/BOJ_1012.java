package DFS와BFS;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BOJ_1012_S2_유기농 배추
 * @author mingggkeee
 *
 */

public class BOJ_1012 {
	
	static int T, answer;
	static int R,C;
	static int [][] map;
	static int N;
	static boolean[][] isVisited;
	static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			answer = 0;
			st = new StringTokenizer(br.readLine());
			C = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			
			map = new int[R][C];
			isVisited = new boolean[R][C];
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				int c = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				map[r][c] = 1;
			}
			
			for(int r=0;r<R;r++) {
				for(int c=0;c<C;c++) {
					if(map[r][c] == 1 && !isVisited[r][c]) {
						isVisited[r][c] = true;
						answer++;
						// dfs(r,c);
						bfs(r,c);
					}
				}
			}
			
			System.out.println(answer);
			
		}
		
	}
	
	public static void bfs(int r, int c) {
		Queue<int []> queue = new LinkedList<int[]>();
		queue.offer(new int[] {r,c});
		
		while(!queue.isEmpty()) {
			int [] temp = queue.poll();
			
			for(int i=0; i<4; i++) {
				int nr = temp[0] + dir[i][0];
				int nc = temp[1] + dir[i][1];
				
				if(nr>=0 && nc>=0 && nr<R && nc<C && map[nr][nc] == 1 && !isVisited[nr][nc]) {
					isVisited[nr][nc] = true;
					queue.offer(new int[] {nr,nc});
				}
			}
		}
		
	}
	
	
	
	public static void dfs(int r, int c) {
		
		for(int i=0; i<4; i++) {
			int nr = r + dir[i][0];
			int nc = c + dir[i][1];
			if(nr>=0 && nc>=0 && nr<R && nc<C && map[nr][nc] == 1 && !isVisited[nr][nc]) {
				isVisited[nr][nc] = true;
				dfs(nr,nc);
			}
		}
		
	}

}
