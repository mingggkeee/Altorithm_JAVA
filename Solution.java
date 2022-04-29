import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class Solution {
	
	static int T, N, M, R, C, L, answer;
	static int[][] map;
	static boolean[][] isVisited;
	static int[][] dr = {{0,0,0,0},{-1,1,0,0},{-1,1,0,0},{0,0,0,0},{-1,0,0,0},{0,1,0,0},{0,1,0,0},{-1,0,0,0}}; //1번 - 7번
	static int[][] dc = {{0,0,0,0},{0,0,-1,1},{0,0,0,0},{0,0,-1,1},{0,0,0,1},{0,0,0,1},{0,0,-1,0},{0,0,-1,0}};
	static int[][] dir = {{1,2,5,6}, {1,2,4,7}, {1,3,4,5}, {1,3,6,7}}; //상하좌우
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			answer = 0;	
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			map = new int[N][M];
			
			for(int r=0; r<N; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c=0; c<M; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			isVisited = new boolean[N][M];
			bfs(R,C);
			
			sb.append("#"+t+" "+answer+"\n");
		}
		
		System.out.println(sb.toString());
		
	}
	
	static void bfs(int startR, int startC) {
		
		Queue<Thief> queue = new LinkedList<>();
		queue.offer(new Thief(startR, startC, 1));
		answer++;
		isVisited[startR][startC] = true;
		
		while(!queue.isEmpty()) {
			
			Thief now = queue.poll();
			
			if(now.count>=L) {
				continue;
			}
			
			for(int i=1; i<8; i++) { 
				if(map[now.r][now.c] == i) { // 파이프 모양 찾기
					for(int j=0; j<4; j++) { // 상하좌우
						int nr = now.r + dr[i][j];
						int nc = now.c + dc[i][j]; 
						
						if(now.r == nr && now.c == nc) 
							continue;
						
						if(nr<0 || nc<0 || nr>=N || nc>=M || map[nr][nc]==0) 
							continue;
						
						for(int k=0; k<4; k++) { //각 방향마다 갈 수 있는 곳 4군데씩 있음
							if(dir[j][k] == map[nr][nc]){ //가려고 했을 때 갈 수 있는 곳이면 가기
								if(!isVisited[nr][nc]){ 
									isVisited[nr][nc] = true;
									answer++;
									queue.offer(new Thief(nr,nc, now.count+1));
								}
							}
						}
					}
				}
			}
			
		}
	}
	
	static class Thief{
		int r;
		int c;
		int count;
		
		public Thief(int r, int c, int count) {
			this.r = r;
			this.c = c;
			this.count = count;
		}
		
		
	}

}
