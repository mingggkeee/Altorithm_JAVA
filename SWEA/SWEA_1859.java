package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * SWEA_1859_D2_백만 장자 프로젝트
 * @author mingggkeee
 *
 */

public class SWEA_1859 {
	
	static int T;
	static long answer;
	static int N;
	static int[] price;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			answer = 0;
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			
			price = new int[N];
			for(int i=0; i<N; i++) {
				price[i] = Integer.parseInt(st.nextToken());
			}
			
			int max = 0;
			
			for(int i=N-1; i>=0; i--) {
				if(max < price[i]) {
					max = price[i];
				} else {
					int margin = max - price[i];
					answer += margin;
				}
			}
			System.out.println("#"+t+" "+answer);
		}
		
	}

}
