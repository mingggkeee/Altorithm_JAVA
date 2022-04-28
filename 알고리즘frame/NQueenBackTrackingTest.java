package 알고리즘frame;

import java.util.Scanner;

public class NQueenBackTrackingTest {
	
	static int N;
	static int[] col;
	static int answer;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		col = new int[N+1];
		sc.close();
		
		setQueen(1);
		
		System.out.println(answer);
	}
	
	public static void setQueen(int rowNo) { // rowNo : 퀸을 두어야 하는 현재 행
		
		if(!isPossible(rowNo-1)) { // 직전까지의 상황이 유망하지 않다면 리턴
			return;
		}
		
		// 기본 파트 : 퀸을 모두 놓았다면
		if(rowNo == N+1) {
			answer++;
			return;
		}
		
		
		// 1열부터 - N열까지 퀸을 놓는 시도
		for(int i = 1; i<=N; i++) {
			col[rowNo] = i;
			setQueen(rowNo + 1);
		}

	}
	
	public static boolean isPossible(int rowNo) { // rowNo : 놓아진 마지막 퀸
		
		for(int i=1; i<rowNo; i++) {
			if(col[rowNo] == col[i] || Math.abs(rowNo-i) == Math.abs(col[rowNo] - col[i]))
				return false;
		}
		
		return true;
	}

}
