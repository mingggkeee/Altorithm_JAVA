package 구현;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * BOJ_2635_S5_수 이어가기
 * @author mingggkeee
 * 구현, 완전탐색
 */

public class BOJ_2635 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int answer = Integer.MIN_VALUE;
		
		List<Integer> answerList = new ArrayList<>();
		
		for(int i=1; i<=N; i++) {
			int temp = N;
			int sub = i;
			List<Integer> list = new ArrayList<Integer>();
			list.add(temp);
			list.add(sub);
			while(true) {
				int temp2 = temp - sub;
				if(temp2 >=0) {
					list.add(temp2);
					temp = sub;
					sub = temp2;
				} else {
					break;
				}
				
			}
			
			if(answer < list.size()) {
				answerList = list;
				answer = list.size();
			}
			
		}
		
		System.out.println(answer);
		for(int i : answerList) {
			System.out.print(i+" ");
		}
		System.out.println();
		
		sc.close();
	}
	
}
