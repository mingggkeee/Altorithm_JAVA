package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * SWEA_7964_D3_부먹왕국의 차원 관문
 * @author mingggkeee
 *
 */


public class SWEA_7964 {
	
	static int T;
	static int answer;
	static int N, D;
	static int[] map;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			answer = 0;
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			D = Integer.parseInt(st.nextToken());
			
			map = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				map[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i=0; i<N; i++) {
				if(map[i] == 0) {
					boolean check1 = true;
					
					// 왼쪽
					for(int l=1; l<D; l++) {
						if(i-l >= 0) {
							if(map[i-l] == 1) {
								check1 = false;
							}
						}
					}
					
					if(check1) {
						answer++;
						map[i] = 1;
						continue;
					}
					
					// 오른쪽
					
					boolean check2 = true;
					
					for(int r=1; r<D; r++) {
						if(i+r < N) {
							if(map[i+r] == 1) {
								check2 = false;
							}
						}
					}
					
					
					if(check1 && check2) {
						answer++;
						map[i] = 1;
					}
					
				}
			}
			System.out.println("#"+t+" "+answer);
		}
		
	}

}
