package 구현;

import java.util.Scanner;

/**
 * BOJ_13458_G2_시험 감독
 * @author mingggkeee
 * 구현
 */

public class BOJ_13458 {
	
	static int N;
	static int[] exam;
	static int B,C;
	static long answer;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		exam = new int[N];
		
		for(int i=0; i<N; i++) {
			exam[i] = sc.nextInt();
		}
		
		B = sc.nextInt();
		C = sc.nextInt();
		
		for(int i=0; i<N; i++) {
			answer++;
			exam[i] = exam[i] - B;
		}
		
		for(int i=0; i<N; i++) {
			if(exam[i] > 0) {
				if(exam[i] % C == 0) {
					answer += exam[i] / C;
				} else {
					answer += (exam[i] / C) + 1;
				}
			}
		}
		
		System.out.println(answer);
		
		sc.close();
		
	}

}
