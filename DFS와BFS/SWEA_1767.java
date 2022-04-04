package DFS와BFS;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * SWEA_1767_프로세서 연결하기
 * @author mingggkeee
 * DFS
 */

public class SWEA_1767 {
	
	static class Core{
		int r;
		int c;
		
		public Core(int r, int c) {
			this.r = r;
			this.c = c;
		}
		
	}
	
	static int N, T;
	static int[][] map;
	static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
	static List<Core> list;
	static int min, max;
	
	public static void main(String[] args) throws IOException{
		StringTokenizer st;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
			list = new ArrayList<>();
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			
			for(int r=0; r<N; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c=0; c<N; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
					if(map[r][c] == 1) {
						if(r-1<0 || c-1<0 || r+1>=N || c+1>=N) {
							continue;
						}
						list.add(new Core(r, c)); // 벽에 붙어있지 않은 것 저장
					}
				}
			}
			
			dfs(0,0,0);
			
			sb.append("#"+t+" "+min+"\n");
		}
		
		System.out.println(sb.toString());
		
	}
	
	static void dfs(int cnt, int coreCnt, int length) {
		
		if(cnt == list.size()) {
			
			if(max < coreCnt) {
				max = coreCnt;
				min = length;
			}
			else if(max == coreCnt) {
				if(min > length) {
					min = length;
				}
			}
			
			return;
		}
		
		int r = list.get(cnt).r;
		int c = list.get(cnt).c;
		
		for(int i=0; i<4; i++) {
			
			int count = 0;
			int nr = r;
			int nc = c;
			int saveR = r;
			int saveC = c;
			
			while(true) {
				
				nr += dir[i][0];
				nc += dir[i][1];
				
				if(nr<0 || nc<0 || nr>=N || nc>=N) {
					break;
				}
				
				if(map[nr][nc] == 1) {
					count = 0;
					break;
				}
				
				count++;
				
			}
			
			for(int j=0; j<count; j++) {
				saveR += dir[i][0];
				saveC += dir[i][1];
				// 전선연결
				map[saveR][saveC] = 1;
			}
			
			if(count == 0) {
				dfs(cnt+1, coreCnt, length);
			} else {
				dfs(cnt+1, coreCnt+1, length+count);
				
				saveR = r;
				saveC = c;
				for(int j=0; j<count; j++) {
					saveR += dir[i][0];
					saveC += dir[i][1];
					// 전선해제
					map[saveR][saveC] = 0;
				}
			}
			
		}
		
	}

}
