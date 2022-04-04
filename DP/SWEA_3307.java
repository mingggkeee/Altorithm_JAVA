package DP;

import java.io.*;
import java.util.StringTokenizer;

/**
 * SWEA_3307_D3_최장 증가 부분 수열
 * @author mingggkeee
 *
 */

public class SWEA_3307 {
	
	static int T, N, max;
	static int[] nums;
	static int[] dp;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			max = Integer.MIN_VALUE;
			N = Integer.parseInt(br.readLine());
			nums = new int[N];
			dp = new int[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i=0; i<N; i++) {
				dp[i] = 1;
				
				for(int j=0; j<i; j++) {
					
					if(nums[j] < nums[i] && dp[i] < dp[j] + 1) {
						dp[i] = dp[j] + 1;
					}
					
				}
				
				if(max < dp[i]) {
					max = dp[i];
				}
			}
			
			
			sb.append("#"+t+" "+max+"\n");
		}
		
		System.out.println(sb.toString());
	}

}
