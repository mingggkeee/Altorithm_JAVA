package 백트래킹;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

/**
 * BOJ_1941_G3_소문난 칠공주
 * @author mingggkeee
 * 조합,DFS,BFS,백트래킹
 */

public class BOJ_1941 {
	
	static class Location {
		int r, c;

		Location(int r, int c) {
			this.r = r;
			this.c = c;
		}
		
	}
	
	static char[][] map;
	static boolean[] isVisited;
	static int answer;
	static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
	
	static void combi(int cnt, int start, int y) {
		if (cnt == 7) {
			if (bfs())
				answer++;
			return;
		} 
		
		for (int i = start; i < 25; i++) {
			if (map[i / 5][i % 5] == 'Y' && y + 1 < 4) {
				isVisited[i] = true;
				combi(cnt + 1, i + 1, y + 1);
				isVisited[i] = false;
			}
			if (map[i / 5][i % 5] == 'S') {
				isVisited[i] = true;
				combi(cnt + 1, i + 1, y);
				isVisited[i] = false;
			}
		}
		
	}

	
	static boolean bfs() {
		Queue<Location> queue = new LinkedList<>();
		boolean[][] check = new boolean[5][5];
		
		for(int i = 0; i<25; i++) {
			if(isVisited[i]) {
				check[i / 5][i % 5] = true;
				queue.offer(new Location(i / 5, i % 5));
				break;
			}
		}
		
		int count = 1;
		
		while(!queue.isEmpty()) {
			Location now = queue.poll();
			for(int i = 0; i<4; i++) {
				int nr = now.r + dir[i][0];
				int nc = now.c + dir[i][1];
				if(nr < 0 || nr >= 5 || nc < 0 || nc >= 5) continue;
				if(!isVisited[nr * 5 + nc] || check[nr][nc]) continue;
				check[nr][nc] = true;
				queue.offer(new Location(nr, nc));
				count++;
			}
		}
		
		if(count == 7)
			return true;

		return false;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new char[5][5];
		isVisited = new boolean[25];
		for (int i = 0; i < 5; i++) {
			String input = br.readLine();
			map[i] = input.toCharArray();
		}
		combi(0, 0, 0);
		System.out.println(answer);
	}
}
