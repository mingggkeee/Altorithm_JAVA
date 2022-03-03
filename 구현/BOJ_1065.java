package 구현;

import java.util.Scanner;

/**
 * BOJ_1065_S4_한수
 * @author mingggkeee
 * 구현
 */

public class BOJ_1065 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		if(N==1000) {
			N--;
		}
		
		int count = 0;
		
		if(N<100) {
			System.out.println(N);
		} else {
			count = 99;
			for(int i=100; i<=N; i++) {
				int a = i/100;
				int b = (i%100)/10;
				int c = (i%100)%10;
				
				if(a-b == b-c) {
					count++;
				}
				
			}
			System.out.println(count);
		}
		
		sc.close();
		
	}

}
