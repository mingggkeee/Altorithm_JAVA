package DP;

import java.util.Scanner;

/**
 * BOJ_12865_G5_평범한 배낭
 * @author mingggkeee
 * DP, 0/1배낭문제
 */

public class BOJ_12865 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int W = sc.nextInt();
		
		int[] weights = new int[N+1];
		int[] profits = new int[N+1];
		
		int[][] dp = new int[N+1][W+1];
		
		for(int i=1; i<=N; i++) {
			weights[i] = sc.nextInt();
			profits[i] = sc.nextInt();
		}
		
		int itemWeight = 0, itemBenefit= 0;
		
		for(int item=1; item<=N; item++) {
			itemWeight = weights[item];
			itemBenefit = profits[item];
			
			for(int weight=1; weight<=W; weight++) {
				
				if(itemWeight <= weight) {
					dp[item][weight] = Math.max(dp[item-1][weight], itemBenefit+dp[item-1][weight-itemWeight]);
				} else {
					dp[item][weight] = dp[item-1][weight];
				}
				
			}
			
		}
		
		System.out.println(dp[N][W]);
		sc.close();
		
	}

}
