package DP;

import java.util.Scanner;

/**
 * BOJ_17202_B1_핸드폰 번호 궁합
 * @author mingggkeee
 * DP
 */

public class BOJ_17202 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String tel1 = sc.nextLine();
		String tel2 = sc.nextLine();
		
		String mix = "";
		
		for(int i=0; i<8; i++) {
			mix += tel1.charAt(i);
			mix += tel2.charAt(i);
		}
		
		
		
		while(true) {
			
			String temp = "";
			
			for(int i=0; i<mix.length()-1; i++) {
				int a = (mix.charAt(i)-'0' + mix.charAt(i+1)-'0')%10;
				temp += Integer.toString(a);
			}
			
			
			mix = temp;
			if(temp.length()==2) {
				break;
			}
			
		}
		
		System.out.println(mix);
		
		sc.close();
	}

}
