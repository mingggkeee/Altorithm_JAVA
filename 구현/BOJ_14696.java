package 구현;

import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ_14696_B1_딱지놀이
 * @author mingggkeee
 * 구현
 * 별 : 4, 동그라미 : 3, 네모 : 2, 세모 : 1
 */

public class BOJ_14696 {
	static int N;
	static int [] aCard, bCard;
	static StringTokenizer st;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void input(int N) throws IOException{
		for(int i=0; i<N; i++) {
			aCard = new int[5];
			bCard = new int[5];
			st = new StringTokenizer(br.readLine());
			// A
			int num1 = Integer.parseInt(st.nextToken());
			for(int j=0; j<num1; j++) {
				int num2 = Integer.parseInt(st.nextToken());
				aCard[num2]++;
			}
			
			// B
			st = new StringTokenizer(br.readLine());
			int num3 = Integer.parseInt(st.nextToken());
			for(int j=0; j<num3; j++) {
				int num4 = Integer.parseInt(st.nextToken());
				bCard[num4]++;
			}
			compare();
		}
	}
		
	public static void compare() {
		char answer = 'D';
		for(int i=4; i>0; i--) {
			if(aCard[i] > bCard[i]) {
				answer = 'A';
				break;
			} else if(aCard[i] == bCard[i]){
				continue;
			} else {
				answer = 'B';
				break;
			}
		}
		System.out.println(answer);

	}
	
	public static void main(String[] args) throws IOException{

		N = Integer.parseInt(br.readLine());
		input(N);
			
	}
	
}
