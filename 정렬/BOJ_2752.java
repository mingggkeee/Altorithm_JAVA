package 정렬;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2752 {
	public static void main(String[] args) {
		int []nums = new int[3];
		Scanner sc = new Scanner(System.in);
		
		for(int i=0; i<3; i++) {
			nums[i] = sc.nextInt();
		}
		
		Arrays.sort(nums);
		
		for(int num : nums) {
			System.out.print(num+" ");
		}
		sc.close();
	}

}
