package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ_2491_S3_수열
 * @author mingggkeee
 * 구현
 */

public class BOJ_2491 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());	// 수열의 길이
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int [] nums = new int[N];
		// 수열 입력
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		int plus = 1;
		int minus = 1;
		
		int answer = 1;
		
		// 증가할 때
		for(int i=0; i<N-1; i++) {
			if(nums[i] <= nums[i+1]) {
				plus++;
			}
			else {
				plus = 1;
			}
			answer = Math.max(answer, plus);
		}
		
		// 작아질 때
		for(int i=0; i<N-1; i++) {
			if(nums[i] >= nums[i+1]) {
				minus++;
			}
			else {
				minus = 1;
			}
			answer = Math.max(answer, minus);
		}
		
		System.out.println(answer);
		
	}
}

