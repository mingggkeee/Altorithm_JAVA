package 스택과큐;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class BOJ_1406 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String firstInput = br.readLine();
		
		Stack<Character> stack = new Stack<>();
		Stack<Character> stack2 = new Stack<>(); 
		
		for(int i=0; i<firstInput.length(); i++) {
			stack.push(firstInput.charAt(i));
		}
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			String input = br.readLine();
			if(input.charAt(0)=='P') {
				stack.push(input.charAt(2));
			} else if(input.equals("L") && !stack.isEmpty()) {
				stack2.push(stack.pop());
			} else if(input.equals("D") && !stack2.isEmpty()) {
				stack.push(stack2.pop());
			} else if(input.equals("B") && !stack.isEmpty()) {
				stack.pop();
			}
		}
		while(!stack.isEmpty()) {
			stack2.push(stack.pop());
		}
		while(!stack2.isEmpty()) {
			bw.write(stack2.pop());
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
}
