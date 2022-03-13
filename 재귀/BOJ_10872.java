package 재귀;

import java.util.Scanner;

/**
 * BOJ_10872_B3_팩토리얼
 * @author mingggkeee
 * 재귀
 */

public class BOJ_10872 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		System.out.println(factorial(N));
		
		sc.close();
	}
	
	static int factorial(int n) {
		
		if(n<=1) {
			return 1;
		}
		
		return n*factorial(n-1);
	}

}
