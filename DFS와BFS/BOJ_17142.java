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
 * BOJ_17142_G4_17142
 * @Author mingggkeee
 * @Date 2022. 4. 27.
 * @Category : BFS, 조합
 */
public class BOJ_17142 {
	
	static class Location{
		int r;
		int c;
		int time;
		
		public Location(int r, int c, int time) {
			this.r = r;
			this.c = c;
			this.time = time;
		}
	}
	
	static int N, M;
	static int[][] map;
	static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
	static Location[] selected;
	static List<Location> viruses;
	static int zeroCnt;
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());	// N * N의 맵
		map = new int[N][N];
		M = Integer.parseInt(st.nextToken());	// 바이러스의 개수
		selected = new Location[M];
		
		viruses = new ArrayList<>();
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if(map[r][c] == 2) {
					viruses.add(new Location(r, c, 0));
				}
				if(map[r][c] == 0) {
					zeroCnt++;
				}
			}
		}
		
		combi(0, 0);
		
		
		if(answer == Integer.MAX_VALUE) {
			answer = -1;
		}
		System.out.println(answer);
	}
	
	static void combi(int start, int cnt) {
		
		if(cnt == M) {
			bfs();
			return;
		}
		
		for(int i=start; i<viruses.size(); i++) {
			selected[cnt] = viruses.get(i);
			combi(i+1, cnt+1);
		}
		
	}
	
	static void bfs() {
		boolean[][] isVisited = new boolean[N][N];
		
		Queue<Location> queue = new LinkedList<>();
		for(int i=0; i<M; i++) {
			Location input = selected[i];
			queue.offer(input);
			isVisited[input.r][input.c] = true; 
		}
		
		int compare = 0;
		int count = 0;
		
		while(!queue.isEmpty()) {
			Location now = queue.poll();
			
			if(now.time >= answer) {
				break;
			}
			
			for(int i=0; i<4; i++) {
				int nr = now.r + dir[i][0];
				int nc = now.c + dir[i][1];
				
				if(nr>=0 && nc>=0 && nr<N && nc<N && map[nr][nc] != 1 && !isVisited[nr][nc]) {
					
					isVisited[nr][nc] = true;
					if(map[nr][nc] == 0) {
						count++;
						compare = now.time+1;
					} 
					queue.offer(new Location(nr, nc, now.time+1));
					
				}
			}
				
		}

		if(count == zeroCnt) {
			answer = Math.min(compare, answer);
		}
		
	}

}
