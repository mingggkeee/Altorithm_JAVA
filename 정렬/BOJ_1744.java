package 정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * BOJ_1744_G4_수 묶기
 * @author mingggkeee
 * 정렬, 그리디
 */

public class BOJ_1744 {
	
	static int[] nums;
	static int N;
	static int answer;
	static int count;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		nums = new int[N];
		
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(br.readLine());
			if(nums[i] <= 0) {
				count++;
			}
		}
		
		Arrays.sort(nums);
		
		for(int i=1; i<count; i+=2) {
			answer += nums[i-1] * nums[i];
		}
		
		if(count %2 == 1) {
			answer += nums[count-1];
		}
		
		if((N-count) % 2 == 1) {
			answer += nums[count];
		}
		
		for(int i=N-1; i>count; i-=2) {
			int num1 = nums[i];
			int num2 = nums[i-1];
			
			if(num1 * num2 > num1+num2) {
				answer += num1*num2;
			} else {
				answer += num1+num2;
			}
		}
		
		System.out.println(answer);

		
		br.close();
	}
}
