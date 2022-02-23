package DFS와BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * BOJ_2638_G4_치즈
 * @author mingggkeee
 * 
 */

public class BOJ_2638 {
	
	static int R,C;
	static int[][] map;
	static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
	static boolean[][] isVisited;
	static List<Location> list = new ArrayList<>();
	static int cheeseCount;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		R = sc.nextInt();
		C = sc.nextInt();
		map = new int[R][C];
		
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				map[r][c] = sc.nextInt();
				if(map[r][c] == 1) {
					list.add(new Location(r,c));
					cheeseCount++;
				}
			}
		}

		int answer = 0;
		
		while(cheeseCount != 0) {
			answer++;
			isVisited = new boolean[R][C];
			// 공기 찾기
			dfs(0,0);
			
			
			meltCheese();
			
		}
		
		System.out.println(answer);
		
		
		sc.close();
		
	}
	
	// 외부공기 찾기 외부공기는 0->2로 바꿔주기
	static void dfs(int r, int c) {
		isVisited[r][c] = true;
		map[r][c] = 2;
		
		for(int i=0; i<4; i++) {
			int nr = r + dir[i][0];
			int nc = c + dir[i][1];
			
			if(nr<0 || nr>=R || nc<0 || nc>=C) {
				continue;
			}
			// 치즈인 경우 패스
			if(isVisited[nr][nc] || map[nr][nc] == 1) {
				continue;
			}

			
			dfs(nr, nc);
		}
	}
	
	// 치즈 녹이기
	static void meltCheese() {
		for(int k=0; k<list.size(); k++) {
			int r = list.get(k).r;
			int c = list.get(k).c;
			int count = 0;
			
			for(int i=0; i<4; i++) {
				int nr = r + dir[i][0];
				int nc = c + dir[i][1];
				
				if(map[nr][nc] == 2) {
					count++;
				}
			}
			
			if(count>=2) {
				map[r][c] = 0;
				cheeseCount--;
				list.remove(k--);
			}
		}
		
	}
	
	// 외부마찰 2개이상인지 확인
	static boolean check(int r, int c) {
		int cnt = 0;
		for(int i=0; i<4; i++) {
			int nr = r + dir[i][0];
			int nc = c + dir[i][1];
			
			if(nr<0 | nc<0 | nr>R-1 | nc>C-1) {
				continue;
			}
			if(map[nr][nc] == 2)
				cnt++;
		}
		
		if(cnt>=2)
			return true;
		return false;
	}
	
	static class Location{
		int r;
		int c;
		
		public Location(int r, int c) {
			this.r = r;
			this.c = c;
		}
		
	}
}
