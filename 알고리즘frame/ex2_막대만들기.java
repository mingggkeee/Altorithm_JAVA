package 알고리즘frame;

public class ex2_막대만들기 {
	
	public static void main(String[] args) {
		
		memo = new long[7];
		memo[1] = 2;
		memo[2] = 5;
		
		System.out.println(topDown(6));
		System.out.println(bottomUp(6));
		System.out.println(bottomUp2(6));
		
	}
	
	static long[] memo;
	
	private static long topDown(int n) {
		
		if(memo[n] > 0) {
			return memo[n];
		}
		
		return memo[n] = topDown(n-1) * 2 + topDown(n-2);
	}
	
	private static long bottomUp(int n) {
		long[] dp = new long[n+1];
		dp[1] = 2;
		dp[2] = 5;
		
		for(int i=3; i<=n; i++) {
			dp[i] = 2*dp[i-1] + dp[i-2];
		}
		
		return dp[n];
	}
	
	// n cm을 만들기 위한 B, Y, R의 가지수는?
	private static long bottomUp2(int n) {
		int B=0, Y=1, R=2;
		long [][] dp = new long[n+1][3];
		dp[1][B] = 1;
		dp[1][Y] = 1;
		dp[1][R] = 0;
		
		dp[2][B] = dp[1][B] + dp[1][Y]+dp[1][R];
		dp[2][Y] = dp[1][B] + dp[1][Y]+dp[1][R];
		dp[2][R] = 1;	// 초기값인 상태
		
		for(int i=3; i<=n; i++) {
			dp[i][B] = dp[i-1][B] + dp[i-1][Y] + dp[i-1][R];
			dp[i][Y] = dp[i-1][B] + dp[i-1][Y] + dp[i-1][R];
			dp[i][R] = dp[i-2][B] + dp[i-2][Y] + dp[i-2][R];
			             
		}
		
		return dp[n][B] + dp[n][Y] + dp[n][R];
	}

}
