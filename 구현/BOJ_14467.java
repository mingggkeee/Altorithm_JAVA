package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ_14467_S5_소가 길을 건너간 이유 1
 * @Author mingggkeee
 * @Date 2022. 4. 23.
 * @Category : 구현
 */

public class BOJ_14467 {

	static int N;
	static int[] cows;
	static int answer;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		cows = new int[11];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int cow = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken()) + 1;
			
			if(cows[cow] == 0) {
				cows[cow] = num;
			} else if(cows[cow] != num) {
				answer++;
				cows[cow] = num;
			}
			
		}
		
		System.out.println(answer);
		
	}
	
}
