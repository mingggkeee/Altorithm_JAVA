package 스택과큐;
import java.util.Scanner;
import java.util.Stack;

/**
 * BOJ_9935_G4_문자열 폭발
 * @author mingggkeee
 * 스택, 문자열
 */

public class BOJ_9935 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String input = sc.nextLine();
		String bomb = sc.nextLine();
		Stack<Character> stack = new Stack<>();
		
		for(int i=0; i<input.length(); i++) {
			
			char c = input.charAt(i);
			stack.push(c);
			
			if(stack.size()>=bomb.length()) {
				boolean check = true;
				for(int j=0; j<bomb.length(); j++) {
					char c1 = stack.get(stack.size()-bomb.length()+j);
					char c2 = bomb.charAt(j);
					if(c1!=c2) {
						check = false;
						break;
					}
				}
				
				if(check) {
					for(int j=0; j<bomb.length(); j++) {
						stack.pop();
					}
				}
			}
			
		}
		
		if(stack.size()==0) {
			System.out.println("FRULA");
		} else {
			StringBuilder sb = new StringBuilder();
			for(char c : stack) {
				sb.append(c);
			}
			System.out.println(sb.toString());
		}
		
		sc.close();
	}
	
	

}
