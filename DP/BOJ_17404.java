package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ_17404_G4_RGB거리 2
 * @Author mingggkeee
 * @Date 2022. 4. 19.
 * @Category : DP
 */
public class BOJ_17404 {

	static int N;
	static final int INF = 1000 * 1000;
	static int[][] cost, dp;
	static int answer = INF;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		cost = new int[N][3];
		dp = new int[N][3];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			// 빨, 초, 파
			cost[i][0] = Integer.parseInt(st.nextToken());
			cost[i][1] = Integer.parseInt(st.nextToken());
			cost[i][2] = Integer.parseInt(st.nextToken());
		}
		
		// Red, Green, Blue를 처음 칠하는 순서
		for(int k=0; k<3; k++) {
			
			for(int i=0; i<3; i++) {
				if(i==k) {
					dp[0][i] = cost[0][i];
				} else {
					dp[0][i] = INF;
				}
			}
			
			for(int i=1; i<N; i++) {
				dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + cost[i][0];
				dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + cost[i][1];
				dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + cost[i][2];
			}
			
			for(int i=0; i<3; i++) {
				if(i != k) {
					answer = Math.min(answer, dp[N-1][i]);
				}
			}
			
		}
	
		System.out.println(answer);
	}
	
}
