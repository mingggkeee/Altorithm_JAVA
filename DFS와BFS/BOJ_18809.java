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
 * BOJ_18809_G1_Gaaaaaaaaaarden
 * @Author mingggkeee
 * @Date 2022. 4. 6.
 * @Category : BFS, 시뮬레이션, 조합
 */

public class BOJ_18809 {
	
	static int R,C,green,red;
	static int[][] map;
	static List<Location> list, redList, greenList;
	static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
	static int[][] isVisited;
	static int answer;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		green = Integer.parseInt(st.nextToken());
		red = Integer.parseInt(st.nextToken());
		
		list = new ArrayList<>();
		redList = new ArrayList<>();
		greenList = new ArrayList<>();
		
		map = new int[R][C];
		for(int r=0; r<R; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<C; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if(map[r][c] == 2) {
					list.add(new Location(r, c, false));
				}
			}
		}

		combi(0, 3, 0);
		
		System.out.println(answer);
		
	}
	
	static void combi(int cnt, int color, int idx) {
		
		if(color == 3 && cnt == red) {
			combi(0, 4, 0);
			return;
		}
		
		if(color == 4 && cnt == green) {
			bfs();
			return;
		}
		
		for(int i=idx; i<list.size(); i++) {
			
			Location loc = list.get(i);
			if(loc.select == false) {
				
				loc.select = true;
				map[loc.r][loc.c] = color;
				
				if(color == 3) {
					redList.add(new Location(loc.r, loc.c));
				}
				
				if(color == 4) {
					greenList.add(new Location(loc.r, loc.c));
				}
				
				combi(cnt+1, color, i+1);
				loc.select = false;
				if(color==3) {
					redList.remove(redList.size()-1);
				}
				if(color==4) {
					greenList.remove(greenList.size()-1);
				}
				map[loc.r][loc.c] = 2; 
				
			}
			
			
		}
		
	}
	
	
	

	static void bfs() {
		
		//맵복사
		int[][] copy=new int[R][C];
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				copy[r][c]=map[r][c];
			}
		}
		
		// 초록색은 4 빨간색은 3 꽃이면 5
		int flower = 0;
		int time = 1;
		
		Queue<Location> redQ = new LinkedList<>();
		Queue<Location> greenQ = new LinkedList<>();
		isVisited = new int[R][C];
		
		for(Location r : redList) {
			redQ.offer(r);
			isVisited[r.r][r.c] = 0; 
		}
		
		for(Location r : greenList) {
			greenQ.offer(r);
			isVisited[r.r][r.c] = 0; 
		}
		
		while(true) {
			
			if(redQ.isEmpty() && greenQ.isEmpty()) {
				answer = Math.max(flower, answer);
				break;
			}
			
			int rsize = redQ.size();
			int gsize = greenQ.size();
			
			while(rsize-->0) {
				Location now = redQ.poll();
				
				if(copy[now.r][now.c] == 5) {
					continue;
				}
				
				for(int i=0; i<4; i++) {
					
					int nr = now.r + dir[i][0];
					int nc = now.c + dir[i][1];
					
					if(nr<0 || nc<0 || nr>=R || nc>=C || isVisited[nr][nc] > 0) {
						continue;
					}

					if(copy[nr][nc] == 1 || copy[nr][nc] == 2) {
						
						isVisited[nr][nc] = time;
						copy[nr][nc] = 3;
						redQ.offer(new Location(nr, nc));
						
					}
					
				}
			}
			
			while(gsize-->0) {
				Location now = greenQ.poll();
				
				for(int i=0; i<4; i++) {
					
					int nr = now.r + dir[i][0];
					int nc = now.c + dir[i][1];
					
					if(nr<0 || nc<0 || nr>=R || nc>=C) {
						continue;
					}

					if(copy[nr][nc] == 1 || copy[nr][nc] == 2) {
						isVisited[nr][nc] = time;
						copy[nr][nc] = 4;
						greenQ.offer(new Location(nr, nc));
						
					}
					
					if(copy[nr][nc] == 3 && isVisited[nr][nc] == time) {
						flower++;
						copy[nr][nc] = 5;
					}
					
				}
			}
			
			time++;
			
			
		}

		
	}
	
	
	static class Location{
		int r;
		int c;
		boolean select;

		public Location(int r, int c) {
			this.r = r;
			this.c = c;
		}
		
		public Location(int r, int c, boolean select) {
			this.r = r;
			this.c = c;
			this.select = select;
		}
	}

}
