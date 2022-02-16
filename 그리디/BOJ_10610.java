package 그리디;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * BOJ_10610_S5_30
 * @author mingggkeee
 * 그리디, 문자열
 */
public class BOJ_10610 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		
		List<Integer> list = new ArrayList<>();
		int sum = 0;
		
		for(int i=0; i<input.length(); i++) {
			sum += input.charAt(i)-'0';
			list.add(input.charAt(i)-'0');
		}
		
		Collections.sort(list,Collections.reverseOrder());

		if(list.get(list.size()-1) == 0 && sum %3 ==0) {
			for(int i=0; i<list.size(); i++) {
				System.out.print(list.get(i));
			}
		} else {
			System.out.println(-1);
		}
		
		sc.close();
	}
	

}
