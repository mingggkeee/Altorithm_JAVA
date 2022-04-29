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
 * BOJ_17141_G4_연구소 2
 * @Author mingggkeee
 * @Date 2022. 4. 29.
 * @Category : BFS
 */

public class BOJ_17141 {
	
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
	
	static int N, M, zeroCnt;
	static int[][] map;
	static List<Location> list;
	static Location[] selected;
	static boolean[][] isVisited;
	static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
	static int answer = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList<>();
		map = new int[N][N];
		selected = new Location[M];
		
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if(map[r][c] == 2) {
					list.add(new Location(r, c, 0));
				}
				if(map[r][c] == 0) {
					zeroCnt++;
				}
			}
		}
		
		combi(0, 0);
		
		if(answer == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(answer);
		}
		
	}
	
	static void combi(int start, int cnt) {
		if(cnt == M) {
			bfs();
			return;
		}
		
		for(int i=start; i<list.size(); i++) {
			
			selected[cnt] = list.get(i);
			combi(i+1, cnt+1);
		}
		
	}
	
	static void bfs() {
		
		isVisited = new boolean[N][N];
		Queue<Location> queue = new LinkedList<>();
		for(int i=0; i<M; i++) {
			Location temp = selected[i];
			isVisited[temp.r][temp.c] = true;
			queue.offer(temp);
		}
		int count = 0;
		int curTime = 0;
		
		while(!queue.isEmpty()) {
			
			Location now = queue.poll();
			
			for(int i=0; i<4; i++) {
				int nr = now.r + dir[i][0];
				int nc = now.c + dir[i][1];
				
				if(nr>=0 && nc>=0 && nr<N && nc<N && map[nr][nc] != 1 && !isVisited[nr][nc]) {
					
					if(map[nr][nc] == 0) {
						count++;
					}
					
					isVisited[nr][nc] = true;
					queue.offer(new Location(nr, nc, now.time+1));
					curTime = now.time+1;
					
				}
				
			}
			
		}
		
		if(count == zeroCnt) {
			answer = Math.min(answer, curTime);
		}
		
	}

}
