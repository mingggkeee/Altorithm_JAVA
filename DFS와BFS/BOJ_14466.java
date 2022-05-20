package DFS와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BOJ_14466_G4_소가길을건너간이유6
 * @Author mingggkeee
 * @Date 2022. 5. 18.
 * @Category : BFS
 */

public class BOJ_14466 {
	
	static class Cow {
		int r;
		int c;
		
		public Cow(int r, int c) {
			this.r = r;
			this.c = c;
		}
		
		@Override
			public boolean equals(Object obj) {
				Cow cow = (Cow) obj;
				
				return this.r == cow.r && this.c == cow.c;
			}
	}

	static int N, K, R;
	static int[][] map;
	static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][N+1];
		
		List<Cow>[][] bridges = new ArrayList[N+1][N+1];
		
		for(int r=1; r<=N; r++) {
			for(int c=1; c<=N; c++) {
				bridges[r][c] = new ArrayList<>();
			}
		}
		
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine());
			
			int r1 = Integer.parseInt(st.nextToken());
			int c1 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			int c2 = Integer.parseInt(st.nextToken());
			
			bridges[r1][c1].add(new Cow(r2, c2));
			bridges[r2][c2].add(new Cow(r1, c1));
		}
		
		List<Cow> cows = new ArrayList<>();
		
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			cows.add(new Cow(r, c));
			map[r][c] = 1;
		}
		
		int answer = 0;
		
		for(int t=0; t<K; t++) {
			Cow cow = cows.get(t);
			
			boolean[][] isVisited = new boolean[N+1][N+1];
			boolean[][] isContact = new boolean[K][K];
			Queue<Cow> queue = new LinkedList<>();
			
			queue.offer(cow);
			isVisited[cow.r][cow.c]= true;
			
			while(!queue.isEmpty()) {
				Cow now = queue.poll();
				
				if(map[now.r][now.c] == 1) {
					for(int j=t+1; j<K; j++) {
						Cow next = cows.get(j);
						
						if(next.r == now.r && next.c == now.c) {
							isContact[t][j] = true;
							break;
						}
					}
				}
				
				for(int i=0; i<4; i++) {
					int nr = now.r + dir[i][0];
					int nc = now.c + dir[i][1];
					
					if(bridges[now.r][now.c].contains(new Cow(nr, nc))) {
						continue;
					}
					
					if(nr > 0 && nc > 0 && nr <= N && nc<=N && !isVisited[nr][nc]) {
						isVisited[nr][nc] = true;
						queue.offer(new Cow(nr, nc));
					}
				}
			}
			
			for(int i=t+1; i<K; i++) {
				if(!isContact[t][i]) {
					answer++;
				}
			}
			

		}
		
		System.out.println(answer);
	}
	
}
