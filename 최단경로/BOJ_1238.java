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
 * BOJ_1238_G3_파티
 * @author mingggkeee
 * 다익스트라
 */

public class BOJ_1238 {
	
	static class Node implements Comparable<Node> {
		int end;
		int weight;
		
		public Node(int end, int weight) {
			super();
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.weight - o.weight;
		}
		
	}
	
	static int V, E;
	static int endNode;
	static int[] distance;
	static boolean[] isVisited;
	static List<ArrayList<Node>> list;
	static int answer = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		endNode = Integer.parseInt(st.nextToken());
		
		list = new ArrayList<>();
		distance = new int[V+1];
		isVisited = new boolean[V+1];
		
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		for(int i=0; i<=V; i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			list.get(start).add(new Node (end,weight));
		}
		
		for(int i=1; i<=V; i++) {
			if(i==endNode) {
				continue;
			}
			dijkstra(i);
		}
		
		System.out.println(answer);
		
	}
	
	static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		int dist = 0;
		
		Arrays.fill(distance, Integer.MAX_VALUE);
		isVisited = new boolean[V+1];
		
		distance[start] = 0;
		pq.offer(new Node(start,0));
		
		while(!pq.isEmpty()) {
			
			Node now = pq.poll();
			int current = now.end;
			
			if(current == endNode) {
				dist = now.weight;
				break;
			}
			
			if(!isVisited[current]) {
				isVisited[current] = true;
				
				for(Node node : list.get(current)) {
					if(!isVisited[node.end] && distance[node.end] > distance[current] + node.weight) {
						distance[node.end] = distance[current] + node.weight;
						pq.offer(new Node(node.end, distance[node.end]));
					}
				}
				
			}
			
		}
		
		
		pq = new PriorityQueue<>();
		Arrays.fill(distance, Integer.MAX_VALUE);
		isVisited = new boolean[V+1];
		
		distance[endNode] = 0;
		pq.offer(new Node(endNode,0));
		
		while(!pq.isEmpty()) {
			
			Node now = pq.poll();
			int current = now.end;
			
			if(current == start) {
				dist += now.weight;
				break;
			}
			
			if(!isVisited[current]) {
				isVisited[current] = true;
				
				for(Node node : list.get(current)) {
					if(!isVisited[node.end] && distance[node.end] > distance[current] + node.weight) {
						distance[node.end] = distance[current] + node.weight;
						pq.offer(new Node(node.end, distance[node.end]));
					}
				}
				
			}
			
		}
		
		answer = Math.max(answer, dist);
		
	}

}
