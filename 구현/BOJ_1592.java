package 구현;

import java.util.Scanner;

/**
 * BOJ_1592_B2_영식이와 친구들
 * @author mingggkeee
 * 구현
 */

public class BOJ_1592 {
	
	static int N,M,L;
	static int[] people;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int L = sc.nextInt();
		
		people = new int[N+1];
		int now = 1;
		people[now]++;
		
		int count = 0;
		
		while(true) {
			
			if(people[now] == M) {
				break;
			}
			
			// 홀수
			if(people[now] % 2 == 1) {
				now = now + L;
				if(now > N) {
					now -= N;
				}
			} 
			// 짝수
			else {
				now = now - L;
				if(now < 1) {
					now += N;
				}
				
			}
			
			people[now]++;
			
			count++;
		}
		
		System.out.println(count);
		
		sc.close();
	}

}
