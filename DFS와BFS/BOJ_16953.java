package DFS와BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_16953 {
	
	static long A, B;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		A = sc.nextLong();
		B = sc.nextLong();
		
		System.out.println(bfs(A));
		
		sc.close();
	}
	
	static int bfs(long start) {
		Queue<Num> queue = new LinkedList<Num>();
		queue.offer(new Num(start,1));
		
		while(!queue.isEmpty()) {
			Num now = queue.poll();
			
			if(now.num == B) {
				return now.time;
			}
			
			long temp = now.num * 10 + 1;
			if(temp <= B)
				queue.offer(new Num(temp,now.time+1));
			
			temp = now.num * 2;
			if(temp <= B)
				queue.offer(new Num(temp,now.time+1));
		}
		
		return -1;
	}
	
	static class Num{
		long num;
		int time;
		
		public Num(long num, int time) {
			this.num = num;
			this.time = time;
		}
	}
	
}
