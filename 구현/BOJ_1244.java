package 구현;

import java.util.Scanner;

/**
 * BOJ_1244_S3_스위치 켜고 끄기
 * @author mingggkeee
 * 구현
 */

public class BOJ_1244 {
	
	static int N;	// 스위치의 개수
	static int[] switches;	// 스위치 상태 저장 배열
	static int T;	// 학생 수
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		switches = new int[N+1];	// 1번부터시작
		
		for(int i=1; i<=N; i++) {
			switches[i] = sc.nextInt();
		}
		
		T = sc.nextInt();
		
		for(int t=0; t<T; t++) {
			int sex = sc.nextInt();	// 남학생은 1, 여학생은 2
			int num = sc.nextInt();
			
			if(sex == 1) {
				boy(num);
				
			} else {
				girl(num);
			}
			
		}
		
		// 출력
		if(N<=20) {
			for(int i=1; i<=N; i++) {
				System.out.print(switches[i] + " ");
			}
		} else if(N<=40) {
			for(int i=1; i<=20; i++) {
				System.out.print(switches[i] + " ");
			}
			System.out.println();
			for(int i=21; i<=N; i++) {
				System.out.print(switches[i]+" ");
			}
		} else if(N<=60) {
			for(int i=1; i<=20; i++) {
				System.out.print(switches[i] + " ");
			}
			System.out.println();
			for(int i=21; i<=40; i++) {
				System.out.print(switches[i]+" ");
			}
			System.out.println();
			for(int i=41; i<=N; i++) {
				System.out.print(switches[i]+" ");
			}
		} else if(N<=80) {
			for(int i=1; i<=20; i++) {
				System.out.print(switches[i] + " ");
			}
			System.out.println();
			for(int i=21; i<=40; i++) {
				System.out.print(switches[i]+" ");
			}
			System.out.println();
			for(int i=41; i<=60; i++) {
				System.out.print(switches[i]+" ");
			}
			System.out.println();
			for(int i=61; i<=N; i++) {
				System.out.print(switches[i]+" ");
			}
		} else {
			for(int i=1; i<=20; i++) {
				System.out.print(switches[i] + " ");
			}
			System.out.println();
			for(int i=21; i<=40; i++) {
				System.out.print(switches[i]+" ");
			}
			System.out.println();
			for(int i=41; i<=60; i++) {
				System.out.print(switches[i]+" ");
			}
			System.out.println();
			for(int i=61; i<=80; i++) {
				System.out.print(switches[i]+" ");
			}
			System.out.println();
			for(int i=81; i<=N; i++) {
				System.out.print(switches[i]+" ");
			}
		}
		
		sc.close();
	}
	
	public static void boy(int num) {
		int temp = num;
		while(temp<=N) {
			if(switches[temp] == 0) {
				switches[temp] = 1;
			} else {
				switches[temp] = 0;
			}
			temp += num;
		}
	}
	
	public static void girl(int num) {
		if(switches[num] == 0) {
			switches[num] = 1;
		} else {
			switches[num] = 0;
		}
		int temp = 1;
		int lr = num;
		int rr = num;
		while(true) {
			lr -= temp;
			rr += temp;
			if(lr < 1 || rr > N || switches[lr] != switches[rr]) {
				break;
			}
			
			if(switches[lr] == 0) {
				switches[lr] = 1;
				switches[rr] = 1;
			} else {
				switches[lr] = 0;
				switches[rr] = 0;
			}
		
		}
	}

}
