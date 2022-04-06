package DFS와BFS;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BOJ_1389_S1_케빈 베이컨의 6단계 법칙
 * @author mingggkeee
 *
 */

public class BOJ_1389 {
	
	static int N, M;
	static int[][] map;
	static boolean[] isVisited;
	static int answer = Integer.MAX_VALUE;
	static int idx;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][N+1];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int to = Integer.parseInt(st.nextToken());
			int from = Integer.parseInt(st.nextToken());
			map[to][from] = 1;
			map[from][to] = 1;
		}
		
		for(int i=1; i<=N; i++) {
			int compare = bfs(i);
			if(answer > compare) {
				answer = compare;
				idx = i;
			}
		}
		
		System.out.println(idx);
		
	}
	
	static int bfs(int r) {
		
		int count = 0;
		Queue<Bacon> queue = new LinkedList<>();
		queue.offer(new Bacon(r, 0));
		isVisited = new boolean[N+1];
		
		
		while(!queue.isEmpty()) {
			
			Bacon now = queue.poll();
			
			if(isVisited[now.r]) {
				continue;
			}
			
			isVisited[now.r] = true;
			count += now.count; 
			
			for(int c=1; c<=N; c++) {
				if(c==now.r) {
					continue;
				}
				
				if(map[now.r][c] == 1) {
					queue.offer(new Bacon(c, now.count+1));
				}
			}
			
		}
		
		return count;
		
		
	}
	
	static class Bacon{
		int r;
		int count;
		
		public Bacon(int r, int count) {
			this.r = r;
			this.count = count;
		}

	}

}
