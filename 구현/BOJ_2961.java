package 구현;

import java.util.Scanner;

/**
 * BOJ_2961_S1_도영이가 만든 맛있는 음식
 * @author mingggkeee
 * 부분집합
 */
public class BOJ_2961 {
	
	static int N,S,B;	// N은 재료의 개수, S는 신맛, B는 쓴맛
	static int[] S1, B1;
	static int[] nums;
	static boolean[] isSelected;
	static int answer = Integer.MAX_VALUE;
	static int sSum, bSum;
	static int selectCount;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();	// 재료의 개수
		
		isSelected = new boolean[N+1];
		S1 = new int[N];
		B1 = new int[N];
		
		for(int i=0; i<N; i++) {
			S1[i] = sc.nextInt();
			B1[i] = sc.nextInt();
		}
		
		generateSubset(0);
		
		System.out.println(answer);
		sc.close();
	}
	
	public static void generateSubset(int cnt) {
		if(cnt==N) {
			selectCount = 0;
			sSum = 1;
			bSum = 0;
			for(int i=0; i<N; i++) {
				if(isSelected[i] == true) {
					sSum *= S1[i];
					bSum += B1[i];
					selectCount++;
				} 
			}
			
			if(selectCount>0) {
				answer = Math.min(Math.abs(sSum-bSum), answer);
			}
			return;
		}
		
		isSelected[cnt] = true;
		generateSubset(cnt+1);
		isSelected[cnt] = false;
		generateSubset(cnt+1);
	}

}
