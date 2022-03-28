package DFS와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BOJ_16928_G5_뱀과 사다리 게임
 * @author mingggkeee
 * BFS
 */

public class BOJ_16928 {
	
	static class Move{
		int loc;
		int cnt;
		
		public Move(int loc, int cnt) {
			this.loc = loc;
			this.cnt = cnt;
		}
		
	}
	
	static int[][] snake, ladder;
	static int N,M;
	static boolean[] isVisited;
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		snake = new int[N][2];
		M = Integer.parseInt(st.nextToken());
		ladder = new int[M][2];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			snake[i][0] = Integer.parseInt(st.nextToken());
			snake[i][1] = Integer.parseInt(st.nextToken());
		}
		

		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			ladder[i][0] = Integer.parseInt(st.nextToken());
			ladder[i][1] = Integer.parseInt(st.nextToken());
		}
		
		bfs(1);
		
		System.out.println(answer);
	}
	
	static void bfs(int start) {
		Queue<Move> queue = new LinkedList<>();
		isVisited = new boolean[101];
		
		isVisited[1] = true;
		queue.offer(new Move(1, 0));
		
		while(!queue.isEmpty()) {
			
			Move now = queue.poll();
			
			if(now.loc==100) {
				answer = Math.min(now.cnt, answer);
			}
			
			for(int i=1; i<=6; i++) {
				int future = now.loc+i;
				if(future<=100 && !isVisited[future]) {
					
					isVisited[future] = true;
					
					for(int j=0; j<N; j++) {
						if(snake[j][0] == future) {
							future = snake[j][1];
							break;
						}
					}
					
					for(int j=0; j<M; j++) {
						if(ladder[j][0] == future) {
							future = ladder[j][1];
							break;
						}
					}
					
					isVisited[future] = true;
					
					queue.offer(new Move(future, now.cnt+1));
					
					
				}
			}
			
		}
		
	}
	
}
