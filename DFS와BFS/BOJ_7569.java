package DFS와BFS;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BOJ_7569_G5_토마토
 * @author mingggkeee
 * BFS
 */

public class BOJ_7569 {
	
	static int R,C,H;
	static int[][][] map;
	static Queue<int[]> queue = new LinkedList<int[]>();
	// 동서남북위아래
	static int[] dr = {0,0,1,-1,0,0};
	static int[] dc = {1,-1,0,0,0,0};
	static int[] dh = {0,0,0,0,1,-1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		map = new int[H][R][C];
		
		for(int h=0; h<H; h++) {
			for(int r=0;r<R;r++) {
				st = new StringTokenizer(br.readLine());
				for(int c=0;c<C;c++) {
					map[h][r][c] = Integer.parseInt(st.nextToken());
					if(map[h][r][c] == 1)
						queue.offer(new int[] {h,r,c});
				}
			}
		}
		
		System.out.println(bfs());
	}
	
	static public int bfs() {
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			
			int h = temp[0];
			int r = temp[1];
			int c = temp[2];
			
			for(int i=0; i<6; i++) {
				int nh = h + dh[i];
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if(nh>=0 && nr>=0 && nc>=0 && nh<H && nr<R && nc<C) {
					if(map[nh][nr][nc] == 0) {
						queue.offer(new int[] {nh,nr,nc});
						
						map[nh][nr][nc] = map[h][r][c] + 1;
					}
				}
			}
		}
		
		int answer = Integer.MIN_VALUE;
		
		for(int h=0;h<H;h++) {
			for(int r=0;r<R;r++) {
				for(int c=0;c<C;c++) {
					if(map[h][r][c] == 0) {
						return -1;
					}
					answer = Math.max(answer, map[h][r][c]);
				}
			}
		}
		
		if(answer==1) {
			return 0;
		} else {
			return answer-1;
		}
	}

}
