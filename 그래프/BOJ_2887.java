package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * BOJ_2887_G1_행성터널
 * @Author mingggkeee
 * @Date 2022. 5. 5.
 * @Category : 크루스칼
 */

public class BOJ_2887 {

	static class Location {
		int num;
		int x;
		int y;
		int z;
		
		public Location(int num, int x, int y, int z) {
			this.num = num;
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
	
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
			return weight-o.weight;
		}
		
	}
	
	static int N;
	static int[] parent;
	static List<Edge> list;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());

		Location[] points = new Location[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());

			points[i] = new Location(i, x, y, z);
		}
		
		list = new ArrayList<>();
		
		Arrays.sort(points, (p1, p2) -> p1.x - p2.x);
		for (int i = 0; i < N - 1; i++) {
			int weight = Math.abs(points[i].x - points[i + 1].x);

			list.add(new Edge(points[i].num, points[i + 1].num, weight));
		}

		Arrays.sort(points, (p1, p2) -> p1.y - p2.y);
		for (int i = 0; i < N - 1; i++) {
			int weight = Math.abs(points[i].y - points[i + 1].y);

			list.add(new Edge(points[i].num, points[i + 1].num, weight));
		}

		Arrays.sort(points, (p1, p2) -> p1.z - p2.z);
		for (int i = 0; i < N - 1; i++) {
			int weight = Math.abs(points[i].z - points[i + 1].z);

			list.add(new Edge(points[i].num, points[i + 1].num, weight));
		}

		parent = new int[N];
		for (int i = 0; i < N; i++) {
			parent[i] = i;
		}

		Collections.sort(list);

		int answer = 0;
		for (int i = 0; i < list.size(); i++) {
			Edge edge = list.get(i);

			// 사이클이 발생하는 간선은 제외.
			if (find(edge.start) != find(edge.end)) {
				answer += edge.weight;
				union(edge.start, edge.end);
			}
		}
		
		System.out.println(answer);
		
	}
	
	static int find(int x) {
		if (x == parent[x]) {
			return x;
		}

		return parent[x] = find(parent[x]);
	}

	 static void union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x != y) {
			parent[y] = x;
		}
	}
	
}
