package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ_2096_G4_내려가기
 * @Author mingggkeee
 * @Date 2022. 5. 11.
 * @Category : DP
 */

public class BOJ_2096 {

	static int[][] map, maxDp, minDp;
	static int N, min, max;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N+1][3];
		
		for(int r=1; r<=N; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int c=0; c<3; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		maxDp = new int[N+1][3];
		minDp = new int[N+1][3];
		
		for(int i=1; i<=N; i++) {
			maxDp[i][0] += Math.max(maxDp[i-1][0], maxDp[i-1][1]) + map[i][0];
			maxDp[i][1] += Math.max(Math.max(maxDp[i-1][0], maxDp[i-1][1]), maxDp[i-1][2]) + map[i][1];
			maxDp[i][2] += Math.max(maxDp[i-1][1], maxDp[i-1][2]) + map[i][2];
			
			minDp[i][0] += Math.min(minDp[i-1][0], minDp[i-1][1]) + map[i][0];
			minDp[i][1] += Math.min(Math.min(minDp[i-1][0], minDp[i-1][1]), minDp[i-1][2]) + map[i][1];
			minDp[i][2] += Math.min(minDp[i-1][1], minDp[i-1][2]) + map[i][2];
			
		}
		
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		
		for(int i=0; i<3; i++) {
			max = Math.max(max, maxDp[N][i]);
			min = Math.min(min, minDp[N][i]);
		}
		
		System.out.println(max+" "+min);
		
	}
	
}
