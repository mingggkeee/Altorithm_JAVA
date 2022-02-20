package DFS와BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * BOJ_1697_S1_숨바꼭질
 * @author mingggkeee
 * 
 */

public class BOJ_1697 {
	
	static int N, K;
	static int answer = Integer.MAX_VALUE;
	static int[] check = new int[100001];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		K = sc.nextInt();
		
		if(N==K) {
			System.out.println(0);
		} else {
			bfs();
		}
		
		
		sc.close();
	}
	
	public static void bfs() {
		
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(N);
		check[N] = 1;
		
		while(!queue.isEmpty()) {
			int temp = queue.poll();
			
			for(int i=0; i<3; i++) {
				int next;
				
				if(i==0) {
					next = temp -1;
				} else if(i==1) {
					next = temp +1;
				} else {
					next = temp*2;
				}
				
				if(next == K) {
					System.out.println(check[temp]);
					return;
				}
				
				if(next>=0 && next <= 100000 && check[next] == 0) {
					queue.add(next);
					check[next] = check[temp] + 1;
				}
			}
		
		}
		
	
	}
		

}
