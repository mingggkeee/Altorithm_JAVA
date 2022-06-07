package 구현;

import java.util.Scanner;

public class BOJ_5597 {
	
	public static void main(String[] args) {
		int[] student = new int[31];
		
		Scanner sc = new Scanner(System.in);
		
		for(int i=0; i<28; i++) {
			int num = sc.nextInt();
			student[num]++;
		}
		
		for(int i=1; i<=30; i++) {
			if(student[i] == 0) {
				System.out.println(i);
			}
		}
		
		sc.close();
	}

}
