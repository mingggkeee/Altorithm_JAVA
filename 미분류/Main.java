package 미분류;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] nums = new int[3];
		
		int max = 0;
		
		for(int i=0; i<3; i++) {
			nums[i] = sc.nextInt();
			if(nums[i] > max) {
				max = nums[i];
			}
		}
		
		int answer = 0;
		
		if(nums[0] == nums[1] && nums[1] == nums[2] && nums[0] == nums[2]) {
			answer = 10000 + (nums[0] * 1000);
		}
		
		if(nums[0] == nums[1] && nums[0] != nums[2]) {
			answer = 1000 + (nums[0]*100);
		}
		
		if(nums[0] == nums[2] && nums[0] != nums[1]) {
			answer = 1000 + (nums[0]*100);
		}
		
		if(nums[1] == nums[2] && nums[0] != nums[1]) {
			answer = 1000 + (nums[1]*100);
		}
		
		if(nums[0] != nums[1] && nums[1] != nums[2] && nums[0] != nums[2]) {
			answer = max*100;
		}
		
		System.out.println(answer);
		
		sc.close();
	}
	
}
