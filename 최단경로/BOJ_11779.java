package 최단경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * BOJ_11779_G4_최소비용 구하기 2
 * @author mingggkeee
 * 다익스트라
 */

public class BOJ_11779 {
	
	static class Node implements Comparable<Node>{
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
	
	static int V,E;
	static List<ArrayList<Node>> list;
	static int[] distance;
	static boolean[] isVisited;
	static int cnt;
	static int parents[];
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		V = Integer.parseInt(br.readLine());
		E = Integer.parseInt(br.readLine());
		
		list = new ArrayList<>();
		distance = new int[V+1];
		isVisited = new boolean[V+1];
		parents = new int[V+1];
		
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		for(int i=0; i<=V; i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i=0; i<E; i++) {
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
		
		Stack<Integer> stack = new Stack<>();
		int current = endNode;
		
		while(current != startNode) {
			stack.push(current);
			cnt++;
			
			current = parents[current];
		}
		stack.push(current);
		cnt++;
		
		System.out.println(cnt);
		while(!stack.isEmpty()) {
			System.out.print(stack.pop()+ " ");
		}
		
		
	}
	
	static int dijkstra(int start, int end) {
		
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
						parents[node.end] = current; 
					}
				}
			}
			
			
		}
		
		return distance[end];
		
		
		
	}

}
