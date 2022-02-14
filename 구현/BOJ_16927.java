package 구현;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * BOJ_16926_G5_배열 돌리기2
 * @author mingggkeee
 * 단순 구현
 */

public class BOJ_16927 {
	static int N,M,R;
	static int[][] map;
	static int[] dy = {0, 1, 0, -1};
	static int[] dx = {1, 0, -1, 0};
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
    	int i, j, d = 0, nr;
    	int group = Math.min(N, M)/2;
		for(int idx = 0; idx < group; idx++) {
			nr = R % ((N - idx * 2) * 2 + (M - idx * 2) * 2 - 4);		// 반복 횟수를 줄인다.  
			while(nr-- != 0) {
				i = idx;
				j = idx;
				d = 0;
				int tmp = map[i][j];
				
				while(d != 4) {
					if(i + dy[d] < idx || i + dy[d] >= N - idx  || j + dx[d] < idx || j + dx[d] >= M - idx) {
						d++;
						continue;
					}
					map[i][j] = map[i + dy[d]][j + dx[d]];
					i += dy[d];
					j += dx[d];
				}
				map[idx + 1][idx] = tmp;
			}
    	}
    	
		
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				bw.write(map[r][c]+" ");
			}
			bw.write("\n");
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
}