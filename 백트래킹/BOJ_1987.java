package 백트래킹;

import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ_1987_G4_알파벳
 * @author mingggkeee
 * 백트래킹, DFS
 */

public class BOJ_1987 {
	
	static int R,C;
	static char[][] map;
	static int answer = Integer.MIN_VALUE;
	static boolean isVisited[];
	static int [][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		isVisited = new boolean[26];
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		
		for(int r=0; r<R; r++) {
			String str = br.readLine();
			for(int c=0;c<C;c++) {
				map[r][c] = str.charAt(c);
			}
		}
		
		search(0,0,1);
		
		System.out.println(answer);
	}
	
	public static void search(int r, int c, int sum) {
		
		isVisited[map[r][c] - 'A'] = true;
		for(int i=0; i<4; i++) {
			int nr = r + dir[i][0];
			int nc = c + dir[i][1];
			
			if(nr>=0 && nc>=0 && nr<R && nc<C) {
				if(!isVisited[map[nr][nc]-'A'])
					search(nr,nc,sum+1);
			}
		}
		isVisited[map[r][c] - 'A'] = false;
		answer = Math.max(answer, sum);
		
	}
	

}
