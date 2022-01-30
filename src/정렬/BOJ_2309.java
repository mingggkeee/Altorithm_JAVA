package 정렬;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2309 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int []heights = new int[9];
		int sum = 0;
		int a=0;
		int b=0;
		
		for(int i=0; i<9; i++) {
			int num = sc.nextInt();
			heights[i] = num;
			sum += num;
		}
		
		Arrays.sort(heights);
		
		for(int i=0; i<9; i++) {
			for(int j=i+1; j<9; j++) {
				if(sum - heights[i] - heights[j] == 100) {
					a = i;
					b = j;
				}
			}
		}
		
		for(int i=0; i<9; i++) {
			if(i == a | i == b) {
				continue;
			}
			System.out.println(heights[i]);
		}
		
	}

}
