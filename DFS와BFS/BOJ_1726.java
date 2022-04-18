package DFS와BFS;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BOJ_1726_G3_로봇
 * @Author mingggkeee
 * @Date 2022. 4. 17.
 * @Category : BFS
 */

public class BOJ_1726 {
	
	static class Location{
		int r;
		int c;
		int command;
		int dir;
		
		public Location(int r, int c, int dir, int command) {
			this.r = r;
			this.c = c;
			this.dir = dir;
			this.command = command;
		}
	}
	
	static int R,C,answer;
	static int[][] map;
	static boolean[][][] isVisited;
	static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
	static int startR, startC, endR, endC, startDir, endDir;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		
		for(int r=0; r<R; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<C; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		startR = Integer.parseInt(st.nextToken())-1;
		startC = Integer.parseInt(st.nextToken())-1;
		startDir = Integer.parseInt(st.nextToken())-1;
		
		st = new StringTokenizer(br.readLine());
		endR = Integer.parseInt(st.nextToken())-1;
		endC = Integer.parseInt(st.nextToken())-1;
		endDir = Integer.parseInt(st.nextToken())-1;
		
		answer = bfs();
		
		System.out.println(answer);
	}
	
	static int bfs() {
		
		Queue<Location> queue = new LinkedList<>();
		isVisited = new boolean[R][C][4];
		isVisited[startR][startC][startDir] = true;
		queue.offer(new Location(startR, startC, startDir, 0));
		
		
		while(!queue.isEmpty()) {
			
			Location now = queue.poll();
			
			if(now.r == endR && now.c == endC && now.dir==endDir) {
				return now.command;
			}
			
			for(int i=1; i<=3; i++) {
				// 전진
				int nr = now.r + dir[now.dir][0]*i;
				int nc = now.c + dir[now.dir][1]*i;
				
				if(nr < 0 || nc < 0 || nr>=R || nc>=C ) {
					continue;
				}
				
				if(map[nr][nc] == 1) {
					break;
				}
				
				if(!isVisited[nr][nc][now.dir]) {
					isVisited[nr][nc][now.dir] = true;
					queue.offer(new Location(nr, nc, now.dir, now.command+1));
				}
			}
			
			
			// 회전
			int nd = now.dir;
			// 동쪽, 남쪽일때 2,3 더하기
			if(nd % 2 == 0) {
				nd = (now.dir + 2) % 4;
				if(!isVisited[now.r][now.c][nd]) {
					isVisited[now.r][now.c][nd] = true;
					queue.offer(new Location(now.r, now.c, nd, now.command+1));
				}
				nd = (now.dir + 3) % 4;
				if(!isVisited[now.r][now.c][nd]) {
					isVisited[now.r][now.c][nd] = true;
					queue.offer(new Location(now.r, now.c, nd, now.command+1));
				}
			}
			// 서쪽, 북쪽일때 1,2 더하기
			else {
				nd = (now.dir + 1) % 4;
				if(!isVisited[now.r][now.c][nd]) {
					isVisited[now.r][now.c][nd] = true;
					queue.offer(new Location(now.r, now.c, nd, now.command+1));
				}
				
				nd = (now.dir + 2) % 4;
				if(!isVisited[now.r][now.c][nd]) {
					isVisited[now.r][now.c][nd] = true;
					queue.offer(new Location(now.r, now.c, nd, now.command+1));
				}
			}
		}
		
		return -1;
	}

}
