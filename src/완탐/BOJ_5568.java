package 완탐;

import java.util.HashSet;
import java.util.Scanner;

/**
 * BOJ_5568_S5_카드놓기
 * @author USER
 * 순열 문제
 */
public class BOJ_5568 {
	
	static int N, K;
	static String[] card;
	static boolean[] isExist;
	static HashSet<String> hs = new HashSet<String>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		
		card = new String[N];
		isExist = new boolean[N];
		
		for(int i=0; i<N; i++) {
			card[i] = sc.next();
		}
		
		select(K, "");
		System.out.println(hs.size());
		sc.close();
	}
	
	public static void select(int cnt, String str) {
		if(cnt == 0) {
			hs.add(str);
			return;
		}
		for(int i=0; i<N; i++) {
			if(!isExist[i]) {
				isExist[i] = true;
				select(cnt-1, str + card[i]);
				isExist[i] = false;
			}
		}
	}
}
