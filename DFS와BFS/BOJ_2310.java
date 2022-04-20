package DFS와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BOJ_2310_G5_어드벤처 게임
 * @Author mingggkeee
 * @Date 2022. 4. 20.
 * @Category : BFS
 */

public class BOJ_2310 {
	
	static class Adventure{
		int n;
		int money;
		
		public Adventure(int n, int money) {
			super();
			this.n = n;
			this.money = money;
		}
		
		
	}

	static int N;
	static char[] types;
	static int[] money;
	static int[][] map;
	static boolean[][] isVisited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N == 0) {
				break;
			}
			
			types = new char[N+1];
			map = new int[N+1][N+1];
			money = new int[N+1];
			
			for(int i=1; i<=N; i++) {
				st = new StringTokenizer(br.readLine());
				types[i] = st.nextToken().charAt(0);
				money[i] = Integer.parseInt(st.nextToken());
				
				while(true) {
					int temp = Integer.parseInt(st.nextToken());
					if(temp == 0) {
						break;
					}
					
					map[i][temp] = 1;
				}	
			}
			
			sb.append(bfs()+"\n");
		}
		
		System.out.println(sb.toString());
	}
	
	static String bfs() {
		
		Queue<Adventure> queue = new LinkedList<>();
		queue.offer(new Adventure(1, 0));
		isVisited = new boolean[N+1][N+1];
		
		while(!queue.isEmpty()) {
			Adventure now = queue.poll();
			
			if(now.n == N) {
				return "Yes";
			}
			
			for(int i=1; i<=N; i++) {
				
				if(map[now.n][i] == 1 && !isVisited[now.n][i]) {
					if(types[i] == 'L' ) {
						isVisited[now.n][i] = true;
						if(now.money < money[i])
							queue.offer(new Adventure(i, money[i]));
						else
							queue.offer(new Adventure(i, now.money));
						
					} else if(types[i] == 'T' && now.money>=money[i]) {
						isVisited[now.n][i] = true;
						queue.offer(new Adventure(i, now.money-money[i]));
					} else if(types[i] == 'E') {
						isVisited[now.n][i] = true;
						queue.offer(new Adventure(i, now.money));
					}
					
					
				}
				
			}
			
		}
		
		
		return "No";
	}
	
}
