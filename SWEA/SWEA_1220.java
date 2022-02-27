package SWEA;

import java.io.*;
import java.util.StringTokenizer;

/**
 * SWEA_1220_D3_Magnetic
 * @author mingggkeee
 * 1은 N극 성질 , 2는 S극 성질, 테이블 위가 N극, 테이블 아래가 S극
 */

public class SWEA_1220 {
	
	static int[][] map;
	static int N;
	static int answer;
	static boolean[][] isVisited;
	static int dir[][] = {{0,0},{1,0},{-1,0}};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int t=1; t<=10; t++) {
			answer = 0;
			N = Integer.parseInt(br.readLine());
			
			map = new int[N][N];
			
			for(int r=0; r<N; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c=0; c<N; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			move();
			
			System.out.println("#"+t+" "+answer);
			
		}
		
		
	}
	
	static void move() {
		int count = 0;
		
		while(true) {
			isVisited = new boolean[N][N];
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					if(map[r][c] == 1 && !isVisited[r][c]) {
						isVisited[r][c] = true;
						int nr = r + 1;
						if(nr<N) {
							if(map[nr][c] == 0) {
								map[nr][c] = 1;
								map[r][c] = 0;
								count++;
								isVisited[nr][c] = true;
							}
							
						} else if(nr == N) {
							map[r][c] = 0;
						}
					}
					
					if(map[r][c] == 2) {
						int nr = r -1;
						
						if(nr>=0) {
							if(map[nr][c] == 0) {
								map[nr][c] = 2;
								map[r][c] = 0;
								count++;
							}
						}else if(nr == -1) {
							map[r][c] = 0;
						}
					}
					
				}
			}
			
			if(count == 0) {
				break;
			}
			
			count = 0;
			
		}
		
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				
				if(map[r][c] == 1 && r+1<N) {
					if(map[r+1][c] == 2) {
						answer++;
					}
				}
				
			}
		}
		
		
	}

}
