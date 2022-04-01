package 최단경로;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * BOJ_4485_G4_녹색 옷 입은 애가 젤다지?
 * @author mingggkeee
 * 다익스트라, BFS
 */

public class BOJ_4485 {

	static int N;
	static int[][] map, distance;
	static int INF = Integer.MAX_VALUE;
	static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
	static int i = 1;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N==0) {
				break;
			}
			map = new int[N][N];
			distance = new int[N][N];
			for(int r=0; r<N; r++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int c=0; c<N; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
					distance[r][c] = INF;
				}
			}
			
			System.out.println("Problem "+ i++ +": "+ bfs());
		}
		
	}
	
	static int bfs() {
		PriorityQueue<Point> pq = new PriorityQueue<>();
		pq.offer(new Point(0, 0, map[0][0]));
		distance[0][0] = map[0][0];
		
		while(!pq.isEmpty()) {
			Point now = pq.poll();
			for(int i=0; i<4; i++) {
				int nr = now.r+dir[i][0];
				int nc = now.c+dir[i][1];
				if(nr>=0 && nc>=0 && nr<N && nc<N && (distance[nr][nc] > distance[now.r][now.c] + map[nr][nc])) {
					distance[nr][nc] = distance[now.r][now.c] + map[nr][nc];
					pq.offer(new Point(nr, nc, distance[nr][nc]));
				}
			}
		}
		
		return distance[N-1][N-1];
	}
	
	static class Point implements Comparable<Point>{
		int r;
		int c;
		int cost;
		
		public Point(int r, int c, int cost) {
			this.r = r;
			this.c = c;
			this.cost = cost;
		}

		@Override
		public int compareTo(Point o) {
			return this.cost-o.cost;
		}
		
		
	}
	
}
