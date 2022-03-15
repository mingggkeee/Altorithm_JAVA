package 백트래킹;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * BOJ_1038_G5_감소하는 수
 * @author mingggkeee
 * 백트래킹
 */

public class BOJ_1038 {
	
	static int N;
	static List<Long> list;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		list = new ArrayList<>();
		
		if(N<10) {
			System.out.println(N);
			System.exit(0);
		}
		
		if(N > 1022) {
			System.out.println(-1);
			System.exit(0);
		}
		
		for(int i = 0; i < 10; i++) {
            bp(i, 1);
        }
        Collections.sort(list);

        System.out.println(list.get(N));
		
		sc.close();
	}
	
    public static void bp(long num, int index) {
        if(index > 10) 
        	return;
        
        list.add(num);
        for(int i = 0; i < num % 10; i++) {
            bp((num * 10) + i, index + 1);
        }
    }

}
