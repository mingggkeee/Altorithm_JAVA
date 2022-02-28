package 그리디;

import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ_11501_S2_주식
 * @author mingggkeee
 * 그리디알고리즘
 */

public class BOJ_11501 {
	
	static int T;
	static long answer;
	static int volume;
	static int[] price;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			answer = 0;
			volume = Integer.parseInt(br.readLine());
			price = new int[volume];
			
			st = new StringTokenizer(br.readLine());
			for(int k=0; k<volume; k++) {
				price[k] = Integer.parseInt(st.nextToken());
			}
			
			int max = 0;
			
			for(int j=volume-1; j>=0; j--) {
				if(price[j] > max) {
					max = price[j];
				} 
				else {
					int margin = max - price[j];
					answer += margin;
				}
			}
			
			System.out.println(answer);
		}
		
	}

}
