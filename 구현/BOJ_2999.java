package 구현;

import java.util.Scanner;

/**
 * BOJ_2999_B1_비밀 이메일
 * @author mingggkeee
 * 구현
 */

public class BOJ_2999 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String input = sc.nextLine();
		
		int N = input.length();
		
		int R = 0;
		int C = 0;
		
		for(int i=1; i<=N; i++) {
			
			if(N%i ==0) {
				int nr = i;
				int nc = N/i;
				if(nc>=nr) {
					R = nr;
					C = nc;
				}
			}
			
		}
		
		char[][] map = new char[R][C];
		
		int idx = 0;
		
		for(int c=0; c<C; c++) {
			for(int r=0; r<R; r++) {
				map[r][c] = input.charAt(idx);
				idx++;
			}
		}
		
		
		String output = "";
		
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				output += map[r][c];
			}
		}
		
		System.out.println(output);
		
		sc.close();
		
	}

}
