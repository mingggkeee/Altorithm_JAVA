package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * BOJ_17135_G4_캐슬 디펜스
 * @Author mingggkeee
 * @Date 2022. 4. 8.
 * @Category : 구현, 시뮬레이션
 */

public class BOJ_17135 {
	
	static class Location implements Comparable<Location>{
		
		int r;
		int c;
		int d;
		
		public Location(int r, int c, int d) {
			this.r = r;
			this.c = c;
			this.d = d;
		}

		@Override
		public int compareTo(Location o) {
			
			if(this.d == o.d) {
				return this.c - o.c;
			}
			
			
			return this.d-o.d;
		}
		
	}
	
	static int R,C,D,answer;
	static int[][] map, temp;
	static int[] isSelected;
	static boolean[][] isVisited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		isSelected = new int[3];
		map = new int[R][C];
		for(int r=0; r<R; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<C; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		combi(0, 0);
		
		System.out.println(answer);
	}
	
	static void combi(int start, int cnt) {
		if(cnt == 3) {
			
			defense(isSelected);
			
			return;
		}
		
		for(int i=start; i<C; i++) {
			isSelected[cnt] = i;
			combi(i+1,cnt+1);
		}
	}
	
	static void defense(int[] isSelected) {
		int count = 0;
		temp = new int[R][C];
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				temp[r][c] = map[r][c];
			}
		}
		
		for(int t=0; t<R; t++) {
			isVisited = new boolean[R][C];
			for(int i=0; i<3; i++) {
				PriorityQueue<Location> pq = new PriorityQueue<>();
				int idx = isSelected[i];
				for(int c=0; c<C; c++) {
					for(int r=R-1; r>=0; r--) {
						if(temp[r][c] == 1 && Math.abs(R-r)+Math.abs(idx-c) <= D) {
							pq.offer(new Location(r, c, Math.abs(R-r)+Math.abs(idx-c)));
						}
					}
				}
				
				if(pq.size()>0) {
					Location delete = pq.poll();
					
					if(!isVisited[delete.r][delete.c]) {
						count++;
						isVisited[delete.r][delete.c] = true; 
					}
				}
				
				
			}
			
			
			for(int r=0; r<R; r++) {
				for(int c=0; c<C; c++) {
					if(isVisited[r][c]) {
						temp[r][c] = 0;
					}
				}
			}
			
			blockDown();
			
			/*
			for(int r=0; r<R; r++) {
				for(int c=0; c<C; c++) {
					System.out.print(temp[r][c] + " ");
				}
				System.out.println();
			}
			System.out.println();
			*/
			
		}
		
		answer = Math.max(count, answer);
		
		
	}
	
	static void blockDown() {
		
		for(int r=R-2; r>=0; r--) {
			for(int c=0; c<C; c++) {
				temp[r+1][c] = temp[r][c];
			}
		}
		
		for(int c=0; c<C; c++) {
			temp[0][c] = 0;
		}
		
	}

}
