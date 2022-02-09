package 구현;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * BOJ_2605_B2_줄 세우기
 * @author mingggkeee
 * 구현, 인덱싱, 동적배열 구현
 */

public class BOJ_2605 {
	
	public static void main(String[] args) {
		List<Integer> list = new LinkedList<Integer>();
		Scanner sc = new Scanner(System.in);
		int person = sc.nextInt(); // 학생수
		for(int i=1; i<=person; i++) {
			int idx = sc.nextInt(); // 들어갈 인덱스자리
			if(idx == 0) {
				list.add(i);
			} else {
				list.add(i-idx-1, i);
			}
			System.out.println();
		}
		
		for(int i : list) {
			System.out.print(i+" ");
		}
		
		sc.close();
	}

}
