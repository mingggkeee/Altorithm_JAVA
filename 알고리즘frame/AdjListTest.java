package 알고리즘frame;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
7
8
0 1
0 2	
1 3
1 4
2 4
3 5
4 5
5 6
 */

public class AdjListTest {
	static class Node{
		
		int vertex;
		Node link;
		
		public Node(int vertex, Node link) {
			this.vertex = vertex;
			this.link = link;
		}

		@Override
		public String toString() {
			return "Node [vertex=" + vertex + ", link=" + link + "]";
		}
	}
	
	
	static int N;
	static Node[] adjList;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();		// 정점 수
		int C = sc.nextInt();	// 간선 수
		
		adjList = new Node[N];	// 정점 수 크기 로 생성
		
		for(int i=0; i<C; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			
			// 무향이므로 간선 하나로 양방향 처리
			
			adjList[from] = new Node(to, adjList[from]);
			adjList[to] = new Node(from, adjList[to]);
		}
		
		
		for(Node head : adjList) {
			System.out.println(head.toString());
		}
		
		bfs(0);
//		System.out.println("==============");
//		dfs(0, new boolean[N]);
		sc.close();
	}
	
	public static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] isVisited = new boolean[N];
		
		queue.offer(start);
		isVisited[start] = true;
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			System.out.println(current);
			
			// current 정점의 인접정점을 처리
			for(Node temp=adjList[current]; temp !=null; temp = temp.link) {
				if(!isVisited[temp.vertex]) {
					isVisited[temp.vertex] = true;
					queue.offer(temp.vertex);
				}
				
			}
			
			
		}
	}
	
	public static void dfs(int start, boolean[] isVisited) {
		System.out.println(start);
		isVisited[start] = true;
		
		for(Node temp = adjList[start]; temp !=null; temp = temp.link) {
			if(!isVisited[temp.vertex]) {
				dfs(temp.vertex, isVisited);
			}
		}
		
	}
	
}
