package SWEA;

import java.io.*;
import java.util.StringTokenizer;

/**
 * SWEA_1861_D4_정사각형 방
 * @author mingggkeee
 * 구현
 */

public class SWEA_1861 {
	
	static int [][] map;
	static int N, T;
	static int answer = Integer.MAX_VALUE;	// 정답 방
	static int maxCount, compareCount;
	static int[] dx = {0, 1, -1, 0};
	static int[] dy = {1, 0, 0, -1};	// 남 동 서 북 
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine()); 	// 테스트 케이스 받기
		
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			// 정보 입력 받기
			for(int r=0; r<N; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c=0; c<N; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			search();
			bw.write("#"+t+" "+answer+" "+maxCount+"\n");
		}
		
		br.close();
		bw.flush();
		bw.close();
		
	}
	
	public static void search() {
		maxCount = 1;
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				compareCount = 1;
				int nx = c;
				int ny = r;
				while(true) {
					int count = 0;
					for(int i=0; i<4; i++) {
						if(nx + dx[i] < N && nx + dx[i] >=0 && ny + dy[i] < N && ny + dy[i] >=0 && map[ny + dy[i]][nx + dx[i]] - map[ny][nx] == 1) {
							compareCount++;
							nx = nx + dx[i];
							ny = ny + dy[i];
							count++;
							break;
						}
					}
					if(count == 0) {
						break;
					}
					
				}
				if(compareCount > maxCount) {
					answer = map[r][c];
					maxCount = compareCount;
				} else if (compareCount == maxCount) {
					if(answer > map[r][c]) {
						answer = map[r][c];
					}
				}
				
			}
		}
		
		
	}
}
