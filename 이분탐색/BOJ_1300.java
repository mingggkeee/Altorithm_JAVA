package 이분탐색;

import java.io.InputStreamReader;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * BOJ_1300_G2_K번째 수
 * @Author mingggkeee
 * @Date 2022. 4. 22.
 * @Category : 이분탐색
 */

public class BOJ_1300 {

	static int N;
	static int k;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		
		long start = 1;
		long end = k;
		
		while(start < end) {
			
			long mid = (start+end)/2;
			long count = 0;
			
			for(int i=1; i<=N; i++) {
				count += Math.min(mid / i, N);
			}
			
			if(k <= count) {
				end = mid;
			} else {
				start = mid +1;
			}
			
		}
		
		System.out.println(start);
	}
	
}
