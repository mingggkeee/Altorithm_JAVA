package 정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ_1377_G2_버블 소트
 * @author mingggkeee
 * 정렬
 */

public class BOJ_1377 {
	
	static int N;
	static int[] nums;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		nums = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		
		boolean changed = false;
		for(int i=1; i<=N+1; i++) {
			changed = false;
			for(int j=1; j<=N-i; j++) {
				if(nums[j] > nums[j+1]) {
					changed = true;
					int temp = nums[j];
					nums[j] = nums[j+1];
					nums[j+1] = temp;
				}
			}
			if(changed==false) {
				System.out.println(i);
				break;
			}
		}
	}

}
