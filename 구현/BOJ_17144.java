package 구현;

import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ_17144_G4_미세먼지 안녕!
 * @author mingggkeee
 * 구현, 시뮬레이션, 완전탐색
 * 공기 청정기는 항상 0번열에 설치, 크기는 두 행 차지
 */

public class BOJ_17144 {
	
	static int R,C,T;
	static int[][] map;
	static int[][] tempMap;
	static int[][] circulator = new int[2][2];	// 공기청정기의 행
	static boolean[][] isVisited;
	
	static int[][] dir1 = {{0,1},{-1,0},{0,-1},{1,0}};
	static int[][] dir2 = {{0,1},{1,0},{0,-1},{-1,0}};
	
	static int result;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		int temp = 0;
		
		map = new int[R][C];

		
		for(int r=0; r<R; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<C; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if(map[r][c] == -1) {
					circulator[temp][0] = r;
					circulator[temp++][1] = 0;
				}
			}
		}
		
		for(int t=0; t<T; t++) {
			dust();
			circul();
		}
		
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				result += map[r][c];
			}
		}
		
		System.out.println(result + 2);
		
	}
	
	static void circul() {
		isVisited = new boolean[R][C];
		tempMap = new int[R][C];
		
		// 위쪽 청정
		int r = circulator[0][0];
		int c = circulator[0][1];
		tempMap[r][c] = -1;
		isVisited[r][c] = true;
		int stack = 0;
		c++;
		while(true) {
			int nr = r + dir1[stack%4][0];
			int nc = c + dir1[stack%4][1];
			if(nr>=0 && nc>=0 && nr<R && nc<C) {
				if(map[nr][nc] == -1) {
					break;
				}
				tempMap[nr][nc] = map[r][c];
				map[r][c] = 0;
				isVisited[nr][nc] = true;
			} else {
				stack++;
				nr = r + dir1[stack%4][0];
				nc = c + dir1[stack%4][1];
				tempMap[nr][nc] = map[r][c];
				map[r][c] = 0;
				isVisited[nr][nc] = true;
			}
			
			r = nr;
			c = nc;
		}
		
		// 아래쪽 청정
		r = circulator[1][0];
		c = circulator[1][1];
		tempMap[r][c] = -1;
		c++;
		stack = 0;
		while(true) {
			int nr = r + dir2[stack%4][0];
			int nc = c + dir2[stack%4][1];
			if(nr>=0 && nc>=0 && nr<R && nc<C) {
				if(map[nr][nc] == -1) {
					map[r][c] = 0;
					break;
				}
				tempMap[nr][nc] = map[r][c];
				map[r][c] = 0;
				isVisited[nr][nc] = true;
			} else {
				stack++;
				nr = r + dir2[stack%4][0];
				nc = c + dir2[stack%4][1];
				tempMap[nr][nc] = map[r][c];
				map[r][c] = 0;
				isVisited[nr][nc] = true;
			}
			
			r = nr;
			c = nc;
		}
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(!isVisited[i][j]) {
					tempMap[i][j] = map[i][j];
				}
			}
		}
		
		map = tempMap;
	}
	
	static void dust() {
		
		tempMap = new int[R][C];
		
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				
				int sub = map[r][c] / 5;
				
				for(int i=0; i<4; i++) {
					int nr = r + dir1[i][0];
					int nc = c + dir1[i][1];
					
					if(nr>=0 && nc>=0 && nr<R && nc<C && map[nr][nc]!=-1) {
						tempMap[nr][nc] += sub;
						map[r][c] -= sub;
					}
					
				}
				
				
			}
		}
		
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				map[r][c] += tempMap[r][c];
			}
		}
	}

}
