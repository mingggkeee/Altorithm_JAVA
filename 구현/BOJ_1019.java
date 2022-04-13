package 구현;

import java.util.Scanner;

/**
 * BOJ_1019_G1_책 페이지
 * @Author mingggkeee
 * @Date 2022. 4. 12.
 * @Category : 수학, 구현
 */

public class BOJ_1019 {

	static long[] numbers;
	static long start, end, mul;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		end = sc.nextLong();
		
		numbers = new long[10];
		mul = 1;
		
		start = 1;
		while(start<=end) {
			while(start%10 != 0 && start<=end) {
				calc(start);
				start++;
			}
			if(start>end) {
				break;
			}
			while(end%10 != 9 && start<=end) {
				calc(end);
				end--;
			}
			long diff = end/10 - start/10 + 1;
			for(int i=0; i<10; i++) {
				numbers[i]+=diff*mul;
			}
			mul *= 10;
			start /=10;
			end /=10;
		}
		
		for(int i=0; i<10; i++) {
			System.out.print(numbers[i]+" ");
		}
		
		sc.close();
		
	}
	
	static void calc(long num) {
		for(long i = num; i>0; i/=10) {
			String s = Long.toString(i);
			int tmp = s.charAt(s.length()-1)-'0';
			numbers[tmp]+=mul;
		}
	}
}
