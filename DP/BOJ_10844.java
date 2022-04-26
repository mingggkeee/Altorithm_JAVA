package DP;

import java.util.Scanner;

/**
 * BOJ_10844_S1_쉬운 계단 수
 * @Author mingggkeee
 * @Date 2022. 4. 26.
 * @Category : dp
 */
public class BOJ_10844 {

	static int N;
	static long[][] dp;
	static final long mod = 1000000000;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		dp = new long[N+1][10];
		
		for(int i=1; i<10; i++) {
			dp[1][i] = 1;
		}
		
		for(int i=2; i<=N; i++) {
			
			for(int j=0; j<10; j++) {
				
				if(j == 0) {
					dp[i][0] = dp[i-1][1] % mod;
				}
				
				else if(j == 9) {
					dp[i][9] = dp[i-1][8] % mod;
				}
				
				else {
					dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % mod;
				}
				
			}
			
		}
		
		long result = 0;
		
		for(int i=0; i<10; i++) {
			result += dp[N][i];
		}
		
		System.out.println(result % mod);
		
		sc.close();
	}
	
}
