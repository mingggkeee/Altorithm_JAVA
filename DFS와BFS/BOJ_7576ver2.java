package DFS와BFS;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BOJ_7576_G5_토마토
 * @author mingggkeee
 * BFS
 */

public class BOJ_7576ver2 {
	
	static int R,C;
	static int [][] map;
	static boolean [][] isVisited;
	static int [][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
	static Queue<int[]> queue = new LinkedList<int[]>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		isVisited = new boolean[R][C];
		
		for(int r=0; r<R; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<C; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if(map[r][c] == 1) {
					queue.offer(new int[] {r,c});
				}
			}
		}
		
		System.out.println(bfs());
		
		
	}
	
	static int bfs() {
		
		while(!queue.isEmpty()) {
	
			int[] now = queue.poll();
			
			for(int i=0; i<4; i++) {
				int nr = now[0] + dir[i][0];
				int nc = now[1] + dir[i][1];
				
				if(nr>=0 && nc>=0 && nr<R && nc<C) {
					if(map[nr][nc] == 0) {
						queue.offer(new int[] {nr,nc});
						map[nr][nc] = map[now[0]][now[1]] + 1;
					}
				}
				
			}
			
			
		}
		
		int answer = Integer.MIN_VALUE;
		

		for(int r=0;r<R;r++) {
			for(int c=0;c<C;c++) {
				if(map[r][c] == 0) {
					return -1;
				}
				answer = Math.max(answer, map[r][c]);
			}
		}
			
		
		
		if(answer==1) {
			return 0;
		} else {
			return answer-1;
		}
	
		
		
		
	}
	
}
