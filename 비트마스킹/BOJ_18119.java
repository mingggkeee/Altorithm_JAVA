package 비트마스킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ_18119_G4_단어 암기
 * @author mingggkeee
 * 완탐, 비트마스킹
 */

public class BOJ_18119 {

	static int N, M;
	static int[] memo;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		String word = "";
		memo = new int[N];
		
		for(int i=0; i<N; i++) {
			word = br.readLine();
			for(int j=0; j<word.length(); j++) {
				memo[i] |= 1<<(word.charAt(j)-'a');
			}
		}
		
		int save = -1;
		for(int i=0; i<M; i++) {
			
			st = new StringTokenizer(br.readLine());
			
			int command = Integer.parseInt(st.nextToken());
			char alpha = st.nextToken().charAt(0);
			
			if(command==1) {
				
				save &= ~(1<<(alpha-'a'));
				
			} else {
				
				save |= (1<<(alpha-'a'));
				
			}
			
			int answer = 0;
			for(int k=0; k<N; k++) {
				if(memo[k]==(memo[k]&save)) {
					answer++;
				}
			}
			System.out.println(answer);
			
		}
		
	}
	
}
