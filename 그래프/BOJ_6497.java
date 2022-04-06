package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * BOJ_6497_G4_전력난
 * @author mingggkeee
 * MST, 크루스칼
 */

public class BOJ_6497 {
	
	static class Edge implements Comparable<Edge>{
		int start;
		int end;
		int weight;
		
		public Edge(int start, int end, int weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return this.weight-o.weight;
		}

	}
	
	static int V,E;
	static int[] parents;
	static PriorityQueue<Edge> pq;
	static int volt, min;
	
	static void makeSet() {
		parents = new int[V];
		
		for(int i=0; i<V; i++) {
			parents[i] = i;
		}
	}
	
	static int findSet(int a) {
		if(a==parents[a])
			return a;
		
		return parents[a] = findSet(parents[a]);
	}
	
	static boolean union(int a,int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot == bRoot)
			return false;
		
		parents[bRoot] = aRoot;
		return true;
	}
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			
			st = new StringTokenizer(br.readLine());
			
			volt = 0;
			min = 0;
			
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			if(V==0 && E==0) {
				break;
			}
			
			makeSet();
			pq = new PriorityQueue<>();
			
			for(int i=0; i<E; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				volt += weight;
				pq.offer(new Edge(start, end, weight));
			}
			
			int count = 0;
			
			while(count != V-1) {
				Edge now = pq.poll();
				
				if(union(now.start, now.end)) {
					count++;
					min += now.weight;
				}
				
			}
			
			System.out.println(volt-min);
			
		}
		
	}

}
