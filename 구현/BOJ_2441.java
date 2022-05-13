package 구현;

import java.util.Scanner;

/**
 * BOJ_2441_B3_별찍기4
 * @Author mingggkeee
 * @Date 2022. 5. 13.
 * @Category : 구현
 */
public class BOJ_2441 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		for(int i=N; i>0; i--) {
			for(int j=N; j>i; j--) {
				System.out.print(" ");
			}
			for(int j=0; j<i; j++) {
				System.out.print("*");
			}

			System.out.println();
		}
		
		sc.close();
	}
	
}
