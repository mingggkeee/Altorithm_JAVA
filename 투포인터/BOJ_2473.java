package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BOJ_2473_G4_세 용액
 * @Author mingggkeee
 * @Date 2022. 4. 17.
 * @Category : 투포인터
 */

public class BOJ_2473 {
	
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
		
		Arrays.sort(nums);
		
		int ml=0, mr=0, mm=0;
		
		for(int i=0; i<N; i++) {
			int left = i+1;
			int right = N-1;
			
			while(left < right) {
				long sum = nums[i] + nums[left] + nums[right];
				
				if(min > Math.abs(sum)) {
					min = Math.abs(sum);
					ml = i;
					mm = left;
					mr = right;
				}
				
				if(sum > 0) {
					right--;
				}
				else {
					left++;
				}
			}
		}
		
		System.out.println(nums[ml] + " " + nums[mm]+ " " + nums[mr]);
		
	}
}
