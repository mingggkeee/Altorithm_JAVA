package 완탐;

import java.util.Scanner;

/*
 * 기타콘서트
 * 부분집합 문제
 */
public class BOJ_1497 {
	
	static int N,M,answer;
	static String[] name, can;
	static boolean[] isSelected;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 기타의 개수
		M = sc.nextInt(); // 곡의 개수
		
		name = new String[N];
		can = new String[N];
		isSelected = new boolean[N];
		
		for(int i=0; i<N; i++) {
			name[i] = sc.next();
			can[i] = sc.next();
		}
		answer = Integer.MAX_VALUE;
		
		generateSubset(0);
	}
	
	public static void generateSubset(int cnt) {	// 부분 집합에 고려해야 하는 원소, 직전까지 고려한 원소 수
		
		if(cnt == N){
			for(int i=0; i<N; i++) {
				String yesno = Arrays.to
				for(int j=i; j<N; j++) {
					System.out.print((isSelected[i]?name[i]:"X")+"  ");
				}
			}
			System.out.println();
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
