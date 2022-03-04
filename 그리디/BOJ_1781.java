package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * BOJ_1781_G2_컵라면
 * @author mingggkeee
 * 그리디, 우선순위 큐
 */

public class BOJ_1781 {
	
	static class Ramen implements Comparable<Ramen>{
		int deadline;
		int ramen;
		
		public Ramen(int deadline, int ramen) {
			super();
			this.deadline = deadline;
			this.ramen = ramen;
		}

		@Override
		public int compareTo(Ramen o) {
			
			if(this.deadline==o.deadline) {
				return o.ramen-this.ramen;
			}
			
			return this.deadline-o.deadline;
		}
		
		
	}
	
	static int N;
	static long answer;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		List<Ramen> list = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int deadline = Integer.parseInt(st.nextToken());
			int ramen = Integer.parseInt(st.nextToken());
			
			list.add(new Ramen(deadline, ramen));
		}
		
		Collections.sort(list);
		
		for(int i=0; i<N; i++) {
			int deadline = list.get(i).deadline;
			int ramen = list.get(i).ramen;
			pq.add(ramen);
			if(deadline<pq.size()) {
				pq.poll();
			}
			
		}
		
		
		while(!pq.isEmpty()) {
			answer += pq.poll();
		}
		
		System.out.println(answer);
		
	}

}
