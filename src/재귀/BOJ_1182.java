package 재귀;

import java.util.Scanner;

/**
 * BOJ_1182_S2_부분수열의 합
 * @author "mingggkeee"
 * 부분집합
 */

public class BOJ_1182 {
	
	static int N, input[], S, count, temp;
	static boolean[] isSelected;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();	// 정수의 개수
		S = sc.nextInt();	// 원하는 값
		
		input = new int[N];
		isSelected = new boolean[N];
		
		for(int i=0; i<N; i++) {
			input[i] = sc.nextInt();
		}
		
		generateSubset(0);
		
		System.out.println(count);
		sc.close();
	}
	
	public static void generateSubset(int cnt) {	// 부분 집합에 고려해야 하는 원소, 직전까지 고려한 원소 수
		
		if(cnt==N) {	// 마지막 원소까지 부분집합에 다 고려된 상황
			int selectCount = 0;
			temp = 0;
			for(int i=0; i<N; i++) {
				if(isSelected[i]) {
					selectCount++;
					temp += input[i];
				}
			}
			if(temp == S && selectCount>0) {
				count++;
			}
			return;
		}
		
		// 현재 원소를 선택
		isSelected[cnt] = true;
		generateSubset(cnt+1);
		// 현재 원소를 비선택
		isSelected[cnt] = false;
		generateSubset(cnt+1);
	}
}