package DFS와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BOJ_5014_G5_스타트 링크
 * @Author mingggkeee
 * @Date 2022. 5. 1.
 * @Category : BFS
 * 입력 : F, S, G, U, D
 */

public class BOJ_5014 {
	
	static class Elevator{
		int stair;
		int count;
		
		public Elevator(int stair, int count) {
			this.stair = stair;
			this.count = count;
		}
	}
	
	static int F, S, G, U, D;
	static boolean[] isVisited;
	static int answer = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		F = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		bfs();
		
		if(answer == Integer.MAX_VALUE) {
			System.out.println("use the stairs");
		} else {
			System.out.println(answer);
		}
	}
	
	static void bfs() {
		
		Queue<Elevator> queue = new LinkedList<>();
		isVisited = new boolean[F+1];
		
		isVisited[S] = true;
		queue.offer(new Elevator(S, 0));
		
		while(!queue.isEmpty()) {
			
			Elevator now = queue.poll();
			
			if(now.stair == G) {
				answer = now.count;
				return;
			}

				
			if(now.stair + U <= F && !isVisited[now.stair+U]) {
				isVisited[now.stair + U] = true;
				queue.offer(new Elevator(now.stair+U, now.count+1));
			}
			

			if(now.stair - D >= 1 && !isVisited[now.stair-D]) {
				isVisited[now.stair - D] = true;
				queue.offer(new Elevator(now.stair-D, now.count+1));
			}
			
			
		}
		
	}
	
}
