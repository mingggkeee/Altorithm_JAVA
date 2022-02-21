package 정렬;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * BOJ_2108_S4_통계학
 * @author mingggkeee
 * 구현, 정렬
 */

public class BOJ_2108 {
	static int N;
	static int[] nums;
	static int[] check;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		nums = new int[N];
		check = new int[8001];
		
		for(int i=0; i<N; i++) {
			int temp = sc.nextInt();
			nums[i] = temp;
			check[temp+4000]++;
		}
		
		// 평균출력
		int sum = 0;
		for(int i : nums) {
			sum += i;
		}
		double round = (double) Math.round((double) sum / (double) N);
		
		System.out.println((int)round);
		
		// 중앙값 출력
		Arrays.sort(nums);
		int idx = N/2;
		System.out.println(nums[idx]);

		// 최빈값 출력
		List<Integer> list = new ArrayList<Integer>();
		int max = check[0];
		list.add(0 - 4000);
		for(int i=1; i<check.length; i++) {
			if(check[i] == max) {
				list.add(i-4000);
			} else if(check[i] > max) {
				max = check[i];
				list.clear();
				list.add(i - 4000);
			}
		}
		if(list.size() > 1) {
			Collections.sort(list);
			System.out.println(list.get(1));
		} else {
			System.out.println(list.get(0));
		}
		
		// 범위 출력
		System.out.println(nums[N-1] - nums[0]);
		
		sc.close();
	}

}
