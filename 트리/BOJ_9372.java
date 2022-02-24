package 트리;

import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ_9372_S3_상근이의 여행
 * @author mingggkeee
 * 트리, 그래프
 */

public class BOJ_9372 {
	
	static int T;
	static int N,M;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for(int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());	// 국가의 수
			M = Integer.parseInt(st.nextToken());	// 비행기의 종류
			
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				st.nextToken();
				st.nextToken();
			}
			
			System.out.println(N-1);
			
		}
		
	}

}
