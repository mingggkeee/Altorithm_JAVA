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

public class BOJ_7576 {
	
	static int R,C;
	static int[][] map;
	static boolean[][] isVisited;
	static Queue<int []> queue = new LinkedList<int[]>();
	static int day;
	static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		isVisited = new boolean[R][C];
		map = new int[R][C];
		
		for(int r=0;r<R;r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0;c<C;c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if(map[r][c] == 1) {
					queue.offer(new int[] {r,c});
				}
			}
		}
		
		if(check3()) {
			System.out.println(0);
		} else {
			bfs();
			if(check3()) {
				System.out.println(day-1);
			} else {
				System.out.println(-1);
			}
		}
	}
	
	public static void bfs() {
		
		
		while(!queue.isEmpty()) {
			if(check()==true) {
				break;
			}
			int size = queue.size();
			while(size-->0) {
				int [] temp = queue.poll();
				int r = temp[0];
				int c = temp[1];
				map[r][c] = 1;
				isVisited[r][c] = true;
				for(int i=0; i<4; i++) {
					int nr = r + dir[i][0];
					int nc = c + dir[i][1];
					if(nr>=0 && nc>=0 && nr<R && nc<C && map[nr][nc] == 0 && !isVisited[nr][nc]) {
						isVisited[nr][nc] = true;
						queue.offer(new int[] {nr,nc});
					}
				}
			}
			day++;
		}
	}
	
	public static boolean check() {
		for(int r=0;r<R;r++) {
			for(int c=0;c<C;c++) {
				if(map[r][c] == 0 && check2(r,c)) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static boolean check2(int r, int c) {
		int stack = 0;
		for(int i=0; i<4; i++) {
			int nr = r + dir[i][0];
			int nc = c + dir[i][1];
			if(nr<0 || nc<0 || nr>=R || nc>=C || map[nr][nc] == -1) {
				stack++;
			}
		}
		if(stack==4) {
			return false;
		}
		
		return true;
	}
	
	public static boolean check3() {
		for(int r=0;r<R;r++) {
			for(int c=0;c<C;c++) {
				if(map[r][c] == 0) {
					return false;
				}
			}
		}
		
		return true;
	}

}
