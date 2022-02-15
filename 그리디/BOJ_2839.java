package 그리디;

import java.util.Scanner;

/**
 * BOJ_2839_B1_설탕 배달
 * @author mingggkeee
 * 그리디
 */

public class BOJ_2839 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int bag = 0;
		
		while(N>=0) {
			if(N%5==0) {
				bag+=N/5;
				System.out.println(bag);
				N=0;
				break;
			}
			N-=3;
			bag +=1;
		}
		
		if(N!=0) {
			System.out.println(-1);
		}
		
		sc.close();
	}
}
