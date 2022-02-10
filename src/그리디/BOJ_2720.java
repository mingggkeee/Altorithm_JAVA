package 그리디;

import java.util.Scanner;

/**
 * BOJ_2720_B3_세탁소 사장 동혁
 * @author mingggkeee
 * 그리디 알고리즘
 * 거스름돈은 항상 5.00달러 이하, 손님이 받는 동전의 개수를 최소로 하려함.
 */

public class BOJ_2720 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();	// 테케
		int [] money = {25, 10, 5, 1};
		int [] count = new int[4];
		for(int i=0; i<N; i++) {
			int price = sc.nextInt();
			for(int m=0; m<money.length; m++) {
				count[m] = price / money[m];
				price = price % money[m];
			}
			for(int cnt : count) {
				System.out.print(cnt+" ");
			}
			System.out.println();
		}
		
		sc.close();
	}

}
