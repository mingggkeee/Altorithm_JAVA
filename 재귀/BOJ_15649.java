package 재귀;

import java.util.Scanner;

/**
 * BOJ_15649_S3_N과 M(1)
 * @author "mingggkeee"
 * 순열
 */
public class BOJ_15649 {
	
	static int n,m;
	static boolean [] isSelected;
	static int[] numbers;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		numbers = new int[m];
		isSelected = new boolean[n+1];
		
		permu(0);
		sc.close();
	}
	
	public static void permu(int cnt) {
		if(cnt==m) {
			for(int i : numbers) {
				System.out.print(i+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=1; i<=n; i++) {
			if(isSelected[i]) {
				continue;
			}
			
			numbers[cnt] = i;
			isSelected[i] = true;
			
			permu(cnt+1);
			isSelected[i] = false;
		}
	}

}
