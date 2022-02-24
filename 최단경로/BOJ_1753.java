package 최단경로;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1753 {
	
	static int V,E,start;
	
	static class Node implements Comparable<Node>{
		int v;
		int weight;
		
		public Node(int v, int weight) {
			this.v = v;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.weight-o.weight;
		}

	}
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		start = Integer.parseInt(br.readLine());
		
		List<Node> [] list = new ArrayList[V+1];
		
		for(int i=1; i<=V; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=1; i<=E; i++) {
			st = new StringTokenizer(br.readLine());
			list[Integer.parseInt(st.nextToken())].add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		

		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] isVisited = new boolean[V+1];
		Node[] distance = new Node[V+1];
		
		for(int i=1; i<=V; i++) {
			if(i==start) {
				distance[i] = new Node(i,0);
				pq.add(distance[i]);
			}
			else {
				distance[i] = new Node(i,Integer.MAX_VALUE);
			}
			
			
		}
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			for (Node next : list[node.v]) {
				// check되지 않았으면서, D[next.v]가 D[edge.v] + next.weight 보다 더 크다면 갱신
				if (!isVisited[next.v] && distance[next.v].weight > distance[node.v].weight + next.weight) {
					distance[next.v].weight = distance[node.v].weight + next.weight;
					// decrease key
					pq.remove(distance[next.v]);
					pq.add(distance[next.v]);
				}
			}
			isVisited[node.v] = true;
		}
		
		for(int i=1; i<=V; i++) {
			if(distance[i].weight == Integer.MAX_VALUE) {
				System.out.println("INF");
			}
			else {
				System.out.println(distance[i].weight);
			}
		}

	}
	

}
