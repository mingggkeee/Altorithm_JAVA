package 이분탐색;

import java.util.Scanner;

/**
 * BOJ_1654_S3_랜선 자르기
 * @author mingggkeee
 * 이분 탐색
 */

public class BOJ_1654 {
 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
 
		int K = sc.nextInt();
		int N = sc.nextInt();
 
		int[] nums = new int[K];
		
		long max = 0;
		
		for (int i = 0; i < K; i++) {
			nums[i] = sc.nextInt();
			if(max < nums[i]) {
				max = nums[i];
			}
		}
 
		// 반드시 max에서 +1 값이어야 한다.
		max++; 
 
		long min = 0; // 탐색 길이 최솟값
		long mid = 0; 
 
		while (min < max) { 
			
			// 범위 내에서 중간 길이를 구한다.
			mid = (max + min) / 2;	
 
			long count = 0;
			
			// 구해진 중간 길이로 잘라서 총 몇 개가 만들어지는지를 구한다.
 
			for (int i = 0; i < nums.length; i++) {
				count += (nums[i] / mid);
			}
			
			/*
			 *  [upper bound 형식]
			 *  
			 *  mid길이로 잘랐을 때의 개수가 만들고자 하는 랜선의 개수보다 작다면
			 *  자르고자 하는 길이를 줄이기 위해 최대 길이를 줄인다.
			 *  그 외에는 자르고자 하는 길이를 늘려야 하므로 최소 길이를 늘린다.
			 */
			if(count < N) {
				max = mid;
			}
			else {
				min = mid + 1;
			}
			
 
		}
		
		// UpperBound로 얻어진 값(min)에 -1이 최대 길이가 된다.
		System.out.println(min - 1);
		
		sc.close();
	}
}