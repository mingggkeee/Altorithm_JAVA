package 스택과큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2493 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Stack<int []> stack = new Stack<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int n=1; n<=N; n++) {
			int top = Integer.parseInt(st.nextToken()); // 현재 탑 높이
			while(!stack.empty()) {
				if(stack.peek()[1] >= top) {
					System.out.print(stack.peek()[0] + " ");
					break;
				}
				stack.pop();
			}
			if(stack.isEmpty()) {
				System.out.print("0 ");
			}
			stack.push(new int[] {n, top});
		}
	}

}
