package 구현;

import java.util.Scanner;

/**
 * BOJ_10163_B1_색종이
 * @author mingggkeee
 * 구현
 */

public class BOJ_10163 {
	
	static int N;
	static int map[][] = new int[1001][1001];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		for(int i=1; i<=N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int xplus = sc.nextInt();
			int yplus = sc.nextInt();
			
			for(int r=y; r<y+yplus; r++) {
				for(int c=x; c<x+xplus; c++) {
					map[r][c] = i;
				}
			}
		}
		
		for(int i=1; i<=N; i++) {
			int count = 0;
		
			for(int r=0; r<map.length; r++) {
				for(int c=0; c<map[0].length; c++) {
					if(map[r][c] == i) {
						count++;
					}
				}
			}
			System.out.println(count);
		}
		
		sc.close();
	}

}
