package DP;

import java.util.Scanner;

/**
 * BOJ_11727_S3_2*n 타일링 2
 * @Author mingggkeee
 * @Date 2022. 4. 20.
 * @Category : DP
 */

public class BOJ_11727 {

	static int n;
	static final int DIV = 10007;
	static int[] dp;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		dp = new int[n+2];
		dp[1] = 1;
		dp[2] = 3;
		
		for(int i=3; i<=n; i++) {
			dp[i] = ((dp[i-1]%DIV) + (2*(dp[i-2]%DIV))%DIV)%DIV;
		}
		
		System.out.println(dp[n]);
		
		sc.close();
	}
	
}
