package 정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BOJ_11728_S5_배열 합치기
 * @author mingggkeee
 * 정렬
 */

public class BOJ_11728 {
	
	static int N,M;
	static int[] nums;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		nums = new int[N+M];
		
		int idx = 0;
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			nums[idx++] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			nums[idx++] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nums);
		
		for(int i=0; i<nums.length; i++) {
			System.out.print(nums[i]+" ");
		}
		
	}
	
}
