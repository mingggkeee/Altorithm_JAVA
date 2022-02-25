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
 * BOJ_14284_G5_간선 이어가기2
 * @author mingggkeee
 * 다익스트라
 */

public class BOJ_14284 {
	
	static class Node implements Comparable<Node>{
		int end;
		long weight;
		
		public Node(int end, long weight) {
			super();
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return Long.compare(this.weight, o.weight);
		}
		
	}
	
	static int V,E;
	static long[] distance;
	static boolean[] isVisited;
	static List<ArrayList<Node>> list;
	static int startNode, endNode;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		list = new ArrayList<>();
		distance = new long[V+1];
		isVisited = new boolean[V+1];
		
		for(int i=0; i<=V; i++) {
			list.add(new ArrayList<>());
		}
		
		Arrays.fill(distance, Long.MAX_VALUE);
		
		for(int i=0; i<E ;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			list.get(start).add(new Node(end,weight));
			list.get(end).add(new Node(start,weight));
			
		}
		
		st = new StringTokenizer(br.readLine());
		startNode = Integer.parseInt(st.nextToken());
		endNode = Integer.parseInt(st.nextToken());
		
		dijsktra();
		
		
	}
	
	static void dijsktra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		distance[startNode] = 0;
		
		pq.offer(new Node(startNode,0));
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			int current = now.end;
			
			if(current == endNode) {
				System.out.println(now.weight);
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
		
	}

}
