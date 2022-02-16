package DFS와BFS;

/**
 * BOJ_18428_S1_감시피하기
 * @author mingggkeee
 * DFS, 백트래킹, 조합
 */

import java.util.Scanner;

public class BOJ_18428 {
	
	static int N;
	static char[][] map;
	static int [][] move = {{-1,0},{1,0},{0,-1},{0,1}};
	static String answer="NO";

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new char[N][N];

		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				String s = sc.next();
				map[i][j] = s.charAt(0);
			}
			
		}
		
		dfs(0);
		
		System.out.println(answer);
		
		sc.close();
	}
	
	static void dfs(int cnt) {
		if(cnt == 3) {
			boolean watch = false;
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j] != 'T')
						continue;
					
					// 감시 가능한 학생이 존재하는지 
					boolean temp = find(i, j);
					// 감시 가능 
					if(temp == true) {
						watch = true;
						break;
					}
				}
				// 감시 가능 
				if(watch == true)
					break;
			}
			// 감시 불가 
			if(watch == false)
				answer = "YES";
			return;
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] != 'X')
					continue;
				map[i][j] = 'O';
				dfs(cnt+1);
				map[i][j] = 'X';
			}
		}
	}
	
	static boolean find(int r, int c) {
		
		
		for(int i=0; i<4; i++) {
			int nr = r;
			int nc = c;
			while(true) {
				nr += move[i][0];
				nc += move[i][1];
				if(nr<0 || nr>=N || nc<0 || nc>=N)
					break;
				if(map[nr][nc] == 'O')
					break;
				
				if(map[nr][nc] == 'S')
					return true;
			
			}
		}
		
		return false;
	}

}