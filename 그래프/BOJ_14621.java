package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * BOJ_14621_G3_나만 안되는 연애
 * @author mingggkeee
 * MST, 크루스칼
 */

public class BOJ_14621 {
	
	static class Edge implements Comparable<Edge>{
		
		int start;
		int end;
		int weight;
		
		public Edge(int start, int end, int weight) {
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
	static PriorityQueue<Edge> pq;
	static int[] parents;
	static char[] sex;
	
	static void makeSet() {
		parents = new int[V+1];
		
		for(int i=1; i<=V; i++) {
			parents[i] = i;
		}
	}
	
	static int findSet(int a) {
		if(a==parents[a]) {
			return a;
		}
		
		return parents[a] = findSet(parents[a]);
	}
	
	static boolean union(int a, int b) {
		
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		if(aRoot == bRoot) {
			return false;
		}
		
		parents[bRoot] = aRoot;
		return true;
	}
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		makeSet();
		sex = new char[V+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=V; i++) {
			sex[i] = st.nextToken().charAt(0);
		}
		
		pq = new PriorityQueue<>();
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			pq.offer(new Edge(start, end, weight));
		}
		
		int result = 0;
		int count = 0;
		
		while(!pq.isEmpty()) {
			
			if(count == V-1) {
				break;
			}
			
			Edge now = pq.poll();
			
			if(sex[now.start] != sex[now.end] && union(now.start,now.end)) {
				count++;
				result += now.weight;
			}
		}
		
		if(count == V-1) {
			System.out.println(result);
		} else {
			System.out.println(-1);
		}
		
	}

}
