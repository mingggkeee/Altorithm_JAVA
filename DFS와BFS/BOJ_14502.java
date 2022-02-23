package DFS와BFS;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BOJ_14502_G5_연구소
 * @author mingggkeee
 * BFS, DFS, 조합
 */

public class BOJ_14502 {
	
	static int R,C;
	static int[][] map;
	static int answer = Integer.MIN_VALUE;
	static int K = 3;
	static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
	
	static class Virus{
		int r;
		int c;
		
		public Virus(int r, int c) {
			this.r=r;
			this.c=c;
		}
	}
	
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
			}
		}
		
		combi(0);
		System.out.println(answer);
		
	}
	
	static void combi(int cnt) {
		if(cnt==K) {
			
			bfs();
			
			return;
		}
		
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				if(map[r][c] == 0) {
					map[r][c] = 1;
					combi(cnt+1);
					map[r][c] = 0;
				}
			}
		}
		
		
	}
	
	static void bfs() {
		int[][] temp = new int[R][C];
		Queue<Virus> queue = new LinkedList<>();
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				temp[i][j] = map[i][j];
			}
		}
		
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				if(temp[r][c] == 2) {
					queue.offer(new Virus(r, c));
				}
			}
		}
		
		while(!queue.isEmpty()) {
			Virus v = queue.poll();
			
			for(int i=0; i<4; i++) {
				int nr = v.r + dir[i][0];
				int nc = v.c + dir[i][1];
				
				if(nr>=0 && nc>=0 && nr<R && nc<C) {
					if(temp[nr][nc] == 0) {
						temp[nr][nc] = 2;
						queue.offer(new Virus(nr,nc));
					}
				}
			}
		}
		
		safeArea(temp);
		
	}
	
	static void safeArea(int[][] temp) {
		int count = 0;
		
		for(int r=0;r<R;r++) {
			for(int c=0;c<C;c++) {
				if(temp[r][c] == 0) {
					count++;
				}
			}
		}
		

		answer = Math.max(count, answer);
	}

}
