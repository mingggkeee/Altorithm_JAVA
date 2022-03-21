package 정렬;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * BOJ_1427_S5_소트인사이드
 * @author mingggkeee
 * 정렬
 */

public class BOJ_1427 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		String input = sc.nextLine();
		
		int[] nums = new int[input.length()];
		
		for(int i=0; i<input.length(); i++) {
			nums[i] = input.charAt(i)-'0';
		}
		
		Arrays.sort(nums);
		
		for(int i=nums.length-1; i>=0; i--) {
			sb.append(nums[i]);
		}
		
		System.out.println(sb.toString());
		
		sc.close();
	}
	
}
