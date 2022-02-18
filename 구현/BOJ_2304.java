package 구현;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * BOJ_2304_S2_창고 다각형
 * @author mingggkeee
 * 구현
 */

public class BOJ_2304 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();	// 기둥의 개수
		int [][]arr = new int[N][2];
		
		for(int i=0; i<N; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0]) {
					return o1[1] - o2[1];
				}
				return o1[0] - o2[0];
			}
		});
		
		int answer = 0;
		int maxHeight = Integer.MIN_VALUE;
		for(int i=0; i<N; i++) {
			maxHeight = Math.max(maxHeight, arr[i][1]);
		}
		
		int leftNum = 0;
		int rightNum = 0;
		
		// 왼쪽부분
		int compare = arr[0][1];
		int startX = arr[0][0];
		for(int i=0; i<N; i++) {
			if(arr[i][1] == maxHeight) {
				answer += compare * (arr[i][0] - startX);
				leftNum = arr[i][0];
				break;
			}
			
			if(compare < arr[i][1]) {
				answer += (arr[i][0] - startX) * compare;
				startX = arr[i][0];
				compare = arr[i][1];
				
			}
		}
		
		// 오른쪽 부분
		compare = arr[N-1][1];
		startX = arr[N-1][0];
		for(int i=N-1; i>=0; i--) {
			if(arr[i][1] == maxHeight) {
				answer += (startX - arr[i][0]) * compare;
				rightNum = arr[i][0];
				break;
			}
			
			if(compare < arr[i][1]) {
				answer += (startX - arr[i][0]) * compare;
				startX = arr[i][0];
				compare = arr[i][1];
				
			}
		}
		
		answer += maxHeight * (rightNum - leftNum + 1);
		
		System.out.println(answer);
		
		sc.close();
		
	}

}
