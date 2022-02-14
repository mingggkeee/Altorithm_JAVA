package 스택과큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class BOJ_1874 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[] nums = new int[T+1];
		int index = 1;
		Stack<Integer> stack = new Stack<>();
		ArrayList<String> answer = new ArrayList<>();
		for(int t=1; t<=T; t++) {
			nums[t] = Integer.parseInt(br.readLine());
			}
		
		for(int i=1; i<=T; i++) {
			stack.push(i);
			answer.add("+");
			while(!stack.empty() && stack.peek() == nums[index]) {
				answer.add("-");
				stack.pop();
				index++;
			}
		}
		
		if(stack.empty()) {
			for(String ans : answer) {
				System.out.println(ans);
			}
		} else {
			System.out.println("NO");
		}
		
		
	}
}
