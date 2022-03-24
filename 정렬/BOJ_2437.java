package 정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BOJ_2437_G3_저울
 * @author mingggkeee
 * 그리디, 정렬
 */

public class BOJ_2437 {

	static int N;
	static int[] nums;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		nums = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nums);
		
		int max = 0;
		for(int i=0; i<N; i++) {
			if(max + 1 >= nums[i]) {
				max += nums[i];
			}
			else {
				break;
			}
		}
		
		int answer = max + 1;
		
		System.out.println(answer);
		
	}
	
}
