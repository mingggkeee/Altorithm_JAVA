package MST;

import java.util.Arrays;
import java.util.Scanner;

/**
 * SWEA_3124_D4_최소 스패닝 트리
 * @author mingggkeee
 * 크루스칼
 */

public class SWEA_3124 {
	
	static int T;
	static int V, E;
	static int[] parents;
	static Edge[] edgeList;
	
	static class Edge implements Comparable<Edge> {

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
	
	public static void makeSet() {
		parents = new int[V+1];
		
		for(int i=1; i<=V; i++) {
			parents[i] = i;
		}
	}
	
	public static int findSet(int a) {
		if(a == parents[a]) {
			return a;
		}
		
		return parents[a] = findSet(parents[a]);
	}
	
	public static boolean union(int a, int b) {
		
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		if(aRoot == bRoot) {
			return false;
		}
		
		parents[bRoot] = aRoot;
		return true;
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			V = sc.nextInt();
			E = sc.nextInt();
			
			edgeList = new Edge[E];
			
			for(int i=0; i<E; i++) {
				int start = sc.nextInt();
				int end = sc.nextInt();
				int weight = sc.nextInt();
				edgeList[i] = new Edge(start, end, weight);
			}
			
			Arrays.sort(edgeList);
			
			makeSet();
			
			long answer = 0;
			int cnt = 0;
			
			for(Edge edge : edgeList) {
				if(union(edge.start, edge.end)) {
					answer += edge.weight;
					if(++cnt == V-1) {
						break;
					}
				}
			}
			
			System.out.println("#"+t+" "+answer);
		}
		
		
		sc.close();
		
	}

}

