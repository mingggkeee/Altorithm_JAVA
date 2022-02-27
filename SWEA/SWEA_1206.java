package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * SWEA_1206_D3_View
 * @author mingggkeee
 *
 */

public class SWEA_1206 {
	
	static int N;
	static int[] height;
	static int answer;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int t=1; t<=10; t++) {
			N = Integer.parseInt(br.readLine());
			answer = 0;
			height = new int[N];
			
			st = new StringTokenizer(br.readLine());
			
			for(int i=0; i<N; i++) {
				height[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i=2; i<N-2; i++) {
				int compare = Integer.MAX_VALUE;
				
				int H = height[i];
				
				
				
				for(int j=i-2; j<=i+2; j++) {
					if(j==i)
						continue;
					
					if(H > height[j]) {
						compare = Math.min(H - height[j], compare);
					}
					else {
						compare = 0;
					}
					
				}
				
				if(compare == Integer.MAX_VALUE) {
					compare = 0;
				}
				
				answer += compare;
			
			}

			
			System.out.println("#"+t+" "+answer);
			
		}
	}
	
}
