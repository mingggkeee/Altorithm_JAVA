package DP;

import java.util.Scanner;

/**
 * BOJ_1912_S3_연속 합
 * @Author mingggkeee
 * @Date 2022. 4. 26.
 * @Category : DP
 */
public class BOJ_1912 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] arr = new int[N];
		int[] dp = new int[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		dp[0] = arr[0];
		int max = dp[0];
		
		for(int i=1; i<N; i++) {
			
			dp[i] = Math.max(arr[i], dp[i-1] + arr[i]);
			
			max = Math.max(max, dp[i]);
			
		}
		
		System.out.println(max);
		
		sc.close();
		
	}

}
