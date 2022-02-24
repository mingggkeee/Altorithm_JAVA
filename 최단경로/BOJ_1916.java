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
 * BOJ_1916_G5_최소비용 구하기
 * @author mingggkeee
 * 다익스트라
 */

public class BOJ_1916 {
	
	static class Node implements Comparable<Node>{
		int end;
		int weight;
		
		public Node(int end, int weight) {
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.weight-o.weight;
		}
		
		
	}
	
	
	static int V, E;	// 정점의 수와 간선의 개수
	static List<ArrayList<Node>> list;	// 인접리스트
	static int[] distance;				// 시작점에서 각 정점으로 가는 최단 거리
	static boolean[] isVisited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		V = Integer.parseInt(br.readLine());
		E = Integer.parseInt(br.readLine());
		
		list = new ArrayList<>();
		distance = new int[V+1];
		isVisited = new boolean[V+1];
		
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		for(int i=0; i<=V; i++) {
			list.add(new ArrayList<>());
		}
		
		// 인접리스트 구현부
		for(int i=0; i<E ; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			list.get(start).add(new Node(end,weight));
		}
		
		st = new StringTokenizer(br.readLine());
		int startNode = Integer.parseInt(st.nextToken());
		int endNode = Integer.parseInt(st.nextToken());
		
		System.out.println(dijkstra(startNode, endNode));
		
	}
	
	static int dijkstra(int start, int end) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		pq.offer(new Node(start, 0));
		distance[start] = 0;
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			int current = now.end;
			
			if(!isVisited[current]) {
				isVisited[current] = true;
				
				for(Node node : list.get(current)) {
					if(!isVisited[node.end] && distance[node.end] > distance[current] + node.weight) {
						distance[node.end] = distance[current] + node.weight;
						pq.add(new Node(node.end, distance[node.end]));
					}
				}
				
			}
		}
		
		return distance[end];
		
		
	}
	
}
