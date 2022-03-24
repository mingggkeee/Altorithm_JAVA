package 구현;

import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ_18808_G3_스티커 붙이기
 * @author mingggkeee
 * 시뮬레이션 , 구현
 */

public class BOJ_18808 {
	
	static int R,C,K;
	static int[][] map;
	static int[][] temp;
	static int tempR, tempC;
	static int count;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			tempR = Integer.parseInt(st.nextToken());
			tempC = Integer.parseInt(st.nextToken());
			temp = new int[tempR][tempC];
			for(int r=0; r<tempR; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c=0; c<tempC; c++) {
					temp[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int j=0; j<4; j++) {
				
				for(int r=0; r<R-tempR; r++) {
					for(int c=0; c<C-tempC; c++) {
						boolean check = true;
						for(int r2=0; r2<r+tempR; r2++) {
							for(int c2=0; c2<c+tempC; c2++) {
								if(temp[r2][c2] == 1) {
									if(map[r2][c2] == 1) {
										check = false;
										break;
									}
								}
							}
						}
						
						
						
					}
				}
				
				
			}
			
			
			
		}
	}

}
