package 스택과큐;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_17298 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] nums = new int[N];
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		Stack<Integer> stack = new Stack<>();
		for(int i=0; i<N; i++) {
			while(!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
				nums[stack.pop()] = nums[i];
			}
			stack.push(i);
			
		}
		
		while(!stack.isEmpty()) {
			nums[stack.pop()] = -1;
		}
		
		for(int i= 0; i<N;i ++) {
			bw.write(nums[i] + " ");
		}
		br.close();
		bw.flush();
		bw.close();

	}

}
