package 문자열;

/**
 * BOJ_10808_B2_알파벳 개수
 * @Author mingggkeee
 * @Date 2022. 5. 28.
 * @Category : 구현, 문자열
 */

import java.util.Scanner;

public class BOJ_10808 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String input = sc.next();
		
		int[] counts = new int[26];
		
		for(int i=0; i<input.length(); i++) {
			int num = input.charAt(i)-'a';
			counts[num]++;
		}
		
		for(int i=0; i<26; i++) {
			System.out.print(counts[i]+" ");
		}
		
		sc.close();
	}

}
