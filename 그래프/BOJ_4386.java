package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * BOJ_4386_G4_별자리 만들기
 * @Author mingggkeee
 * @Date 2022. 4. 15.
 * @Category : MST(크루스칼)
 */

public class BOJ_4386 {
	
	static class Point{
		int no;
		double x;
		double y;
		
		public Point(int no, double x, double y) {
			this.no = no;
			this.x = x;
			this.y = y;
		}
	}
	
	static class Edge implements Comparable<Edge>{
		int start;
		int end;
		double weight;
		
		public Edge(int start, int end, double weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			
			if(this.weight < o.weight) {
				return -1;
			}
			
			return 1;
		}
		
		
	}

	static int n;
	static int[] parents;
	static double answer;
	static List<Edge> list;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		Point[] points = new Point[n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());
			
			points[i] = new Point(i, x, y);
		}
		
		list = new ArrayList<>();
		for(int i=0; i<n; i++) {
			for(int j=i+1; j<n; j++) {
				double weight = dist(points[i], points[j]);
				
				list.add(new Edge(points[i].no, points[j].no, weight));
			}
		}
		
		Collections.sort(list);
		
		makeSet();
		
		for(int i=0; i<list.size(); i++) {
			Edge edge = list.get(i);
			
			if(findSet(edge.start) != findSet(edge.end)) {
				answer += edge.weight;
				union(edge.start, edge.end);
			}
		}
		
		System.out.printf("%.2f",answer);
		
	}
	
	static double dist(Point po1, Point po2) {
		return Math.sqrt(Math.pow(po1.x-po2.x, 2) + Math.pow(po1.y-po2.y, 2));
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
	
	static int findSet(int a) {
		if(a == parents[a]) {
			return a;
		}
		
		return parents[a] = findSet(parents[a]);
	}
	
	static void makeSet() {
		parents = new int[n];
		for(int i=0; i<n; i++) {
			parents[i] = i;
		}
	}
}
