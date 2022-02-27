package SWEA;

import java.io.*;
import java.util.StringTokenizer;

/**
 * SWEA_7236_D3_저수지의 물의 총 깊이 구하기
 * @author mingggkeee
 *
 */

public class SWEA_7236 {
	
	static int T;
	static char [][] map;
	static int N;
	static int answer;
	static int [][] dir = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			
			answer = Integer.MIN_VALUE;
			
			N = Integer.parseInt(br.readLine());
			
			map = new char[N][N];
			
			for(int r=0; r<N; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c=0; c<N; c++) {
					map[r][c] = st.nextToken().charAt(0);
				}
			}
			
			search();
			
			System.out.println("#"+t+" " + answer);
			
		}
	}
	
	static void search() {
		
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				
				if(r-1>=0 && c-1>=0 && r+1<N && c+1<N) {
					
					int count = 8;
					
					for(int i=0; i<8; i++) {
						int nr = r + dir[i][0];
						int nc = c + dir[i][1];
						
						if(map[nr][nc] == 'G') {
							count--;
						}
						
					}
					
					if(count == 0) {
						count = 1;
					}
					
					answer = Math.max(answer, count);
					
					
				}
				
			}
		}
		
	}

}
