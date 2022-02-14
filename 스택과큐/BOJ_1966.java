package 스택과큐;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * BOJ_1966_S3_프린터큐
 * @author mingggkeee
 *
 */
public class BOJ_1966 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i=0; i<T; i++) {
			int N = sc.nextInt(); // 문서의 개수
			int M = sc.nextInt(); // 궁금한 순서 (0부터 시작) 즉 0이 첫번째
			Integer[] arr = new Integer[N]; // 중요도 저장 배열
			Queue<int[]> queue = new LinkedList<int[]>();
			for(int j=0; j<N; j++) {
				int[] arr2 = new int[2];
				arr2[0] = sc.nextInt(); // 중요도
				arr2[1] = j; // 순서
				arr[j] = arr2[0];	// 중요도 저장
				queue.offer(arr2);	
			}
			
			Arrays.sort(arr, Collections.reverseOrder());
			int cnt = 0;
			int answer = 1;
			while(!queue.isEmpty()) {
				if(queue.peek()[0] == arr[cnt]) {
					if(queue.peek()[1] == M) {
						queue.poll();
						System.out.println(answer);
						break;
					} else {
						queue.poll();
						cnt++;
						answer++;
					}
				} else {
					int[] arr3 = queue.poll();
					queue.offer(arr3);
				}
			}
			
		}
		
		sc.close();
	}
	
}
