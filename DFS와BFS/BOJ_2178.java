package DFS와BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * BOJ_2178_S1_미로탐색
 * @author mingggkeee
 * BFS,DFS,그래프
 */

public class BOJ_2178 {
	
	static int R,C;
	static int answer = Integer.MAX_VALUE;
	static int[][] map;
	static boolean[][] isVisited;
	static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		R = sc.nextInt();
		C = sc.nextInt();
		sc.nextLine();
		map = new int[R][C];
		isVisited = new boolean[R][C];
		
		for(int r=0;r<R;r++) {
			String str = sc.nextLine();
			for(int c=0;c<C;c++) {
				map[r][c] = str.charAt(c)-'0';
			}
		}
		
		// dfs(0,0,1);
		bfs();
		
		// System.out.println(answer);
		System.out.println(map[R-1][C-1]);
		
		sc.close();
	}
	
	public static void bfs() {
		
		Queue<int[]> queue = new LinkedList<int[]>();
		
		queue.offer(new int[] {0,0});
		
		while(!queue.isEmpty()) {
			int temp[] = queue.poll();
			int r = temp[0];
			int c = temp[1];
			
			for(int i=0; i<4; i++) {
				int nr = r + dir[i][0];
				int nc = c + dir[i][1];
				
				if(nr>=0 && nc>=0 && nr<R && nc<C && map[nr][nc] == 1 && !isVisited[nr][nc]) {
					queue.offer(new int[] {nr,nc});
					map[nr][nc] = map[r][c] + 1;
					isVisited[nr][nc] = true;
				}
				
			}
		}
		
		
	}
	
	
	
	public static void dfs(int r, int c, int count) {
		
		if(count > answer) {
			return;
		}
		
		if(r==R-1 && c==C-1) {
			answer = Math.min(count, answer);
			return;
		}
		
		isVisited[r][c] = true;
		for(int i=0; i<4; i++) {
			int nr = r+dir[i][0];
			int nc = c+dir[i][1];
			
			if(nr>=0 && nc>=0 && nr<R && nc<C && map[nr][nc] == 1 && !isVisited[nr][nc]) {
				isVisited[nr][nc] = true;
				dfs(nr,nc,count+1);
				isVisited[nr][nc] = false;
			}
		}
		
		
	}

}
