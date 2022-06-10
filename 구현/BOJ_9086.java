package 구현;

import java.util.Scanner;

public class BOJ_9086 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for(int i=0; i<t; i++) {
			String input = sc.next();
			System.out.print(input.charAt(0));
			System.out.println(input.charAt(input.length()-1));
		}
		
		sc.close();
	}
	
}
