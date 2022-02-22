package DFS와BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * BOJ_12851_G5_숨바꼭질 2
 * @author mingggkeee
 * BFS
 */

public class BOJ_12851 {
	
	static int N,K;
	static boolean[] isVisited;
	static int count = 0;
	static int time = 0;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();	// 수빈이의 위치
		K = sc.nextInt();	// 동생의 위치
		isVisited = new boolean[100001];
		
		if(N==K) {
			System.out.println(0);
			System.out.println(1);
		} else {
			bfs();
			System.out.println(time);
			System.out.println(count);
		}
		
		sc.close();
		
	}
	
	public static void bfs() {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(N);
		
		while(!queue.isEmpty()) {
			
			time++;
			int size = queue.size();
			
			
			for(int i=0; i<size; i++) {
				int now = queue.poll();
				isVisited[now] = true;
				
				int next;
				
				next = now - 1;
				if(next == K) {
					count++;
				} else if(next >= 0 && !isVisited[next]) {
					queue.offer(next);
				}
				
				next = now + 1;
				if(next == K) {
					count++;
				} else if(next < 100001 && !isVisited[next]) {
					queue.offer(next);
				}
				
				next = now * 2;
				if(next == K) {
					count++;
				} else if(next < 100001 && !isVisited[next]) {
					queue.offer(next);
				}
			}
			
			if(count!=0) {
				queue.clear();
			}
		
		}
		
	
	}

}
