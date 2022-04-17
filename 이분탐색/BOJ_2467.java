package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ_2467_G5_용액
 * @Author mingggkeee
 * @Date 2022. 4. 17.
 * @Category : 이분탐색
 */

public class BOJ_2467 {

	static int N;
	static long[] nums;
	static long min = Long.MAX_VALUE;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		nums = new long[N];
		
		for(int i=0; i<N; i++) {
			nums[i] = Long.parseLong(st.nextToken());
		}
		
		int ml = 0;
		int mr = 0;
		
		for(int i=0; i<N-1; i++) {
			int left = i+1;
			int right = N-1;
			while(left<=right) {
				int mid = (left+right)/2;
				long sum = nums[i] + nums[mid];
				
				if(min > Math.abs(sum)) {
					min = Math.abs(sum);
					ml = i; mr = mid;
				}
				
				if(nums[mid] >= -nums[i]) {
					right = mid-1;
				}
				else {
					left = mid+1;
				}
			}
		}
		
		System.out.println(nums[ml]+" "+nums[mr]);
		
	}
	
}
