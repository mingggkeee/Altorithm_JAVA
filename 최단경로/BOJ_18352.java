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
 * BOJ_18352_S2_특정 거리의 도시 찾기
 * @author mingggkeee
 * 최단경로
 */

public class BOJ_18352 {
	
	static class Node implements Comparable<Node>{

		int end;
		int weight;
		
		public Node(int end, int weight) {

			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return this.weight-o.weight;
		}
		
	}
	
	static int V, E;
	static int target;
	static int start;
	static List<ArrayList<Node>> list;
	static int[] distance;
	static boolean[] isVisited;
	static List<Integer> answer;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		target = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(st.nextToken());
		
		distance = new int[V+1];
		list = new ArrayList<>();
		isVisited = new boolean[V+1];
		answer = new ArrayList<>();
		
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		for(int i=0; i<=V; i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			list.get(start).add(new Node(end, 1));
		}
		
		dijkstra(start);
		
		for(int i=1; i<=V; i++) {
			if(distance[i] == target) {
				answer.add(i);
			}
		}
		
		if(answer.size()==0) {
			System.out.println(-1);
		} else {
			for(int i : answer) {
				System.out.println(i);
			}
		}
		
	}
	
	static void dijkstra(int start) {
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		pq.offer(new Node(start,0));
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
		

		
	}

}
