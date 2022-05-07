package 스택과큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * BOJ_14464_G1_소가 길을 건너간 이유 4
 * @Author mingggkeee
 * @Date 2022. 5. 7.
 * @Category : 그리디, 우선순위 큐
 */
public class BOJ_14464 {
	
	static class Cow implements Comparable<Cow>{
		int start;
		int end;
		
		public Cow(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Cow o) {
			if(start == o.start) {
				return end-o.end;
			}
			return start-o.start;
		}
	}
	
	static int C, N;
	static Cow[] cows;
	static int[] chickens;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		chickens = new int[C];
		
		for(int i=0; i<C; i++) {
			chickens[i] = Integer.parseInt(br.readLine());
		}
		
		cows = new Cow[N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			cows[i] = new Cow(start, end);
		}
		
		Arrays.sort(cows);
		Arrays.sort(chickens);
		
		System.out.println(calc(chickens, cows));
		
	}
	
	static int calc(int[] chickens, Cow[] cows) {
		
		int count = 0;
		int idx = 0;
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for(int i=0; i<C; i++) {
			
			while(idx < N && cows[idx].start <= chickens[i]) {
				pq.add(cows[idx++].end);
			}
			
			while(!pq.isEmpty() && pq.peek() < chickens[i]) {
				pq.poll();
			}
			
			if(!pq.isEmpty()) {
				count++;
				pq.poll();
			}
			
		}
		
		return count;
	}

}
