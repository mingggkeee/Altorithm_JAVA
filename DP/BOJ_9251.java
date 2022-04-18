package DP;

import java.io.*;

/**
 * BOJ_9251_G5_LCS
 * @Author mingggkeee
 * @Date 2022. 4. 18.
 * @Category : LCS, DP
 */

public class BOJ_9251 {
	
	static int[][] dp;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input1 = br.readLine();
		String input2 = br.readLine();
		
		System.out.println(LCS(input1, input2));
	}
	
	static int LCS(String str1, String str2) {
		
		int num1 = str1.length();
		int num2 = str2.length();
		
		dp = new int[num1+1][num2+1];
		
		for(int i=1; i<=num1; i++) {
			for(int j=1; j<=num2; j++) {
				if(str1.charAt(i-1) == str2.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		
		
		return dp[num1][num2];
	}

}
