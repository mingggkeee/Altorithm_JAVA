package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ_15998_G3_카카오머니
 * @Author mingggkeee
 * @Date 2022. 4. 12.
 * @Category : 구현
 */

public class BOJ_15998 {

	static int N;
	static long money;
	static long answer = -1;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			
			st = new StringTokenizer(br.readLine());
			long log = Long.parseLong(st.nextToken());
			long balance = Long.parseLong(st.nextToken());
			
			money += log;
			
			if(money != log) {
				
			}
			
		}
		
		System.out.println(answer);
		
	}
	
}
