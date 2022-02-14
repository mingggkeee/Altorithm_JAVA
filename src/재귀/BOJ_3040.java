package 재귀;

import java.util.Scanner;

/**
 * BOJ_3040_B2_백설 공주와 일곱 난쟁이
 * @author mingggkeee
 * 구현, 조합
 */

public class BOJ_3040 {
	static int [] nums = new int[9];
	static int [] numbers = new int[7];
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for(int i=0; i<9; i++) {
			nums[i] = sc.nextInt();
		}
		
		combination(0, 0);
		
		sc.close();
	}
	
	public static void combination(int cnt, int start) {
		if(cnt==7) {
			int sum = 0;
			for(int i : numbers) {
				sum+=i;
			}
			
			if(sum==100) {
				for(int i : numbers) {
					System.out.println(i);
				}
			}
			
			return;
		}
		for(int i=start; i<9; i++) {
			numbers[cnt] = nums[i];
			combination(cnt+1, i+1);
		}
	}
}
