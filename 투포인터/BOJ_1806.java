package 투포인터;

import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ_1806_G4_부분 합
 * @Author mingggkeee
 * @Date 2022. 4. 16.
 * @Category : 투포인터
 */
public class BOJ_1806 {

	static int N, S, sum;
	static int answer = Integer.MAX_VALUE;
	static int[] nums;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		nums = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		sum = 0;
		
		sliding();
		
		if(answer == Integer.MAX_VALUE) {
			answer = 0;
		}
		
		System.out.println(answer);
		
	}
	
	static void sliding() {
		
		int start = 0;
		int end = 0;
		
		while(start<=N && end<=N) {
			if(sum >= S && answer > end - start) {
				answer = end - start;
			}
			
			if(sum < S) {
				sum += nums[end++];
			} else {
				sum -= nums[start++];
			}
		}
		
	}
	
}
