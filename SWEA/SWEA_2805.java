package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_2805 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine()); // 농장의 크기 받기
			int [][] map = new int[N][N];
			
			for(int r=0; r<N; r++) {
				String s = br.readLine();
				String[] temp = s.split("");
				for(int c=0; c<N; c++) {
					int price = Integer.parseInt(temp[c]);
					map[r][c] = price;
				}
			}
			
			if(N==1) {
				System.out.println("#"+t+" "+map[0][0]);
			}
			else {
				int answer = 0; // 수익 변수
				int r = N/2;
				
				// 가운데 더하기
				for(int i=0; i<N; i++) {
					answer += map[r][i];
				}
				// 위쪽 더하기
				r = N/2-1;
				int lc = 1;
				int rc = N-2;
				while(r>=0) {
					for(int i=lc; i<=rc; i++) {
						answer += map[r][i];
					}
					r--;
					lc++;
					rc--;
				}
				// 아래쪽 더하기
				r = N/2+1;	
				lc = 1;
				rc = N-2;
				while(r<N) {
					for(int i=lc; i<=rc; i++) {
						answer += map[r][i];
					}
					r++;
					lc++;
					rc--;
				}
				System.out.println("#"+t+" "+answer);
			}
		}
	}
}
