package 스택과큐;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2161 {
	public static void main(String[] args) throws IOException {
		Queue<Integer> queue = new LinkedList<Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		for(int i=1; i<=N; i++) {
			queue.offer(i);
		}
		
		while(!queue.isEmpty()) {
			int num = queue.poll();
			bw.write(num+" ");
			if(!queue.isEmpty()) {
				int num2 = queue.poll();
				queue.offer(num2);
			}
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
}
