package MST;

import java.io.*;
import java.util.*;

/**
 * BOJ_1647_G4_도시 분할 계획
 * @author mingggkeee
 * MST, 크루스칼, 프림
 */

public class BOJ_1647{
	
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
	
	static int V, E;
	static PriorityQueue<Edge> pq;
	static int[] parents;
	
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
		int E = Integer.parseInt(st.nextToken());
	
		pq = new PriorityQueue<>();
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			pq.offer(new Edge(from, to, weight));
		}
		
		int count = 0;
		int result = 0;
		
		makeSet();
		
		while(count != V-2) {
			Edge now = pq.poll();
			
			if(union(now.start, now.end)) {
				count++;
				result += now.weight;
			}	
		}
		
		System.out.println(result);
	}
	
}



/*
public class BOJ_1647 {
	
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
			return this.weight - o.weight;
		}
	}
	
	static int N;
	static int[] parents;
	static Edge[] edgeList;
	
	// 단위 집합 생성
	public static void makeSet() {
		parents = new int[N+1];
		// 자신의 부모노드를 자신의 값으로 세팅
		for(int i=1; i<=N; i++) {
			parents[i] = i;
		}
		
	}
	
	// a의 집합 찾기 : a의 대표자 찾기
	public static int findSet(int a) {
		if(a==parents[a]) {
			return a;
		}
		
		return parents[a] = findSet(parents[a]);
	}
	
	// a,b 두 집합 합치기
	public static boolean union(int a, int b) {
		
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot == bRoot)
			return false;
		
		parents[bRoot] = aRoot;
		return true;
	}
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
	
		edgeList = new Edge[E*2];
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			edgeList[i] = new Edge(from, to, weight);
			edgeList[i+E] = new Edge(to, from, weight);
		}
		
		Arrays.sort(edgeList);
		
		makeSet();
		
		// 결과 비용 변수
		int result = 0;
		int cnt = 0;
		
		for(Edge edge : edgeList) {
			if(union(edge.start, edge.end)) {
				result += edge.weight;
				if(++cnt == N-2) {
					break;
				}
			}
		}
		
		System.out.println(result);
		
	}

}
*/
