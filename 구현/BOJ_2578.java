package 구현;

import java.util.Scanner;

/**
 * BOJ_2578_S5_빙고
 * @author mingggkeee
 * 구현
 */

public class BOJ_2578 {
	static int[][] map = new int[5][5];
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		for(int r=0; r<5; r++) {
			for(int c=0; c<5; c++) {
				map[r][c] = sc.nextInt();
			}
		}
		
		int bingo = 0;
		int answer = 0;
		
		for(int i=1; i<=25; i++) {
			int num = sc.nextInt();
			bingo = 0;
			for(int r=0; r<5; r++) {
				for(int c=0; c<5; c++) {
					if(map[r][c] == num) {
						map[r][c] = 0;
						break;
					}
				}
			}
			
			// 가로 확인
			for(int r=0; r<5; r++) {
				int cnt = 0;
				for(int c=0; c<5; c++) {
					if(map[r][c] == 0) {
						cnt++;
					}
				}
				if(cnt==5) {
					bingo++;
				}
			}
			
			// 세로 확인
			for(int c=0; c<5; c++) {
				int cnt = 0;
				for(int r=0; r<5; r++) {
					if(map[r][c] == 0) {
						cnt++;
					}
				}
				if(cnt==5) {
					bingo++;
				}
			}
			
			// 대각선 확인
			if(map[0][0] == 0 && map[1][1] == 0 && map[2][2] == 0 && map[3][3] == 0 && map[4][4] == 0) {
				bingo++;
			}
			
			if(map[0][4] == 0 && map[1][3] == 0 && map[2][2] == 0 && map[3][1] == 0 && map[4][0] == 0) {
				bingo++;
			}
			
			if(bingo>=3) {
				answer = i;
				break;
			}
		}
		
		System.out.println(answer);
		
		
		sc.close();
	}

}
