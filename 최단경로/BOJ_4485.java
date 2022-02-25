package 최단경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ_4485_G4_녹색 옷 입은 애가 젤다지?
 * @author mingggkeee
 *
 */

public class BOJ_4485 {
	
	static int N;
	static int[][] map;
	static int answer;
	static int [][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N==0) {
				break;
			}
			
			map = new int[N][N];
			
			for(int r=0;r<N;r++) {
				st = new StringTokenizer(br.readLine());
				for(int c=0;c<N;c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			answer = Integer.MAX_VALUE;
			
			System.out.println("Problem 1: "+answer);
		}
		
	}
	
	static void dfs(int r, int c) {
		
		
		
		
	}

}
