package 스택과큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1158 {
	public static void main(String[] args) throws IOException {
		Queue<Integer> queue = new LinkedList<Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		for(int i=1; i<=N; i++) {
			queue.offer(i);
		}
		List<Integer> list = new ArrayList<Integer>();
		int cnt = 0;
		while(!queue.isEmpty()) {
			cnt++;
			if(cnt == K) {
				list.add(queue.poll());
				cnt = 0;
			} else {
				int temp = queue.poll();
				queue.offer(temp);
			}
			
		}
		String answer = list.toString();
		System.out.print("<");
		for(int i=1; i<answer.length()-1; i++) {
			System.out.print(answer.charAt(i));
		}
		System.out.print(">");
	}
}
