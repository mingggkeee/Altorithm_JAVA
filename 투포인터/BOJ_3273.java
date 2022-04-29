package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BOJ_3273_S3_두 수의 합
 * @Author mingggkeee
 * @Date 2022. 4. 29.
 * @Category : 투포인터
 */
public class BOJ_3273 {

	static int n;
	static int[] nums;
	static int target, cnt;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		nums = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		target = Integer.parseInt(br.readLine());
		Arrays.sort(nums);
		
		int lc = 0;
		int rc = n-1;
		int sum = nums[lc] + nums[rc];
		
		while(lc<rc) {
			if(sum == target) {
				cnt++;
			}
			
			if(sum < target) {
				lc++;
				sum = nums[lc] + nums[rc];
			} else {
				rc--;
				sum = nums[lc] + nums[rc];
			}
			
		}
		
		System.out.println(cnt);
		
		
	}
	
}
