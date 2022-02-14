package 스택과큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_11286 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
			if(Math.abs(o1) == Math.abs(o2)) {
				return o1 < o2 ? -1 : 1;
			}
			return Math.abs(o1) - Math.abs(o2);
		});
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			int inputNum = Integer.parseInt(br.readLine());
			if(inputNum != 0){
				queue.add(inputNum);
			} else if(queue.isEmpty()) {
				System.out.println(0);
			} else {
				System.out.println(queue.poll());
			}
		}
	}
}
