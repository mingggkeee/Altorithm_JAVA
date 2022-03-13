package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ_2239_G4_스도쿠
 * @author mingggkeee
 * 백트래킹
 */
public class BOJ_2239 {
	static int[][] map = new int[9][9];
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int r=0; r<9; r++) {
			String input = br.readLine();
			for(int c=0; c<9; c++) {
				map[r][c] = input.charAt(c)-'0';
			}
		}

		sudoku(0, 0);
	}
	
	static void sudoku(int r, int c) {
		
		if(c == 9) {
			sudoku(r+1, 0);
			return;
		}
		
		if(r == 9) {
			for(int [] i : map) {
				for(int k : i) {
					System.out.print(k);
				}
				System.out.println();
			}
			
			System.exit(0);
		}
		
		// 탐색
		if(map[r][c] == 0) {
			for(int i=1; i<=9; i++) {
				if(isPossible(r, c, i)) {
					map[r][c] = i;
					sudoku(r,c+1);
				}
			}
			map[r][c] = 0;
			return;
		}
		
		sudoku(r, c+1);
		
		
	}
	
	static boolean isPossible(int r, int c, int value) {
		
		// 같은 행
		for(int i=0; i<9; i++) {
			if(map[r][i] == value)
				return false;
		}
		
		// 같은 열
		for(int j=0; j<9; j++) {
			if(map[j][c] == value)
				return false;
		}
		
		// 같은 3 * 3칸
		int row = (r/3)*3;
		int col = (c/3)*3;
		
		for(int i=row; i<row+3; i++) {
			for(int j=col; j<col+3; j++) {
				if(map[i][j] == value)
					return false;
			}
		}
		
		return true;
	}
}
