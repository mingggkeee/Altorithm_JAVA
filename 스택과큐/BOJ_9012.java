package 스택과큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_9012 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			String input = br.readLine()+"\n";
			Stack<Character> stack = new Stack<>();
			String result = "YES";
			
			for(int i=0; i<input.length(); i++) {
				char c = input.charAt(i);
				
				if(c=='(') {
					stack.push(c);
				}
				
				else if(c==')') {
					if(stack.isEmpty())
						result = "NO";
					else
						stack.pop();
				} 
			}
			
			if(!stack.isEmpty()) {
				result = "NO";
			} 
			System.out.println(result);
		}
		
		br.close();
	}
}
