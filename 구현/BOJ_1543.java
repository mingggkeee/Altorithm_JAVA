package 구현;

import java.util.Scanner;

/**
 * BOJ_1543_S4_문서 검색
 * @author mingggkeee
 * 구현
 */

public class BOJ_1543 {
	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		
		String compare = sc.nextLine();
		
		int cnt = 0;
		
		for(int i=0; i<input.length(); i++) {
			
			boolean check = true;
			
			for(int j=0; j<compare.length(); j++) {
				
				if(i+j >= input.length() || input.charAt(i+j) != compare.charAt(j)) {
					check = false;
					break;
				}
				
			}
			
			if(check) {
				cnt++;
				i += compare.length()-1;
			}
			
		}
		
		System.out.println(cnt);
		
		sc.close();
	}

}
