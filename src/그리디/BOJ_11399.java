package 그리디;

import java.util.Arrays;
import java.util.Scanner;

/**
 * BOJ_11399_S3_ATM
 * @author mingggkeee
 * 그리디 알고리즘, 정렬
 */

public class BOJ_11399 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] minutes = new int[N];
		for(int i=0; i<N; i++) {
			minutes[i] = sc.nextInt();
		}
		Arrays.sort(minutes);
		
		int sum = 0;
		
		/*
		for(int i=N-1; i>=0; i--) {
			int stack = 0;
			for(int j=i; j>=0; j--) {
				stack += minutes[j];
			}
			sum += stack;
		}
		*/
		
		int temp = 0;
		for(int i=0; i<N; i++) {
			temp += minutes[i];
			sum += temp;
		}
		
		System.out.println(sum);
		sc.close();

	}

}
