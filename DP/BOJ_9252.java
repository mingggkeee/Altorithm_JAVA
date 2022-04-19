package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * BOJ_9252_G4_LCS 2
 * @Author mingggkeee
 * @Date 2022. 4. 19.
 * @Category : LCS, DP
 */

public class BOJ_9252 {

	static int[][] dp;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input1 = br.readLine();
		String input2 = br.readLine();
		
		System.out.println(LCS(input1, input2));
		LCSToString(input1, input1.length(), input2.length());
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
	
	static void LCSToString(String str, int i, int j) {
		
		Stack<Character> stack = new Stack<>();
		while(i>0 && j>0) {
			if(i == 0 || j == 0) {
				break;
			}
			
			if(dp[i][j] == dp[i-1][j]) {
				i--;
			} else if(dp[i][j] == dp[i][j-1]) {
				j--;
			} else {
				stack.push(str.charAt(i-1));
				i--;
				j--;
			}
			
		}
		
		while(!stack.isEmpty()) {
			System.out.print(stack.pop());
		}
		
	}
	
}
