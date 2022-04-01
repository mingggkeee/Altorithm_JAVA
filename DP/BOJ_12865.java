package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ_12865_G5_평범한 배낭
 * @author mingggkeee
 * DP, 0/1배낭문제
 */

public class BOJ_12865 {
	
	static int N, K;
	static int[] W, V;
	static int[][] dp;
	static int answer;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		// 무게, 밸류
		W = new int[N+1];
		V = new int[N+1];
		
		dp = new int[N+1][K+1];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			W[i] = Integer.parseInt(st.nextToken());
			V[i] = Integer.parseInt(st.nextToken());
		}
		
		knapsack();
		
		System.out.println(answer);
		
		
	}
	
	static void knapsack() {
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=K; j++) {
				if(W[i] > j) {
					dp[i][j] = dp[i-1][j];
				}
				else {
					dp[i][j] = Math.max(dp[i-1][j - W[i]] + V[i], dp[i-1][j]);
				}
			}
		}
		
		answer = dp[N][K];
		
	}
	


}
