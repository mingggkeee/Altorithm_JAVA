package 백트래킹;

import java.util.Scanner;

/**
 * BOJ_10974_S3_모든 순열
 * @author mingggkeee
 * 백트래킹
 */

public class BOJ_10974 {
	
	static int N;
	static int[] selected;
	static boolean[] isVisited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		selected = new int[N];
		isVisited = new boolean[N+1];
		
		permu(0);
		
		sc.close();
	}
	
	static void permu(int cnt) {
		if(cnt == N) {
			for(int i : selected) {
				System.out.print(i+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=1; i<=N; i++) {
			if(!isVisited[i]) {
				isVisited[i] = true;
				selected[cnt] = i;
				permu(cnt+1);
				isVisited[i] = false;
			}
		}
	}

}
