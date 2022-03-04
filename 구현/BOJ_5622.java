package 구현;

import java.util.Scanner;

/**
 * BOJ_5622_B2_다이얼
 * @author mingggkeee
 * 구현, 문자열
 */

public class BOJ_5622 {
	
	static int answer;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String input = sc.nextLine();
		
		answer += input.length();
		
		for(int i=0; i<input.length(); i++) {
			
			int num = input.charAt(i)-'A';
			
			if(num<=2) {
				answer+=2;
			} else if(num<=5) {
				answer+=3;
			} else if(num<=8) {
				answer+=4;
			} else if(num<=11) {
				answer+=5;
			} else if(num<=14) {
				answer+=6;
			} else if(num<=18){
				answer+=7;
			} else if(num<=21) {
				answer+=8;
			} else {
				answer+=9;
			}
			
		}
		
		System.out.println(answer);
			
		
		
		sc.close();
	}

}
