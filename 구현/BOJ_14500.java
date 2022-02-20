package 구현;

import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ_14500_G5_테트로미노
 * @author mingggkeee
 * 구현
 */

public class BOJ_14500 {
	static int R,C;
	static int[][] map;
	static int answer;
	static int dir[][] = {{0,1},{0,-1},{1,0},{-1,0}};// 동서남북 탐색
	
	// ㅜ ㅗ ㅓ ㅏ 탐색
	static int[][] dir2R = {{0, 0, 0, 1}, {0, 0, 0, -1}, {0, 0, -1, 1}, {0, 0, -1, 1}}; //세로
	static int[][] dir2C = {{0, 1, -1, 0}, {0, 1, -1, 0}, {0, -1, 0, 0}, {0, 1, 0, 0}}; //가로

	static boolean[][] isVisited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		isVisited = new boolean[R][C];
		map = new int[R][C];
		
		for(int r=0;r<R;r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0;c<C;c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int r=0;r<R;r++) {
			for(int c=0;c<C;c++) {
				isVisited[r][c] = true;
				dfs(r, c, 1, map[r][c]);
				isVisited[r][c] = false;
				
				elseCase(r, c);
			}
		}
		System.out.println(answer);
		
		
	}
	
    static void dfs(int r, int c, int cnt, int sum) {

        if (cnt == 4) {
            answer = Math.max(answer, sum);
            return;
        }

        for (int k = 0; k < 4; k++) {
            int nr = r + dir[k][0];
            int nc = c + dir[k][1];

            if (nr < 0 || nc < 0 || nr >= R || nc >= C || isVisited[nr][nc]) {
                continue;
            }

            isVisited[nr][nc] = true;
            dfs(nr, nc, cnt + 1, sum + map[nr][nc]);
            isVisited[nr][nc] = false;
        }
    }

    public static void elseCase(int r, int c) {
    	int nr, nc, temp;
    	boolean isPossible = true;
    	for(int i=0; i<4; i++) {
    		temp = 0;
    		isPossible = true;
    		for(int j=0; j<4; j++) {
    			nr = r + dir2R[i][j];
    			nc = c + dir2C[i][j];
    			
    			// 범위 체크
    			if(nr<0 || nc <0 || nr >=R || nc >= C) {
    				isPossible = false;
    				continue;
    			}
    			
    			temp += map[nr][nc];
    		}
    		
    		// 범위 안나갔으면 최대값인지 체킹
    		if(isPossible) {
    			answer = Math.max(temp, answer);
    		}
    	}
    }

}
