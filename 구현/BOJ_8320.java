package 구현;

import java.util.Scanner;

/**
 * BOJ_8320_G2_직사각형을 만드는 방법
 * @author mingggkeee
 * 구현
 */

public class BOJ_8320 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		
		int answer = 0;
		
		for(int i=1; i<=n; i++) {
			for(int j=i; j*i<=n; j++) {
				answer++;
			}
		}
		
		System.out.println(answer);
		
		sc.close();
		
		
	}

}
