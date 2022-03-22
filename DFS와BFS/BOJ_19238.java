package DFS와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BOJ_19238_G3_스타트 택시
 * @author mingggkeee
 * BFS, 시뮬레이션
 */

public class BOJ_19238 {
	
	static class Location{
		int r;
		int c;
		int count;
		
		public Location(int r, int c, int count) {
			this.r = r;
			this.c = c;
			this.count = count;
		}
		
	}
	
	static int N, M, fuel;
	static int[][] map, people, destination;
	static int startR, startC;
	static boolean[][] isVisited;
	static int minDistance;
	static boolean[] visited;
	static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		fuel = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][N+1];
		people = new int[M][2];
		destination = new int[M][2];
		visited = new boolean[M];
		
		for(int r=1; r<=N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=1; c<=N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		startR = Integer.parseInt(st.nextToken());
		startC = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			people[i][0] = Integer.parseInt(st.nextToken());
			people[i][1] = Integer.parseInt(st.nextToken());
			
			destination[i][0] = Integer.parseInt(st.nextToken());
			destination[i][1] = Integer.parseInt(st.nextToken());
		}
		
		while(fuel != 0) {
			minDistance = Integer.MAX_VALUE;
			int idx = -1;
			int cnt = 0;
			
			for(int i=0; i<M; i++) {
				if(visited[i]) {
					cnt++;
					continue;
				}
				int compare = bfs(startR, startC, people[i][0], people[i][1]);
				if(compare < minDistance && compare > -1) {
					idx = i;
					minDistance = compare;
				}
				else if(compare == minDistance) {
					
					if(people[i][0] < people[idx][0]) {
						idx = i;
					}
					else if(people[i][0] == people[idx][0] && people[i][1] < people[idx][1]) {
						idx = i;
					}
					
				}
			}
			
			if(cnt == M) {
				break;
			}
			
			if(idx == -1) {
				fuel = -1;
				break;
			}
			
			fuel -= minDistance;
			startR = people[idx][0];
			startC = people[idx][1];
			
			minDistance = bfs(startR, startC, destination[idx][0], destination[idx][1]);
			
			if(minDistance == -1) {
				fuel = -1;
				break;
			}
			
			fuel += minDistance;
			visited[idx] = true;
			startR = destination[idx][0];
			startC = destination[idx][1];
			
		}
		
		System.out.println(fuel);
		
		
	}
	
	static int bfs(int startR, int startC, int endR, int endC) {
		
		isVisited = new boolean[N+1][N+1];
		isVisited[startR][startC] = true;
		
		Queue<Location> queue = new LinkedList<>();
		queue.offer(new Location(startR, startC, 0));
		
		while(!queue.isEmpty()) {
			Location now = queue.poll();
			
			if(fuel < now.count) {
				return -1;
			}
			
			if(now.r==endR && now.c==endC) {
				return now.count;
			}
			
			for(int i=0; i<4; i++) {
				int nr = now.r + dir[i][0];
				int nc = now.c + dir[i][1];
				
				if(nr>=1 && nc>=1 && nr<=N && nc<=N && !isVisited[nr][nc] && map[nr][nc] != 1) {
					isVisited[nr][nc] = true;
					queue.offer(new Location(nr, nc, now.count+1));
				}
			}
			
		}
		
		return -1;
		
	}

}
