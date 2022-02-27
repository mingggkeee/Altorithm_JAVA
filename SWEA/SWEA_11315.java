package SWEA;

import java.util.Scanner;

/**
 * SWEA_11315_D3_오목 판정
 * @author mingggkeee
 *
 */

public class SWEA_11315 {
	
	static char [][] map;
	static int T;
	static int N;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			N = sc.nextInt();
			sc.nextLine();
			
			map = new char[N][N];
			
			for(int r=0; r<N; r++) {
				String input = sc.nextLine();
				for(int c=0; c<N; c++) {
					map[r][c] = input.charAt(c);
				}
			}
			
			boolean isExist = false;
			
			// 1 : 가로(오른쪽으로)
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					if(map[r][c]=='o') {
						if(c+4<N && map[r][c+1]=='o' && map[r][c+2]=='o' && map[r][c+3]=='o' && map[r][c+4]=='o') {
							isExist = true;
						}
					}
				}
			}
			
			// 2 : 세로(아래쪽으로)
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					if(map[r][c] == 'o') {
						if(r+4<N && map[r+1][c]=='o' && map[r+2][c]=='o' && map[r+3][c]=='o' && map[r+4][c]=='o') {
							isExist = true;
						}
						
					}
				}
			}
			
			// 3 : 대각선(오른쪽 위로)
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					if(map[r][c] == 'o') {
						if(r-4>=0 && c+4<N && map[r-1][c+1]=='o' && map[r-2][c+2]=='o' && map[r-3][c+3]=='o' && map[r-4][c+4]=='o') {
							isExist = true;
						}
						
					}
				}
			}
			
			// 4 : 대각선(오른쪽 아래로)
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					if(map[r][c] == 'o') {
						if(r+4<N && c+4<N && map[r+1][c+1]=='o' && map[r+2][c+2]=='o' && map[r+3][c+3]=='o' && map[r+4][c+4]=='o') {
							isExist = true;
						}
						
					}
				}
			}
			
			
			if(isExist) {
				System.out.println("#"+t+" YES");
			} else {
				System.out.println("#"+t+" NO");
			}
		}
		
		sc.close();
		
	}

}
