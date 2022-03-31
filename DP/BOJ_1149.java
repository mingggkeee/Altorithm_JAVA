package DP;

import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ_1149_S1_RGB거리
 * @author mingggkeee
 * DP
 */

public class BOJ_1149 {
	
	static int N;
	static int[][] cost;
	static int answer;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		cost = new int[N][3];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			// 빨, 초, 파
			cost[i][0] = Integer.parseInt(st.nextToken());
			cost[i][1] = Integer.parseInt(st.nextToken());
			cost[i][2] = Integer.parseInt(st.nextToken());
		}
		
		
		for(int i=1; i<N; i++) {
			cost[i][0] += Math.min(cost[i-1][1], cost[i-1][2]);
			cost[i][1] += Math.min(cost[i-1][0], cost[i-1][2]);
			cost[i][2] += Math.min(cost[i-1][0], cost[i-1][1]);
		}
		
		System.out.println(Math.min(Math.min(cost[N-1][0], cost[N-1][1]), cost[N-1][2]));
		
	}

}
