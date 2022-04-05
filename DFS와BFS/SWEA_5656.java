package DFS와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * SWEA_5656_벽돌 깨기
 * @author mingggkeee
 * BFS
 */

public class SWEA_5656 {

	static int T, N, R, C;
	static int answer;
	static int[][] map, temp;
	static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
	static int[] selected;
	static boolean[][] isVisited;
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			answer = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			
			map = new int[R][C];
			
			for(int r=0; r<R; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c=0; c<C; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
					if(map[r][c]!=0) {
						answer++;
					}
				}
			}
			
			selected = new int[N];
			
			permu(0);
			
			sb.append("#"+t+" "+answer+"\n");
		}
		
		System.out.println(sb.toString());
		
	}
	
	static void permu(int cnt) {
		if(cnt == N) {
			breakBlock(selected);
			return;
		}
		
		for(int i=0; i<C; i++) {
			selected[cnt] = i;
			permu(cnt+1);
		}
	}
	
	static void breakBlock(int[] selected) {
		
		temp = new int[R][C];
		
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				temp[r][c] = map[r][c];
			}
		}
		
		for(int i=0; i<N; i++) {
			
			int breakCol = selected[i];
			
			for(int r=0; r<R; r++) {
				if(temp[r][breakCol] != 0) {
					
					if(temp[r][breakCol] == 1) {
						temp[r][breakCol] = 0;
					} else {
						bfs(r, breakCol, temp[r][breakCol]);
					}
					break;
					
				}
			}
			
			
		}
		
		int cnt = 0;
		
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				if(temp[r][c] != 0) {
					cnt++;
				}
			}
		}
		
		answer = Math.min(answer, cnt);
		
		
		
	}
	
	static void bfs(int startR, int startC, int power) {
		
		Queue<Bomb> queue = new LinkedList<>();
		isVisited = new boolean[R][C];
		queue.offer(new Bomb(startR, startC, power));
		isVisited[startR][startC] = true;
		
		
		while(!queue.isEmpty()) {
			
			Bomb now = queue.poll();
			temp[now.r][now.c] = 0;
			
			for(int i=0; i<4; i++) {
				int nr = now.r;
				int nc = now.c;
				
				for(int j=0; j<now.power-1; j++) {
					
					nr += dir[i][0];
					nc += dir[i][1];
					
					if(nr<0 || nc<0 || nr>=R || nc>=C || isVisited[nr][nc]) {
						continue;
					}
					
					isVisited[nr][nc] = true;
					if(temp[nr][nc] == 0) {
						continue;
					}
					
					if(temp[nr][nc] == 1) {
						temp[nr][nc] = 0;
					} else {
						queue.offer(new Bomb(nr, nc, temp[nr][nc]));
						temp[nr][nc] = 0;
					}
					
				}
				
			}
			
		}
		
		for(int r=R-1; r>=0; r--) {
			for(int c=0; c<C; c++) {
				
				if(temp[r][c] != 0) {
					int nr = r;
					int value = temp[r][c];
					while(true) {
						nr++;
						if(nr>=R) {
							break;
						}
						if(temp[nr][c] != 0) {
							break;
						}
						temp[nr-1][c] = 0;
						temp[nr][c] = value;
						
					}
					
				}
				
			}
		}
		
		
	}
	
	static class Bomb{
		int r;
		int c;
		int power;
		
		public Bomb(int r, int c, int power) {
			this.r = r;
			this.c = c;
			this.power = power;
		}
		
	}
	
}
