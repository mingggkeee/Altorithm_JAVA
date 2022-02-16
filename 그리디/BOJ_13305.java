package 그리디;

import java.util.Scanner;

/**
 * BOJ_13305_S4_주유소
 * @author mingggkeee
 * 그리디 알고리즘
 */

public class BOJ_13305 {
	
	static int N;
	static long [] cost, roadLen;
	static long answer;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();	// 도시의 개수
		roadLen = new long[N-1];	// 도시간의 거리
		cost = new long[N-1];	// 도시의 기름 가격
		
		for(int i=0; i<roadLen.length; i++) {
			roadLen[i] = sc.nextLong();
		}
		
		for(int i=0; i<N-1; i++) {
			cost[i] = sc.nextLong();
		}
		sc.nextLong();
		
		long curCost = cost[0];
		
		for(int i=0; i<cost.length; i++) {
			
			if(curCost > cost[i]) {
				curCost = cost[i];
				answer += curCost * roadLen[i];
				
				
			} else {
				answer += curCost * roadLen[i];
			}
			
		}
		
		System.out.println(answer);
		
		sc.close();
		
	}

}
