package 그리디;

import java.util.Scanner;

/**
 * BOJ_1541_S2_잃어버린 괄호
 * @author mingggkeee
 * 그리디, 파싱
 */ 

public class BOJ_1541 {
	public static void main(String[] args) {
		 
		Scanner sc = new Scanner(System.in);
 
		int sum = Integer.MAX_VALUE;	// 첫 토큰 여부를 확인하기 위해
		String[] sub = sc.nextLine().split("\\-");
		
 
		for(int i = 0; i < sub.length; i++) {
			int nums = 0;
 
			// 뺄셈으로 split해준 것들을 덧셈으로 또 분리하여 그 토큰들끼리 더해줘야함
			String[] add = sub[i].split("\\+");
			
			// 덧셈으로 나뉜 토큰들을 모두 더한다. 
			for(int j = 0; j < add.length; j++) {
				nums += Integer.parseInt(add[j]);
			}
			
			// 첫 번째토큰인 경우 
			if (sum == Integer.MAX_VALUE) {
				sum = nums;
			} else {
				sum -= nums;
			}
		}
		System.out.println(sum);
		
		sc.close();
	}
}
