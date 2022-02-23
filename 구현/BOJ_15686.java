package 구현;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * BOJ_15686_G5_치킨 배달
 * @author mingggkeee
 * 구현, 완전탐색
 */

public class BOJ_15686 {
	
	static class Location{
		int r;
		int c;
		
		public Location(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static int N, M;
	static int[][] map;
	static List<Location> list = new ArrayList<>();
	static Location[] chicken;
	static int answer = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		chicken = new Location[M];
		
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if(map[r][c] == 2) {
					list.add(new Location(r,c));
				}
			}
		}
		
		combi(0,0);
		
		System.out.println(answer);
		
	}
	
	static void combi(int cnt, int start) {
		if(cnt == M) {
			search();
			return;
		}
		
		for(int i=start; i<list.size(); i++) {
			chicken[cnt] = list.get(i);
			combi(cnt+1, i+1);
		}
		
		
	}
	
	static void search() {
		
		int temp = 0;
		
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(map[r][c] == 1) {
					int compare = Integer.MAX_VALUE;
					for(Location l : chicken) {
						int loc = Math.abs(l.r-r) + Math.abs(l.c-c);
						compare = Math.min(loc, compare);
					}
					temp += compare;
				}
			}
		}
		
		answer = Math.min(answer, temp);
	}

}
