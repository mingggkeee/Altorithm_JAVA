package 구현;

import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ_14503_G5_로봇 청소기
 * @author mingggkeee
 * 구현
 */


public class BOJ_14503 {
	
	static int R,C;
	static int[][] map;
	static boolean[][] isVisited;
	static int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};
	static int robotR, robotC, cur;
	static int count;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		robotR = Integer.parseInt(st.nextToken());
		robotC = Integer.parseInt(st.nextToken());
		cur = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		isVisited = new boolean[R][C];
		
		for(int r=0; r<R; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<C; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		while(true) {
			if(!isVisited[robotR][robotC]) {
				isVisited[robotR][robotC] = true;
				count++;
			}
			
			boolean check = false;
			
			for(int i=0; i<4; i++) {
				int nr = robotR + dir[(cur+3)%4][0];
				int nc = robotC + dir[(cur+3)%4][1];
				
				if(map[nr][nc] != 1 && !isVisited[nr][nc]) {
					cur += 3;
					robotR = nr;
					robotC = nc;
					check = true;
					break;
				}
				else {
					cur+=3;
				}
			}
			
			if(check) {
				continue;
			}
			else {
				int nr = robotR + dir[(cur+2)%4][0];
				int nc = robotC + dir[(cur+2)%4][1];
				
				if(map[nr][nc] != 1) {
					robotR = nr;
					robotC = nc;
				}
				else {
					break;
				}
				
			}

		}
		
		System.out.println(count);
		
	}

}
