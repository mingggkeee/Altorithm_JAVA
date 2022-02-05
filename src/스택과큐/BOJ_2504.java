package 스택과큐;

import java.io.*;
import java.util.Stack;

public class BOJ_2504 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();

		Stack<Character> stack = new Stack<>();
		boolean isGood = true; 
		int sum = 0;
		int cnt = 1;
		for(int i=0; i<input.length(); i++) {
			char c = input.charAt(i);
			if(c == '(') {
				stack.push(c);
				cnt *= 2;
			}
			else if(c == '[') {
				stack.push(c);
				cnt *= 3;
			}
			else {
				if(c == ')') {
					if(stack.isEmpty() || stack.peek() != '(') {
						isGood=false;
						break;
					}
					if(input.charAt(i-1) =='(') {
						sum += cnt;
					}
					stack.pop();
					cnt /= 2;
				}else if(c==']') {
					if(stack.isEmpty() || stack.peek() != '[') {
						isGood=false;
						break;
					}
					if(input.charAt(i-1)=='[') {
						sum += cnt;
					}
					stack.pop();
					cnt /= 3;
				}
				else {
					isGood = false;
					break;
				}
			}
		}
		if(!isGood || !stack.isEmpty()) {
			System.out.println(0);
		}else {
			System.out.println(sum);
		}
	}
}
