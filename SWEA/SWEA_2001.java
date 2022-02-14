package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2001 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int t=1; t<=T; t++) {
			int answer = 0;
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int [][] arr = new int[N][N];
			for(int r=0; r<N; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c=0; c<N; c++) {
					arr[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			// 최대값 정하기
			for(int i=0; i<=N-M; i++) {
				for(int j=0; j<=N-M; j++) {
					// 오른쪽, 아래로 한칸씩 밀리면서 계산가능
					int sum = 0;
					for(int m=i; m<i+M; m++) {
						for(int n=j; n<j+M; n++) {
							sum += arr[m][n];
						}
					}
					answer = Math.max(answer, sum);
				}
			}
			
			System.out.println("#"+t+" "+answer);
			
		}
		
		br.close();
	}
}
