package 백트래킹;

import java.util.Scanner;

/**
 * BOJ_10819_S2_차이를 최대로
 * @author mingggkeee
 * 백트래킹
 */

public class BOJ_10819 {
	
	static int N;
	static int[] inputs;
	static int[] selected;
	static boolean[] isVisited;
	static int answer = Integer.MIN_VALUE;
	static int compare;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		inputs = new int[N];
		selected = new int[N];
		isVisited = new boolean[N];
		
		for(int i=0; i<N; i++) {
			inputs[i] = sc.nextInt();
		}
		
		permu(0);
		
		System.out.println(answer);
		
		sc.close();
	}
	
	static void permu(int cnt) {
		
		if(cnt == N) {
			calculator(selected);
			answer = Math.max(compare, answer);
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(!isVisited[i]) {
				isVisited[i] = true;
				selected[cnt] = inputs[i];
				permu(cnt+1);
				isVisited[i] = false;
			}
		}
		
	}
	
	static void calculator(int[] selected) {
		compare = 0;
		for(int i=0; i<N-1; i++) {
			int temp = Math.abs(selected[i] - selected[i+1]);
			compare += temp;
		}
	}
	
}
