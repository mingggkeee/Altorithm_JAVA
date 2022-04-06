package 그래프;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BOJ_1922_G4_네트워크 연결
 * @author mingggkeee
 * MST, 크루스칼
 */

public class BOJ_1922 {
	
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
	
	static int N, M;
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
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		makeSet();
		edgeList = new Edge[M];
		
		StringTokenizer st;
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			edgeList[i] = new Edge(start,end,weight);
		}
		
		Arrays.sort(edgeList);
		
		int result = 0;
		int cnt = 0;
		for(Edge e : edgeList) {
			if(union(e.start,e.end)) {
				result += e.weight;
				if(++cnt == N-1) {
					break;
				}
			}
		}
		
		System.out.println(result);
		
	}

}
