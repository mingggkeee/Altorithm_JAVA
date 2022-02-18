package 구현;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * BOJ_2628_S5_종이자르기
 * @author mingggkeee
 *
 */

public class BOJ_2628 {
	
	static int x,y, N;
	static int [][] map;
	static List<Integer> list = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		x = sc.nextInt();	// 가로 길이
		y = sc.nextInt();	// 세로 길이
		
		N = sc.nextInt();
		map = new int[y][x];
		
		for(int i=0; i<N; i++) {
			// 가로는 0 세로는 1
			int num = sc.nextInt();
			int subNum = sc.nextInt();
			
			if(num==0) {
				
			} else {
			 	
			}
		}
		
		
		
		
		sc.close();
	}

}
