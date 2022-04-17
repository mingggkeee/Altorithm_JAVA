package 투포인터;

import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ_2467_G5_용액
 * @Author mingggkeee
 * @Date 2022. 4. 17.
 * @Category : 투포인터
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
		
		int left = 0;
		int right = N-1;
		int ml=0, mr=0;
		
		while(left < right) {
			
			long sum = nums[left] + nums[right];
			if(min > Math.abs(sum)) {
				min = Math.abs(sum);
				ml = left;
				mr = right;
			}
			if(sum >= 0) {
				right--;
			} else {
				left++;
			}
			
		}
		
		System.out.println(nums[ml] + " " + nums[mr]);
		
	}
	
}
