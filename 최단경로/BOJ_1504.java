package 최단경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * BOJ_1504_G4_특정한 최단 경로
 * @author mingggkeee
 * 다익스트라
 */

public class BOJ_1504 {
	
	static class Edge implements Comparable<Edge>{

		int end;
		int weight;
		
		public Edge(int end, int weight) {
			super();
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight-o.weight;
		}
		
	}
	static int V, E;
	static int[] distance;
	static boolean[] isVisited;
	static List<ArrayList<Edge>> list;
	static final int INF = 200000000;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		isVisited = new boolean[V+1];
		distance = new int[V+1];
		
		list = new ArrayList<>();
		for(int i=0; i<=V; i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			list.get(start).add(new Edge(end, weight));
			list.get(end).add(new Edge(start,weight));
		}
		
		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());
		
		int compare1 = 0;
		compare1 += dijkstra(1, v1);
		compare1 += dijkstra(v1, v2);
		compare1 += dijkstra(v2, V);
		
		int compare2 = 0;
		compare2 += dijkstra(1, v2);
		compare2 += dijkstra(v2, v1);
		compare2 += dijkstra(v1, V);
		
		int answer = (compare1 >= INF && compare2 >= INF) ? -1 : Math.min(compare1, compare2);
		
		System.out.println(answer);
	}
	
	static int dijkstra(int start, int end) {
		Arrays.fill(distance, INF);
		Arrays.fill(isVisited, false);
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(start, 0));
		distance[start] = 0;
		
		while(!pq.isEmpty()) {
			Edge now = pq.poll();
			int current = now.end;
			
			if(!isVisited[current]) {
				isVisited[current] = true;
				
				for(Edge edge : list.get(current)) {
					if(!isVisited[edge.end] && distance[edge.end] > distance[current] + edge.weight) {
						distance[edge.end] = distance[current] + edge.weight;
						pq.offer(new Edge(edge.end, distance[edge.end]));
					}
				}
			}
		}
		
		return distance[end];
		
	}

}
