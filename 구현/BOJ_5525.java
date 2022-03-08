package 구현;

import java.util.Scanner;

/**
 * BOJ_5525_S2_IOIOI
 * @author mingggkeee
 * 문자열, 구현, 슬라이딩 윈도우
 */

public class BOJ_5525 {
	
	static int N, M;
	static int count;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		sc.nextLine();
		char[] input = sc.nextLine().toCharArray();
		
		int incre = 0;
		
		for(int i=2; i<M; i++) {
			if(input[i] == 'I' && input[i-1]=='O' && input[i-2] == 'I') {
				incre++;
				i++;
			}
			else {
				incre = 0;
			}
			
			if(incre >= N) {
				count++;
			}
		}
		
		System.out.println(count);
		sc.close();
	}

}

/*
public class BOJ_5525 {
	
	static int N, M;
	static int count;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		sc.nextLine();
		String input = sc.nextLine();
		
		String compare = "I";
		
		for(int i=0; i<N; i++) {
			compare += "OI";
		}
		
		String compare2 = "";
		
		for(int i=0; i<compare.length(); i++) {
			compare2 += input.charAt(i);
		}
		
		if(compare.equals(compare2))
			count++;
		
		for(int i=compare.length(); i<M; i++) {
			compare2 = compare2.substring(1);
			compare2 += input.charAt(i);
			if(compare.equals(compare2))
				count++;
		}
		
		System.out.println(count);
		
		sc.close();
	}

}
*/
