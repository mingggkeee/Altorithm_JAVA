package DFS와BFS;

import java.io.*;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * BOJ_2667_S1_단지번호붙이기
 * @author mingggkeee
 * BFS,DFS
 */

public class BOJ_2667 {
	static int N,count2;
	static int[][] map;
	static boolean[][] isVisited;
	static int count;
	static int [][] dir = {{0,1}, {0,-1}, {1,0}, {-1,0}};
	static PriorityQueue<Integer> pr = new PriorityQueue<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		isVisited = new boolean[N][N];
		
		for(int r=0; r<N; r++) {
			String str = br.readLine();
			for(int c=0;c<N;c++) {
				map[r][c] = str.charAt(c)-'0';
			}
		}
		
		for(int r=0;r<N;r++) {
			for(int c=0;c<N;c++) {
				if(map[r][c] == 1 && !isVisited[r][c]) {
					count++;
					count2=1;
					dfs(r,c);
					pr.offer(count2);
					// bfs(r,c);
				}
			}
		}
		
		System.out.println(count);
		while(!pr.isEmpty()) {
			System.out.println(pr.poll());
		}
		
		
	}
	
	public static void bfs(int r, int c) {
		int counting = 1;
		isVisited[r][c] = true;
		Queue<int []> queue = new LinkedList<int[]>();
		queue.offer(new int[] {r,c});
		
		while(!queue.isEmpty()) {
			int [] temp = queue.poll();
			int nr = temp[0];
			int nc = temp[1];
			
			for(int i=0; i<4; i++) {
				int nr2 = nr + dir[i][0];
				int nc2 = nc + dir[i][1];
				if(nr2>=0 && nc2>=0 && nr2<N && nc2<N && map[nr2][nc2] == 1 && !isVisited[nr2][nc2]) {
					isVisited[nr2][nc2] = true;
					queue.offer(new int[] {nr2,nc2});
					counting++;
				}
			}
		}
		
		pr.offer(counting);
	}
	
	public static void dfs(int r, int c) {
		
		isVisited[r][c] = true;
		
		for(int i=0; i<4; i++) {
			int nr = r + dir[i][0];
			int nc = c + dir[i][1];
			if(nr>=0 && nc>=0 && nr<N && nc<N && map[nr][nc] == 1 && !isVisited[nr][nc]) {
				isVisited[nr][nc] = true;
				count2++;
				dfs(nr,nc);
				
			}
		}
		
	}
}
