package 재귀;

import java.util.Scanner;

/**
 * BOJ_10870_B2_피보나치 수 5
 * @author mingggkeee
 * 재귀
 */

public class BOJ_10870 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		System.out.println(fibo(N));
		
		sc.close();
	}
	
	static int fibo(int n) {
		
		if(n == 0) {
			return 0;
		}
		
		if(n ==1) {
			return 1;
		}
		
		return fibo(n-1) + fibo(n-2);
		
	}

}
