package DP;

import java.util.Scanner;

/**
 * BOJ_1463_S3_1로 만들기
 * @author mingggkeee
 * DP
 */

public class BOJ_1463 {
	
	static int N;
	static int[] dp;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		dp = new int[N+1];
		
		dp[0] = 0;
		dp[1] = 0;
		
		for(int i=2; i<=N; i++) {
			
			int min = dp[i-1] + 1;
			if(i%3==0 && dp[i/3] + 1 < min) {
				min = dp[i/3] + 1;
			}
			if(i%2==0 && dp[i/2] + 1 < min) {
				min = dp[i/2] + 1;
			}
			
			dp[i] = min;
			
		}
		
		System.out.println(dp[N]);
		
		sc.close();
	}

}
