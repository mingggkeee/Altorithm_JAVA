package 구현;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * BOJ_17143_G2_낚시왕
 * @author mingggkeee
 * 1 : 위, 2 : 아래, 3 : 오른쪽, 4 : 왼쪽
 */

public class BOJ_17143 {
	
	static int R,C,shark;
	static int[][] map;
	static List<Integer> remove;
	static List<Shark> list;
	static int answer = 0;
	static int[][] dir = {{0,0}, {-1,0}, {1, 0}, {0, 1}, {0, -1}};
	
	static class Shark{
		int r;
		int c;
		int v;
		int dir;
		int weight;
		boolean reverse;
		
		public Shark(int r, int c, int v, int dir, int weight, boolean reverse) {
			super();
			this.r = r;
			this.c = c;
			this.v = v;
			this.dir = dir;
			this.weight = weight;
			this.reverse = reverse;
		}
		
		
		
	}
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		shark = Integer.parseInt(st.nextToken());
		
		list = new ArrayList<>();
		
		for(int i=0; i<shark; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			list.add(new Shark(r,c,v,dir,weight, false));
		}
		
		for(int i=1; i<=C; i++) {
			searchShark(0, i);
			moveShark();
			removeShark();
		}
		
		System.out.println(answer);
		
	}
	
	static void searchShark(int r, int c) {
		
		int rmWeight = -1;
		int row = R+1;
		
		for(Shark shark : list) {
			if(shark.c == c) {
				
				if(shark.r < row) {
					
					row = shark.r;
					rmWeight = shark.weight;
					
				}
				
			}
		}
		
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).weight == rmWeight) {
				answer += rmWeight;
				list.remove(i);
				break;
			}
		}
		
	}
	
	static void moveShark() {
		
		map = new int[R+1][C+1];
		remove = new ArrayList<>();
		
		for(int i=0; i<list.size(); i++) {
			
			Shark now = list.get(i);
			
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
			
			if(map[now.r][now.c] != 0 ) {
				if(map[now.r][now.c] > now.weight) {
					remove.add(now.weight);
				} else {
					remove.add(map[now.r][now.c]);
					map[now.r][now.c] = now.weight;
					
				}
			} else {
				map[now.r][now.c] = now.weight; 
			}

		}
		
	}
	
	static void removeShark() {
		
		for(int i=0; i<remove.size(); i++) {
			
			int weight = remove.get(i);
			
			for(int k=0; k<list.size(); k++) {
				
				if(weight == list.get(k).weight) {
					list.remove(k);
					break;
				}
				
			}
			
			
		}
		
	}

}
