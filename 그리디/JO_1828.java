package 그리디;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * JO_1828_냉장고(정올)
 * @author mingggkeee
 * 그리디
 */

public class JO_1828 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();	// 화학물질의 수(1<=N<=100)
	
		// 보관온도는 -270<=c<=10000
		
		PriorityQueue<int []> queue = new PriorityQueue<>(new Comparator<int []>() {

			@Override
			public int compare(int[] o1, int[] o2) {

				if(o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}
				return o1[1] - o2[1];
			}
			
		});
		
		for(int i=0; i<N; i++) {
			int num1 = sc.nextInt();	// 최소온도
			int num2 = sc.nextInt();	// 최고온도
			int [] temp = {num1, num2};
			queue.add(temp);
		}
		
		int answer = 1;
		int temp = queue.poll()[1];
		
		while(!queue.isEmpty()) {
			if(queue.peek()[0] <= temp) {
				queue.poll();
			} else {
				answer++;
				temp = queue.poll()[1];
			}
		}
		
		
		System.out.println(answer);
		
		
		sc.close();
	}
}
