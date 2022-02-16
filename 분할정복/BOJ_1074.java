package 분할정복;

import java.util.Scanner;

/**
 * BOJ_1074_S1_Z
 * @author mingggkeee
 * 재귀, 분할정복
 */

public class BOJ_1074 {
	
	static int n, R, C;
	static int N;
	static int count;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();	// 2의 N승 * 2의N승
		
		N = (int)Math.pow(2, n);	// 한변의 사이즈
		
		R = sc.nextInt();	// 행
		C = sc.nextInt();	// 열
		
		search(N, R, C);
		
		System.out.println(count);
		
		
		sc.close();
	}
	
	public static void search(int N, int R, int C) {
		if(N==1) {
			return;
		}
		
		if(R < N/2 && C < N/2) {
			search(N/2, R, C);
		}
		else if(R < N/2 && C >= N/2) {
			count += N * N / 4;
			search(N/2, R, C - N/2);
		}
		else if(R >= N/2 && C < N/2) {
			count += (N * N / 4) * 2;
			search(N/2, R - N/2, C);
		}
		else {
			count += (N * N / 4) * 3;
			search(N/2, R - N/2, C - N/2);
		}
	}

	
}
