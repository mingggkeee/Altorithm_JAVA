package 스택과큐;

import java.util.Scanner;
import java.util.Stack;

/**
 * BOJ_17413_S3_단어 뒤집기 2
 * @author mingggkeee
 * 스택, 문자열
 */

public class BOJ_17413 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		String input = sc.nextLine();
		
		boolean isPossible = true;
		
		Stack<Character> stack = new Stack<>();
		
		for(int i=0; i<input.length(); i++) {
			
			char temp = input.charAt(i);
			
			if(temp == '<') {
				isPossible = false;
				
				while(!stack.isEmpty()) {
					sb.append(stack.pop());
				}
				
				sb.append(temp);
				continue;
			}
			
			if(temp == '>') {
				isPossible = true;
				sb.append(temp);
				continue;
			}
			
			if(!isPossible) {
				sb.append(temp);
			} 
			
			else {
				if(temp == ' ') {
					while(!stack.isEmpty()) {
						sb.append(stack.pop());
					}
					
					sb.append(temp);
				}
				
				else {
					stack.push(temp);
				}
				
				
				
			}
			
			
			
		}
		
		if(isPossible) {
			while(!stack.isEmpty()) {
				sb.append(stack.pop());
			}
		}
		
		System.out.println(sb.toString());
		
		sc.close();
	}

}
