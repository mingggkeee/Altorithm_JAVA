package 구현;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * BOJ_16926_S2_배열 돌리기1
 * @author mingggkeee
 * 단순 구현
 */

public class BOJ_16926 {
	static int N,M,R;
	static int[][] map;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 돌려야하는 그룹 개수 구하기
		int group = Math.min(N, M) / 2;
		
		for(int t=0; t<R; t++) {
			for(int i=0; i<group; i++) {
				int x= i;
				int y= i;
				
				int temp = map[x][y];
				
				int dir = 0; // 방향
				
				while(dir<4) {
					int nx = x + dx[dir];
					int ny = y + dy[dir];
					
					if(nx>=i && ny>=i && nx<N-i && ny<M-i) {
						map[x][y] = map[nx][ny];
						x = nx;
						y = ny;
					}
					
					else {
						dir++;
					}
				}
				map[i+1][i] = temp;
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				bw.write(map[i][j]+" ");
			}
			bw.write("\n");
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
}

