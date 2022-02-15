package 투포인터;

import java.util.Scanner;

/**
 * BOJ_2559_S3_수열
 * @author mingggkeee
 * 투포인터, 슬라이딩
 */

public class BOJ_2559 {
	
	static int N,K;
	static int [] nums;
	static int answer = Integer.MIN_VALUE;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		nums = new int[N];
		
		for(int i=0; i<N; i++) {
			nums[i] = sc.nextInt();
		}
		
		int idx = K;
		
		for(int i=0; i<N; i++) {
			if(idx>N) {
				break;
			}
			int temp = 0;
			for(int k=i; k<idx; k++) {
				temp += nums[k];
			}
			
			answer = Math.max(temp, answer);
			
			idx++;
		}
		
		System.out.println(answer);
		sc.close();
	}

}
