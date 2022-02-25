package 구현;

import java.util.Scanner;

/**
 * BOJ_2567_B1_슈퍼마리오
 * @author mingggkeee
 * 구현
 */

public class BOJ_2851 {
	
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int[] score = new int[10];
		for(int i=0; i<10; i++) {
			score[i] = sc.nextInt();
		}
		
		int sum = 0;
		
		for(int i=0; i<10; i++) {
			if(Math.abs(100-sum) < Math.abs(100-(sum+score[i]))) {
				break;
			}
			
			sum += score[i];
			
		}
		
		System.out.println(sum);
		
		sc.close();
		
	}

}
