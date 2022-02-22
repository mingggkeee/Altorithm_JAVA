package 그리디;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * BOJ_1715_G4_카드 정렬하기
 * @author mingggkeee
 * 그리디, 우선순위 큐
 */

public class BOJ_1715 {
	
	static int N;
	static PriorityQueue<Integer> pq = new PriorityQueue<>();
	static int answer;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		for(int i=0; i<N; i++) {
			pq.offer(sc.nextInt());
		}
		
		if(pq.size()==1) {
			System.out.println(0);
		} else {
			while(pq.size()!=1) {
				int a = pq.poll();
				int b = pq.poll();
				int temp = a+b;
				answer += temp;
				pq.offer(temp);
			}
			
			System.out.println(answer);
		}
		
		sc.close();
	}

}
