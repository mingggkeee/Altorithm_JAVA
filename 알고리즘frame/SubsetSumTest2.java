package 알고리즘frame;

import java.util.Scanner;

public class SubsetSumTest2 {
	
	static int N, input[], S,answer;
	static boolean[] isSelected;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();	// 집합의 크기
		S = sc.nextInt();	// 목표 합
		
		input = new int[N];
		isSelected = new boolean[N];
		
		for(int i=0; i<N; i++) {
			input[i] = sc.nextInt();
		}
		
		generateSubset(0, 0);
		System.out.println(answer);
		System.out.println(callCnt);
		sc.close();
	}
	
	static int callCnt=0;
	
	public static void generateSubset(int cnt, int sum) {	// cnt : 부분 집합에 고려해야 하는 원소, 직전까지 고려한 원소 수
		
		++callCnt;
		// sum : 직전까지 구성된 부분집합의 합
		if(sum==S) {
			answer++;
			for(int i=0; i<cnt; i++) {
				System.out.print(isSelected[i]?input[i]+" ":"");
			}
			System.out.println();
			return;
		}
		
		if(sum>S) {
			return;
		}
		
		
		if(cnt==N) {	// 마지막 원소까지 부분집합에 다 고려된 상황
			return;
		}
		
		// 현재 원소를 선택
		isSelected[cnt] = true;
		generateSubset(cnt+1,sum+input[cnt]);
		// 현재 원소를 비선택
		isSelected[cnt] = false;
		generateSubset(cnt+1,sum);
	}
	
	
}


