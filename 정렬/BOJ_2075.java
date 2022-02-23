package 정렬;

import java.util.*;
import java.io.*;

/**
 * BOJ_2075_G5_N번째 큰 수
 * @author mingggkeee
 * 우선순위 큐, 정렬
 */

// 우선순위 큐
public class BOJ_2075 {
	
	static int N;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				pq.offer(Integer.parseInt(st.nextToken()));
			}
		}
		
		
		for(int i=0; i<N-1; i++) {
			pq.poll();
		}
		
		System.out.println(pq.poll());
		
		
	}

}


// 일반 풀이

/*
public class BOJ_2075 {
	
	static int N;
	static int[] numbers;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		numbers = new int[N*N];
		
		for(int i=0; i<N*N; i++) {
			numbers[i] = sc.nextInt();
		}
		
		Arrays.sort(numbers);
		
		System.out.println(numbers[N*N-N]);
		
		sc.close();
		
	}

}
*/
