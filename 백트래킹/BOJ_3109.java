package 백트래킹;

import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ_3109_G2_빵집
 * @author mingggkeee
 * 백트래킹
 */

public class BOJ_3109 {
	
	static int R,C;
	static char [][] map;
	static int count;
	static boolean [][] isVisited;	// 한칸에 파이프는 한개
	static int[][] dir = {{-1,1}, {0,1},{1,1}};	// 오른쪽 위, 오른쪽, 오른쪽 아래 순으로 파이프를 연결해야 최대를 뽑을 수 있다.
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		isVisited = new boolean[R][C];
		
		for(int r=0; r<R; r++) {
			String input = br.readLine();
			for(int c=0;c<C;c++) {
				map[r][c] = input.charAt(c);
			}
		}
		
		// 0열(0행부터 C-1행까지)
		for(int r=0; r<R; r++) {
			isVisited[r][0] = true;
			pipeSearch(r, 0);
		}
		
		System.out.println(count);
		
	}
	
	
	public static boolean pipeSearch(int r, int c) {
		
		// 기저 조건 : 마지막 열에 닿으면 파이프 연결 완료 count++
		if(c == C -1) {
			count++;
			return true;
		}
		
		for(int i=0; i<3; i++) {
			int nr = r+dir[i][0];
			int nc = c+dir[i][1];
			
			// 파이프 연결 불가능한 조건
			if(nr<0 || nr >=R || map[nr][nc] == 'x' || isVisited[nr][nc]) {
				continue;
			}
			
			isVisited[nr][nc] = true;	
			if(pipeSearch(nr,nc)) {
				return true;
				// 연결이 다 되면 재귀종료
			}
		}
		
		return false;
			
	}

}
