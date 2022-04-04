package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ_12015_G2_가장 긴 증가하는 부분 수열 2
 * @author mingggkeee
 * 이분탐색
 */

public class BOJ_12015 {

	static int[] memo;
	static int INF = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		memo = new int[N+1];
		int len = 0;
		int idx = 0;
		for(int i=0; i<N; i++) {
			if(nums[i] > memo[len]) {
				len += 1;
				memo[len] = nums[i];
			} else {
				idx = binarySearch(0, len, nums[i]);
				memo[idx] = nums[i];
			}
		}
		
		System.out.println(len);
	}
	
	static int binarySearch(int left, int right, int target) {
		
		int mid = 0;
		while(left<right) {
			mid = (left+right)/2;
			if(memo[mid] < target) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		
		return right;
		
	}
	
}
