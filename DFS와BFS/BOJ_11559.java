package DFS와BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * BOJ_11559_G4_Puyo Puyo
 * @author mingggkeee
 * BFS, 시뮬레이션
 */

public class BOJ_11559 {
	
	static class Location{
		int r;
		int c;
		
		public Location(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
	static char[][] map;
	static int count;
	static Queue<Location> queue = new LinkedList<>();
	static boolean[][] isVisited = new boolean[12][6];
	static List<Location> list;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		map = new char[12][6];
		
		for(int r=0; r<12; r++) {
			String input = sc.nextLine();
			for(int c=0; c<6; c++) {
				map[r][c] = input.charAt(c);
			}
		}
		
		
		while(true) {
			
			isVisited = new boolean[12][6];
			
			boolean check = false;
		
			for(int r=0; r<12; r++) {
				for(int c=0; c<6; c++) {
					if(!isVisited[r][c] && map[r][c] != '.') {
						list = new ArrayList<>();
						bfs(r,c,map[r][c]);
						
						if(list.size() >= 4) {
							check = true;
							for(int i=0; i<list.size(); i++) {
								map[list.get(i).r][list.get(i).c] = '.'; 
							}
						}
					}
				}
			}
			
			
			if(!check) {
				break;
			}
			modifyMap();
			count++;
		}
		
		System.out.println(count);
		
		
		sc.close();
		
	}
	
	static void modifyMap() {
		for(int c=0; c<6; c++) {
			for(int r=11; r>0; r--) {
				if(map[r][c] == '.') {
					for(int i=r-1; i>=0; i--) {
						if(map[i][c] != '.') {
							map[r][c] = map[i][c];
							map[i][c] = '.';
							break;
						}
					}
				}
			}
		}
	}
	
	
	static void bfs(int r, int c, char type) {
		queue = new LinkedList<>();
		list.add(new Location(r,c));
		queue.offer(new Location(r, c));
		isVisited[r][c] = true;
		
		while(!queue.isEmpty()) {
			Location now = queue.poll();
			
			for(int i=0; i<4; i++) {
				int nr = now.r + dir[i][0];
				int nc = now.c + dir[i][1];
				
				if(nr>=0 && nc>=0 && nr<12 && nc<6 && !isVisited[nr][nc] && map[nr][nc] == type) {
					isVisited[nr][nc] = true;
					list.add(new Location(nr,nc));
					queue.offer(new Location(nr, nc));
				}
			}
		}
	}

}
