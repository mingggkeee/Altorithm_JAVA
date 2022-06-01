package 스택과큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * BOJ_2109_G3_순회강연
 * @Author mingggkeee
 * @Date 2022. 5. 31.
 * @Category : PQ, 정렬, 그리디
 */

public class BOJ_2109 {
	
	static class Lecture implements Comparable<Lecture> {
		int pay;
		int limit;
		
		public Lecture(int pay, int limit) {
			this.pay = pay;
			this.limit = limit;
		}

		@Override
		public int compareTo(Lecture o) {
			if(o.pay > pay) {
				return 1;
			} else if(o.pay == pay) {
				if(o.limit < limit) {
					return 1;
				}
			}
			
			return -1;
		}
		
		
	}
	
	static int N, P, D;
	static boolean[] isVisited;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		PriorityQueue<Lecture> pq = new PriorityQueue<>();
		int maxLimit = 0;
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int pay = Integer.parseInt(st.nextToken());
			int limit = Integer.parseInt(st.nextToken());
			maxLimit = Math.max(limit, maxLimit);
			pq.add(new Lecture(pay, limit));
		}
		
		isVisited = new boolean[maxLimit+1];
		int sum = 0;
		while(!pq.isEmpty()) {
			Lecture now = pq.poll();
			for(int i=now.limit; i>=1; i--) {
				if(!isVisited[i]) {
					isVisited[i] = true;
					sum += now.pay;
					break;
				}
			}
		}
		
		System.out.println(sum);
	}
	
}
