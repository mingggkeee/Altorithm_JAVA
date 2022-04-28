package 알고리즘frame;

import java.util.Scanner;

public class ex1_페인트칠하기 {
	
	static long[] memo;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		memo = new long[N+1];
		
		memo[1] = 2;
		memo[2] = 3;
		
		System.out.println(topDown(N));
		System.out.println(bottomUp(N));
		
		
		sc.close();
		
	}
	
	private static long topDown(int n) {
		
		if(memo[n]> 0) {
			return memo[n];
		}
		return memo[n] = topDown(n-1) + topDown(n-2);
		
	}
	
	private static long bottomUp(int n) {
		
		long [] dp = new long[n+1];
		dp[1] = 2;
		dp[2] = 3;
		for(int i=3; i<=n; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		return dp[n];
		
	}

}
