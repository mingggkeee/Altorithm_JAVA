package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ_11066_G3_파일 합치기
 * @Author mingggkeee
 * @Date 2022. 4. 27.
 * @Category : dp
 */
public class BOJ_11066 {
	
	static int T, K;
	static int[] files, sum;
	static int[][] dp;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			
			K = Integer.parseInt(br.readLine());
			
			files = new int[K+1];
			sum = new int[K+1];
			dp = new int[K+1][K+1];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=1; i<=K; i++) {
				files[i] = Integer.parseInt(st.nextToken());
				sum[i] = sum[i-1] + files[i];
			}
			
            for (int n = 1; n <= K; n++) {
                for (int from = 1; from + n <= K; from++) {
                    int to = from + n;
                    dp[from][to] = Integer.MAX_VALUE;
                    for (int divide = from; divide < to; divide++) {
                        dp[from][to] = Math.min(dp[from][to], dp[from][divide] + dp[divide + 1][to] + sum[to] - sum[from - 1]);
                    }
                }
            }
			
			System.out.println(dp[1][K]);
		}
		
	}

}
