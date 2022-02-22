package DFS와BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * BOJ_13549_G5_숨바꼭질 3
 * @author mingggkeee
 * BFS
 */

public class BOJ_13549 {
	
	static int N,K;
	static boolean[] isVisited = new boolean[100001];
	static int answer = Integer.MAX_VALUE;
	
	static class Move{
		int location;
		int time;
		
		public Move(int location, int time) {
			this.location = location;
			this.time = time;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		K = sc.nextInt();
		
		sc.close();
		
		if(N==K) {
			System.out.println(0);
			return;
		}
		
		bfs();
		System.out.println(answer);
			
	}
	
	public static void bfs() {
		Queue<Move> queue = new LinkedList<Move>();
		
		queue.offer(new Move(N, 0));
		isVisited[N] = true;
		
		while(!queue.isEmpty()) {
			Move now = queue.poll();
			
			if(now.location==K) {
				answer = Math.min(answer, now.time);
			}
			
			int next;
			
			next = now.location * 2;
			if(next <= 100000 && !isVisited[next]) {
				isVisited[next] = true;
				queue.offer(new Move(next, now.time));
			}
			
			next = now.location - 1;
			if(next>=0 && !isVisited[next]) {
				isVisited[next] = true;
				queue.offer(new Move(next, now.time+1));
			}
			
			next = now.location + 1;
			if(next <= 100000 && !isVisited[next]) {
				isVisited[next] = true;
				queue.offer(new Move(next, now.time+1));
			}
			
		}
		
	}

}
