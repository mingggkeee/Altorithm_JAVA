package DFS와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BOJ_7562_S1_나이트의 이동
 * @Author mingggkeee
 * @Date 2022. 5. 30.
 * @Category : BFS
 */
public class BOJ_7562 {
	
	static class Knight{
		int r;
		int c;
		int moveCnt;
		
		public Knight(int r, int c, int moveCnt) {
			this.r = r;
			this.c = c;
			this.moveCnt = moveCnt;
		}
	}
	
	static int T, N, startR, startC, endR, endC;
	static int[][] map;
	static boolean[][] isVisited;
	static int[][] dir = {{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2},{-1,-2},{-2,-1}};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			isVisited = new boolean[N][N];
			
			st = new StringTokenizer(br.readLine());
			startR = Integer.parseInt(st.nextToken());
			startC = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			endR = Integer.parseInt(st.nextToken());
			endC = Integer.parseInt(st.nextToken());
			
			System.out.println(bfs());
			
		}
	}
	
	static int bfs() {
		Queue<Knight> queue = new LinkedList<>();
		isVisited[startR][startC] = true;
		queue.add(new Knight(startR, startC, 0));
		
		while(!queue.isEmpty()) {
			
			Knight now = queue.poll();
			
			if(now.r == endR && now.c == endC) {
				return now.moveCnt;
			}
			
			for(int i=0; i<8; i++) {
				int nr = now.r + dir[i][0];
				int nc = now.c + dir[i][1];
				
				if(nr>=0 && nc>=0 && nr<N && nc<N && !isVisited[nr][nc]) {
					isVisited[nr][nc] = true;
					queue.add(new Knight(nr, nc, now.moveCnt+1));
				}
			}
			
		}
		
		return -1;
	}
	
}
