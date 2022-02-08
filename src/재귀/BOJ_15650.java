package 재귀;

import java.util.Scanner;

/**
 * BOJ_15650_S3_N과 M(2)
 * @author "mingggkeee"
 * 조합
 */
public class BOJ_15650 {
	
	static int n,m;
	static int[] numbers;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		numbers = new int[m];
		combi(0,1);
		sc.close();
	}
	
	public static void combi(int cnt, int start) {
		if(cnt==m) {
			for(int i : numbers) {
				System.out.print(i+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=start; i<=n; i++) {
			numbers[cnt] = i;
			combi(cnt+1, i+1);
		}
	}
}
