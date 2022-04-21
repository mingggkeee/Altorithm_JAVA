package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ_11659_S3_구간 합 구하기 4
 * @Author mingggkeee
 * @Date 2022. 4. 21.
 * @Category : 누적합
 */
public class BOJ_11659 {

	static int N, M;
	static int[] nums;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		nums = new int[N+1];
		nums[0] = 0;
		for(int i=1; i<=N; i++) {
			nums[i] = nums[i-1] + Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			System.out.println(nums[n2] - nums[n1-1]);
		}
	}
	
}
