package 스택과큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_10799 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		Stack<Character> stack = new Stack<>();
		int sum = 0;

		for(int i = 0; i<input.length(); i++) {
			if(input.charAt(i) == '(') {
				stack.push('(');
				continue;
			} else if(input.charAt(i) == ')') {
				stack.pop();
				if(input.charAt(i-1) == '(') {
					sum += stack.size();
				} else {
					sum++;
				}
			}
		}
		System.out.println(sum);
		br.close();
	}
}
