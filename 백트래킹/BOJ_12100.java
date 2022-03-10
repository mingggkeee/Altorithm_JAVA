package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ_12100_G2_2048(Easy)
 * @author mingggkeee
 * 백트래킹, 시뮬레이션, 브루트포스
 */

public class BOJ_12100 {
	
	static int N;
	static int[][] map;
	static int[] selected;
	static boolean[][] isVisited;
	static int answer = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		
		selected = new int[1];
		
		for(int r=0; r<N; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int c=0; c<N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		permu(0);
		
		System.out.println(answer);
		
	}
	
	static void permu(int cnt) {
		if(cnt==5) {
			int compare = 0;
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					if(map[r][c] > compare) {
						compare = map[r][c];
					}
				}
			}
			
			answer = Math.max(answer, compare);
			
			return;
		}
		
		int copy[][] = new int[N][N];
		
		for(int r=0; r<N; r++) {
			copy[r] = map[r].clone();
		}
		
		for(int i=0; i<4; i++) {
			moving(i);
			permu(cnt+1);
			for(int r=0; r<N; r++) {
				map[r] = copy[r].clone();
			}
		}
	}
	
	static void moving(int dir) {
		
		// 남
		if(dir==0) {
			for(int c=0; c<N; c++) {
				int idx = N-1;
				int block = 0;
				for(int r=N-1; r>=0; r--) {
					if(map[r][c] != 0) {
						if(block == map[r][c]) {
							map[idx+1][c] = block * 2;
							block = 0;
							map[r][c] = 0;
						}
						else {
							block = map[r][c];
							map[r][c]=0;
							map[idx][c] = block;
							idx--;
						}
					}
				}
			}

			
		}
		// 북
		else if(dir==1) {
			for(int c=0; c<N; c++) {
				int idx = 0;
				int block = 0;
				for(int r=0; r<N; r++) {
					if(map[r][c] != 0) {
						if(block == map[r][c]) {
							map[idx-1][c] = block * 2;
							block = 0;
							map[r][c] = 0;
						}
						else {
							block = map[r][c];
							map[r][c]=0;
							map[idx][c] = block;
							idx++;
						}
					}
				}
			}
			
		}
		// 동
		else if(dir==2) {
			
			for(int r=0; r<N; r++) {
				int idx = N-1;
				int block = 0;
				for(int c=N-1; c>=0; c--) {
					if(map[r][c] !=0) {
						
						if(block == map[r][c]) {
							map[r][idx+1] = block * 2;
							block = 0;
							map[r][c] = 0;
						}
						else {
							block = map[r][c];
							map[r][c] = 0;
							map[r][idx] = block;
							idx--;
						}
					}
				}
			}
			
		}
		// 서
		else if(dir==3) {
			
			for(int r=0; r<N; r++) {
				int idx = 0;
				int block = 0;
				for(int c=0; c<N; c++) {
					if(map[r][c] !=0) {
						
						if(block == map[r][c]) {
							map[r][idx-1] = block * 2;
							block = 0;
							map[r][c] = 0;
						}
						else {
							block = map[r][c];
							map[r][c] = 0;
							map[r][idx] = block;
							idx++;
						}
					}
				}
			}
			
		}
			
			
		
		
	}

}
