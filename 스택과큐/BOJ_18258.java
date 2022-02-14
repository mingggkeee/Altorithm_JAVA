package 스택과큐;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_18258 {
	public static void main(String[] args) throws IOException {
		Deque<Integer> queue = new LinkedList<Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			if(command.equals("push")) {
				int num = Integer.parseInt(st.nextToken());
				queue.offer(num);
			}else if(command.equals("pop")) {
				if(queue.isEmpty()) {
					bw.write(-1+"\n");
				} else {
					bw.write(queue.poll() + "\n");
				}
			}else if(command.equals("size")) {
				bw.write(queue.size()+"\n");
			}else if(command.equals("empty")) {
				if(queue.isEmpty()) {
					bw.write(1+"\n");
				} else {
					bw.write(0+"\n");
				}
			} else if(command.equals("front")) {
				if(queue.isEmpty()) {
					bw.write(-1+"\n");
				} else {
					bw.write(queue.peek()+"\n");
				}
			} else if(command.equals("back")) {
				if(queue.isEmpty()) {
					bw.write(-1+"\n");
				} else {
					bw.write(queue.peekLast()+"\n");
				}
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
