package 구현;

import java.util.Scanner;

/**
 * BOJ_2941_S5_크로아티아 알파벳
 * @author mingggkeee
 * 구현
 */

public class BOJ_2941 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String input = sc.nextLine();
		
		int count = 0;
		
		for(int i=0; i<input.length(); i++) {
			
			char temp = input.charAt(i);
			
			if(temp == 'c' && i+1<input.length()) {
				if(input.charAt(i+1) == '=' || input.charAt(i+1) == '-') {
					count++;
					i++;
					continue;
				}
			}
			
			if(temp=='d' && i+1<input.length()) {
				if(input.charAt(i+1) == '-') {
					count++;
					i++;
					continue;
				}
				
				if(input.charAt(i+1) == 'z' && i+2<input.length() && input.charAt(i+2) == '='){
					count++;
					i+=2;
					continue;
				}
				
			}
			
			if(temp=='l' && i+1<input.length() && input.charAt(i+1) == 'j') {
				count++;
				i++;
				continue;
			}
			
			if(temp=='n' && i+1<input.length() && input.charAt(i+1) == 'j') {
				count++;
				i++;
				continue;
			}
			
			if(temp=='s' && i+1<input.length() && input.charAt(i+1) == '=') {
				count++;
				i++;
				continue;
			}
			
			if(temp=='z' && i+1<input.length() && input.charAt(i+1) == '=') {
				count++;
				i++;
				continue;
			}
			
			count++;
			
			
		}
		
		System.out.println(count);
		
		sc.close();
		
	}

}
