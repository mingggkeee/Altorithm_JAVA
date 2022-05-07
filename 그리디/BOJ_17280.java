package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * BOJ_17280_G1_카풀 매칭
 * @Author mingggkeee
 * @Date 2022. 5. 7.
 * @Category : 그리디, 우선순위 큐
 */
public class BOJ_17280 {
	
	static class Driver implements Comparable<Driver> {
		int start;
		int end;
		
		public Driver(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Driver o) {
			if(start == o.start) {
				return end-o.end;
			}
			
			return start-o.start;
		}
		
		
	}
	

	static int answer, T, N, M;
	static int[] passengers;
	static Driver[] drivers;
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			passengers = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				passengers[i] = Integer.parseInt(st.nextToken());
			}
			
			drivers = new Driver[M];
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				
				drivers[i] = new Driver(start, end);
			}
			
			Arrays.sort(passengers);
			Arrays.sort(drivers);
			
			System.out.println(calc(passengers, drivers));
		}
	}
	
	static int calc(int[] passengers, Driver[] drivers) {
		answer = 0;
		int idx = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for(int i=0; i<N; i++) {
			
			while(idx < M && drivers[idx].start <= passengers[i]) {
				pq.add(drivers[idx++].end);
			}
			
			while(!pq.isEmpty() && pq.peek() < passengers[i]) {
				pq.poll();
			}
			
			if(!pq.isEmpty()) {
				answer++;
				pq.poll();
			}
			
		}
		
		return answer;
	}
	
}
