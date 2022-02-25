package 구현;

import java.util.Scanner;

/**
 * BOJ_2810_B1_컵홀더
 * @author mingggkeee
 * 구현
 */

public class BOJ_2810 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		sc.nextLine();
		char[] input = sc.nextLine().toCharArray();
		
		int count = 1;
		
		for(int i=0; i<N; i++) {
			if(input[i] == 'L') {
				i++;
			}
			count++;
				
		}
		
		if(count > N) {
			System.out.println(N);
		} else {
			System.out.println(count);
		}
		
		sc.close();
	}

}
