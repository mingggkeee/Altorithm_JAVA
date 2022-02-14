package 구현;

import java.io.*;
import java.util.StringTokenizer;
/**
 * BOJ_18428_S1_감시피하기
 * @author mingggkeee
 * 구현, 백트래킹
 */

public class BOJ_18428 {
	
	static int N;
	static char [][] map;
	static int count = 3;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		
		for(int r=0;r<N;r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0;c<N;c++) {
				map[r][c] = st.nextToken().charAt(0);
			}
		}
		
		for(int r=0;r<N;r++) {
			for(int c=0;c<N;c++) {
				if(map[r][c] == 'T') {
					int x = c;
					int y = r;
					// 오른쪽
					while(x+1<N) {
						
					}
					// 왼쪽
					
					// 북쪽
					
					// 아래쪽
				}
			}
		}
		
		
		br.close();
	}

}
