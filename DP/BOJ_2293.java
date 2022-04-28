package DP;

import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * BOJ_2293_G5_동전 1
 * @Author mingggkeee
 * @Date 2022. 4. 28.
 * @Category : dp
 */

public class BOJ_2293 {

	static int N, K;
	static int[] coin, dp;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		coin = new int[N+1];
		dp = new int[K+1];
		
		dp[0] = 1;
		
		for(int i=1; i<=N; i++) {
			coin[i] = Integer.parseInt(br.readLine());
			
			for(int j=coin[i]; j<=K; j++) {
				dp[j] += dp[j - coin[i]];
			}
			
		}
		
		System.out.println(dp[K]);
		
	}
	
}
