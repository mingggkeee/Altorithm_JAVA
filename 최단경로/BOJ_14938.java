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
 * BOJ_14938_G4_서강그라운드
 * @author mingggkeee
 * 다익스트라
 */


public class BOJ_14938 {
	
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
	
	static int V,M,E;	// 노드 개수, 수색 범위, 길의 개수
	static int[] items;
	static List<ArrayList<Node>> list;
	static boolean[] isVisited;
	static int[] distance;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		items = new int[V+1];
		list = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=V; i++) {
			items[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<=V; i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			list.get(start).add(new Node(end,weight));
			list.get(end).add(new Node(start,weight));
		}
		
		int answer = Integer.MIN_VALUE;
		
		for(int i=1; i<=V; i++) {
			int compare = dijsktra(i);
			
			answer = Math.max(answer, compare);
		}
		
		System.out.println(answer);
		
	}
	
	static int dijsktra(int start) {
		
		isVisited = new boolean[V+1];
		distance = new int[V+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		int temp = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>();
		distance[start] = 0;
		
		pq.offer(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			int current = now.end;
			
			if(!isVisited[current]) {
				isVisited[current] = true;
				
				for(Node node : list.get(current)) {
					
					if(!isVisited[node.end] && distance[current] + node.weight <= M && distance[node.end] > distance[current] + node.weight) {
						
						distance[node.end] = distance[current] + node.weight;
						pq.offer(new Node (node.end, distance[node.end]));
						
					}					
				}
				
			}
			
		}
		
		for(int i=1; i<=V; i++) {
			if(isVisited[i]) {
				temp += items[i];
			}
		}
		
		return temp;
	}

}
