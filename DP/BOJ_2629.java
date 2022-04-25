package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ_2629_G3_양팔저울
 * @Author mingggkeee
 * @Date 2022. 4. 25.
 * @Category : DP
 */

public class BOJ_2629 {

	static boolean[][] dp;
	static int[] weight;
	static int n;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		weight = new int[n];
		dp = new boolean[n+1][15001];	// 추 무게의 최대 총합은 15000까지
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			weight[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0, 0);
		
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<m; i++){
			int target = Integer.parseInt(st.nextToken());
			
			if(target > 15000) {
				System.out.print("N ");
			} else {
				if(dp[n][target]) {
					System.out.print("Y ");
				} else {
					System.out.print("N ");
				}
			}
		}
		
		
	}
	
	static void dfs(int cnt, int w) {
		if(dp[cnt][w]) {
			return;
		}
		dp[cnt][w] = true;
		
		if(cnt == n) {
			return;
		}
		
		dfs(cnt + 1, w + weight[cnt]);
		
		dfs(cnt + 1, w);
		
		dfs(cnt + 1, Math.abs(w - weight[cnt]));
	}
	
}
