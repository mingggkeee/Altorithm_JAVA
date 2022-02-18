package 분할정복;

import java.util.Scanner;

/**
 * BOJ_2630_S3_색종이만들기
 * @author mingggkeee
 * 분할정복, 재귀
 */

public class BOJ_2630 {
	
	static int N;
	static int[][] map;
	static int white, blue;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				map[r][c] = sc.nextInt();
			}
		}
		
		search(0,0,N);
		
		System.out.println(white);
		System.out.println(blue);
		
		sc.close();
	}
	
	public static void search(int r, int c, int size) {
		
		if(isPossible(r, c, size)) {
			if(map[r][c] == 1) {
				blue++;
			} else {
				white++;
			}
			return;
		}
		
		int size2 = size/2;
		
		search(r,c,size2);
		search(r,c+size2, size2);
		search(r+size2, c, size2);
		search(r+size2, c+size2, size2);
		
	}
	
	
	
	public static boolean isPossible(int r, int c, int size) {
		int compare = map[r][c];
		
		for(int i=r; i<r+size; i++) {
			for(int j=c; j<c+size; j++) {
				if(compare != map[i][j]) {
					return false;
				}
			}
		}
		
		return true;
	}

}
