package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BOJ_1091_G5_카드섞기
 * @Author mingggkeee
 * @Date 2022. 6. 26.
 * @Category : 구현
 */

public class BOJ_1091 {

	static int N, answer;
	static int[] p, order, cards;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		p = new int[N];
		order = new int[N];
		cards = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			p[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			order[Integer.parseInt(st.nextToken())] = i;
			cards[i] = i%3;
		}
		
		int[] compare = cards.clone();
		int[] next = new int[N];
		
		while(!Arrays.equals(cards, p) && !(answer !=0 && Arrays.equals(cards, compare))) {
			for(int i=0; i<N; i++) {
				next[order[i]] = cards[i];
			}
			
			cards = next.clone();
			answer++;
		}
		
		if(answer != 0 && Arrays.equals(cards, compare)) {
			System.out.println(-1);
		} else {
			System.out.println(answer);
		}
		
		
	}
	
}
