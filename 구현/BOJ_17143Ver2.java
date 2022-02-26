package 구현;

import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ_17143_G2_낚시왕
 * @author mingggkeee
 * 1 : 위, 2 : 아래, 3 : 오른쪽, 4 : 왼쪽
 */

public class BOJ_17143Ver2 {
	
	static int R,C,shark;
	
	static Shark[][] map;
	
	static Shark[] list;
	
	static int answer = 0;
	static int[][] dir = {{0,0}, {-1,0}, {1, 0}, {0, 1}, {0, -1}};
	
	static class Shark{
		
		boolean alive;
		int r;
		int c;
		int v;
		int dir;
		int weight;
		boolean reverse;
		
		public Shark(int r, int c, int v, int dir, int weight) {
			
			this.alive = true;
			this.r = r;
			this.c = c;
			this.v = v;
			this.dir = dir;
			this.weight = weight;
			this.reverse = false;
		}
		
		
		
	}
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		shark = Integer.parseInt(st.nextToken());
		
		list = new Shark[shark];
		
		for(int i=0; i<shark; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			list[i] = new Shark(r,c,v,dir,weight);
		}
		
		for(int i=1; i<=C; i++) {
			searchShark(0, i);
			moveShark();
		}
		
		System.out.println(answer);
		
	}
	
	static void searchShark(int r, int c) {
		
		int rmWeight = -1;
		int row = R+1;
		
		for(Shark shark : list) {
			if(shark.c == c && shark.alive) {
				if(shark.r < row) {
					
					row = shark.r;
					rmWeight = shark.weight;
					
				}
				
			}
		}
		
		for(int i=0; i<shark; i++) {
			if(list[i].weight == rmWeight) {
				answer += rmWeight;
				list[i].alive = false;
				break;
			}
		}
		
	}
	
	static void moveShark() {
		
		map = new Shark[R+1][C+1];
		
		for(int i=0; i<shark; i++) {
			
			if(!list[i].alive) {
				continue;
			}
			
			Shark now = list[i];
			
			for(int m=0; m<now.v; m++) {
				
				if(now.reverse) {
					int nr = now.r - dir[now.dir][0];
					int nc = now.c - dir[now.dir][1];
					
					if(nr >= 1 && nc >= 1 && nr <=R && nc <= C) {
						now.r = nr;
						now.c = nc;
					} else {
						now.reverse = false;
						nr = now.r + dir[now.dir][0];
						nc = now.c + dir[now.dir][1];
						now.r = nr;
						now.c = nc;
						
					}
					
				}
				else {
					int nr = now.r + dir[now.dir][0];
					int nc = now.c + dir[now.dir][1];
					
					if(nr >= 1 && nc >= 1 && nr <=R && nc <= C) {
						now.r = nr;
						now.c = nc;
					} else {
						now.reverse = true;
						nr = now.r - dir[now.dir][0];
						nc = now.c - dir[now.dir][1];
						now.r = nr;
						now.c = nc;
						
					}
				}
				
			}
			
			if(map[now.r][now.c] != null ) {
				if(map[now.r][now.c].weight > now.weight) {
					now.alive = false;
				} else {
					map[now.r][now.c].alive = false;
					map[now.r][now.c] = now;
					
				}
			} else {
				map[now.r][now.c] = now; 
			}

		}
		
	}
	
	

}
