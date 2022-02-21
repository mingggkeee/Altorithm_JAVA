package DFS와BFS;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BOJ_1926_S1_그림
 * @author mingggkeee
 * BFS,DFS
 */

public class BOJ_1926 {
	
	static int R,C;
	static int[][] map;
	static boolean[][] isVisited;
	static int[][] dir= {{0,1},{0,-1},{1,0},{-1,0}};
	static int count=0;
	static int count2=0;
	static int answer=0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		isVisited = new boolean[R][C];
		
		for(int r=0;r<R;r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0;c<C;c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int r=0;r<R;r++) {
			for(int c=0;c<C;c++) {
				if(map[r][c] == 1 && !isVisited[r][c]) {
					count2 = 1;
					count++;
					// dfs(r,c);
					bfs(r,c);
					answer = Math.max(answer, count2);
				}
			}
		}
		
		System.out.println(count);
		System.out.println(answer);
		
	}
	
	public static void dfs(int r, int c) {
		isVisited[r][c] = true;
		
		for(int i=0; i<4; i++) {
			int nr = r + dir[i][0];
			int nc = c + dir[i][1];
			if(nr>=0 && nc>=0 && nr<R && nc<C && map[nr][nc] == 1 && !isVisited[nr][nc]) {
				count2++;
				dfs(nr,nc);
			}
		}
		
		
	}
	
	public static void bfs(int r, int c) {
		Queue<int []> queue = new LinkedList<int[]>();
		queue.offer(new int[] {r,c});
		isVisited[r][c] = true;
		
		while(!queue.isEmpty()) {
			int temp[] = queue.poll();
			int nr = temp[0];
			int nc = temp[1];
			for(int i=0; i<4; i++) {
				int nr2 = nr + dir[i][0];
				int nc2 = nc + dir[i][1];
				if(nr2>=0 && nc2>=0 && nr2<R && nc2<C && map[nr2][nc2] == 1 && !isVisited[nr2][nc2]) {
					count2++;
					queue.offer(new int[] {nr2,nc2});
					isVisited[nr2][nc2] = true;
				}
			}
		}
	}

}
