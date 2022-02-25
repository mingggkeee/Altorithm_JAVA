package 구현;

import java.util.Scanner;

/**
 * BOJ_3985_B1_롤 케이크
 * @author mingggkeee
 * 구현
 */

public class BOJ_3985 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int L = sc.nextInt();	// 길이
		int N = sc.nextInt();	// 사람 수
		
		boolean[] isVisited = new boolean[L+1];
		
		int cake = Integer.MIN_VALUE;
		int idx = 0;
		int fake = 0;
		int fakeidx = 0;
		
		for(int i=1; i<=N; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			
			if(end-start+1 > fake) {
				fake = end-start+1;
				fakeidx = i;
			}
			
			int temp = 0;
			
			for(int p=start; p<=end; p++) {
				
				if(!isVisited[p]) {
					isVisited[p] = true;
					temp++;
				}
				
			}
			
			if(temp > cake) {
				cake = temp;
				idx = i;
			}
			
			
		}
		
		System.out.println(fakeidx);
		System.out.println(idx);
		
		sc.close();
		
	}

}
