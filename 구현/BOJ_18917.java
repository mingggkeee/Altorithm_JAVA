package 구현;

import java.util.Scanner;

/**
 * BOJ_18917_S4_수열과 쿼리 38
 * @Author mingggkeee
 * @Date 2022. 6. 4.
 * @Category : 구현
 */

public class BOJ_18917 {

	static int N;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		long sum = 0;
		long xor = 0;
		
		for(int i=0; i<N; i++) {
			int command = sc.nextInt();
			
			if(command == 1) {
				int num = sc.nextInt();
				sum += num;
				xor ^= num;
			} else if(command == 2) {
				int num = sc.nextInt();
				sum -= num;
				xor ^= num;
			} else if(command == 3) {
				System.out.println(sum);
			} else if(command == 4) {
				System.out.println(xor);
			}
		}
		
		sc.close();
	}
	
}
