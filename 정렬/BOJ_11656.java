package 정렬;

import java.util.Arrays;
import java.util.Scanner;

/**
 * BOJ_11656_S4_접미사 배열
 * @author mingggkeee
 * 문자열, 정렬
 */

public class BOJ_11656 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		
		String[] arr = new String[input.length()];
		
		for(int i=0; i<input.length(); i++) {
			arr[i] = input.substring(i, input.length());
		}
		
		Arrays.sort(arr);
		
		for(int i=0; i<input.length(); i++) {
			System.out.println(arr[i]);
		}
		
		sc.close();
	}
}
