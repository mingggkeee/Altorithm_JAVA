package DP;

import java.util.Scanner;

/**
 * BOJ_11053_S2_가장 긴 증가하는 부분 수열
 * @author mingggkeee
 * LIS, DP
 */

public class BOJ_11053 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();	// 수열의 크기
		int[] arr = new int[N];	// 수열의 원소 저장
		int[] LIS = new int[N];	// 자신을 끝으로 하는 LIS길이
		
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		int max = 0;	// LIS 최장길이 저장
		
		// 모든 원소에 대해 자신을 끝으로 하는 LIS 길이 계산
		for(int i=0; i<N; i++) {
			LIS[i] = 1;	// 나 혼자 LIS일 때 1이니까 1로 초기화
			
			// 첫 원소부터 i원소 직전까지 비교
			for(int j=0; j<i; j++) {
				// 증가수열의 모습 확인
				if(arr[j] < arr[i] && LIS[i] < LIS[j]+1) {
					LIS[i] = LIS[j]+1;
					
				}
			}
			if(max<LIS[i]) {
				max = LIS[i];
			}
			
		}
		
		System.out.println(max);
		
		sc.close();
		
	}
	
}
