package 스택과큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_4949 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			Stack<Character> stack = new Stack<>();
			String input = br.readLine();
			if(input.length()==1 && input.charAt(0)=='.') {
				break;
			}
			for(int i=0; i<input.length(); i++) {
				if(input.charAt(i) == '(' || input.charAt(i) == '[') {
					stack.push(input.charAt(i));
				} else if(!stack.isEmpty() && input.charAt(i) == ')' && stack.peek()=='(') {
					stack.pop();
				} else if(!stack.isEmpty() && input.charAt(i) == ']' && stack.peek()=='[') {
					stack.pop();
				} else if(input.charAt(i) == ')' || input.charAt(i) == ']'){
					stack.push(input.charAt(i));
				}
			}
			if(stack.isEmpty()) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
		}
			
	}
}
