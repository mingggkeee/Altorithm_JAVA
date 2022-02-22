package DFS와BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 * BOJ_13913_G4_숨바꼭질 4
 * @author mingggkeee
 * BFS
 */

public class BOJ_13913 {
	
	static int N,K;
	static boolean[] isVisited = new boolean[100001];
	static int time;
	static int[] parents = new int[100001];
	
	static class Move{
		int location;
		int time;
		
		public Move(int location, int time) {
			this.location = location;
			this.time = time;
		}
	}
	
	public static void bfs() {
		Queue<Move> queue = new LinkedList<Move>();
		
		queue.offer(new Move(N, 0));
		isVisited[N] = true;
		
		while(!queue.isEmpty()) {
			
			Move now = queue.poll();
			
			if(now.location==K) {
				System.out.println(now.time);
				return;
			}
			
			int next;
			
			next = now.location * 2;
			if(next <= 100000 && !isVisited[next]) {
				isVisited[next] = true;
				parents[now.location * 2] = now.location;
				queue.offer(new Move(next, now.time+1));
			}
			
			next = now.location - 1;
			if(next>=0 && !isVisited[next]) {
				isVisited[next] = true;
				parents[now.location - 1] = now.location;
				queue.offer(new Move(next, now.time+1));
			}
			
			next = now.location + 1;
			if(next <= 100000 && !isVisited[next]) {
				isVisited[next] = true;
				parents[now.location + 1] = now.location;
				queue.offer(new Move(next, now.time+1));
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		K = sc.nextInt();
		
		sc.close();
		
		if(N==K) {
			System.out.println(0);
			System.out.println(N);
			return;
		}
		
		bfs();
		
		Stack<Integer> stack = new Stack<>();
		int index = K;
		while(index != N) {
			stack.push(index);
			index = parents[index];
		}
		stack.push(index);
		
		while(!stack.isEmpty()) {
			System.out.print(stack.pop()+" ");
		}
			
		
	}

}
