package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BOJ_15553_G5_난로
 * @Author mingggkeee
 * @Date 2022. 6. 24.
 * @Category : 그리디, 정렬
 */

public class BOJ_15553 {

	static int N, K;
	static int[] interval;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		interval = new int[N-1];
		
		int start = -1;
		K--;	// 무조건 처음에 1개쓴다
		
		for(int i=0; i<N; i++) {
			int arrive = Integer.parseInt(br.readLine());
			
			if(start == -1) {
				start = arrive;
				continue;
			}
			
			interval[i-1] = arrive - start;
			start = arrive;
		}
		
		Arrays.sort(interval);
		
		int answer = 1;
		
		for(int i=N-2; i>=0; i--) {
			if(K > 0) {
				answer += 1;
				K--;
			}
			else {
				answer += interval[i];
			}
		}
		
		System.out.println(answer);
	}
	
}
