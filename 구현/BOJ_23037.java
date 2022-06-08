package 구현;

import java.util.Scanner;

public class BOJ_23037 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String input = sc.next();
		
		int sum = 0;
		
		for(int i=0; i<input.length(); i++) {
			int num = input.charAt(i) - '0';
			sum += Math.pow(num, 5);
		}
		
		System.out.println(sum);
		
		sc.close();
	}
	
}
