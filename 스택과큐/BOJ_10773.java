package 스택과큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_10773 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		for(int k=0; k<K; k++) {
			int num = Integer.parseInt(br.readLine());
			if(num==0) {
				stack.pop();
			}
			else {
				stack.push(num);
			}
		}
		
		int sum = 0;
		while(!stack.isEmpty()) {
			sum+=stack.pop();
		}
		System.out.println(sum);
		br.close();
	}

}
