package 구현;

import java.util.Scanner;

/**
 * BOJ_2292_B2_벌집
 * @author mingggkeee
 * 구현
 */

public class BOJ_2292 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int count = 1;
		int start = 1;
		
		while(true) {
			if(start >= N) {
				break;
			}
			
			start+=6*count;
			count++;
			
		}
		
		System.out.println(count);
		sc.close();
	}

}
