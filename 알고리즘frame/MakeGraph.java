package 알고리즘frame;

import java.util.Arrays;
import java.util.StringTokenizer;

public class MakeGraph {
	
	// 정점의 개수
	static int v = 6;
	static String src = "(1, 2), (1, 5), (2, 5), (2, 4), (2, 3), (4, 3), (5, 4), (4, 6)";
	static String src2 = "(1, 2, 2), (1, 5, 7), (2, 5, 5), (2, 4, 4), (2, 3, 2), (4, 3, 1), (5, 4, 7), (4, 6, 3)";
	
	public static void main(String[] args) {
		// matrixBiDir();
		// matrixUniDir();
		// matrixUniDirWeight();
		// listBiDir();
		// listUniDir();
		listUniDirWeight();
	}
	
	private static void listBiDir() {
		LinkNode [] graph = new LinkNode[v+1];
		
		StringTokenizer st = new StringTokenizer(src,"(), ");
		
		while(st.hasMoreTokens()) {
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			// 이전 노드를 새로운 노드로 대체하면서 새로운 노드에 이전 노드의 값을 전달
			graph[a] = new LinkNode(b, graph[a]);
			graph[b] = new LinkNode(a, graph[b]);
			
		}
		
		for(LinkNode node : graph) {
			System.out.println(node);
		}
		
	}
	
	private static void listUniDir() {
		LinkNode [] graph = new LinkNode[v+1];
		
		StringTokenizer st = new StringTokenizer(src,"(), ");
		
		while(st.hasMoreTokens()) {
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			// 이전 노드를 새로운 노드로 대체하면서 새로운 노드에 이전 노드의 값을 전달
			graph[a] = new LinkNode(b, graph[a]);
			
		}
		
		for(LinkNode node : graph) {
			System.out.println(node);
		}
		
	}
	
	private static void listUniDirWeight() {
		LinkNode [] graph = new LinkNode[v+1];
		
		StringTokenizer st = new StringTokenizer(src2,"(), ");
		
		while(st.hasMoreTokens()) {
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			
			// 이전 노드를 새로운 노드로 대체하면서 새로운 노드에 이전 노드의 값을 전달
			graph[a] = new LinkNode(b, graph[a], value);
			
		}
		
		for(LinkNode node : graph) {
			System.out.println(node);
		}
		
		// 1번 노드에 연결된 자식의 가중치 합은?
		LinkNode node = graph[1];
		int sum = 0;
		
		while(node!=null) {
			sum += node.weight;
			System.out.print(node.val+", ");
			node = node.preSibling;
		}
		System.out.println();
		System.out.println(sum);
		
	}
	
	private static void matrixUniDirWeight() {
		int [][] graph = new int[v+1][v+1];
		StringTokenizer st = new StringTokenizer(src2,"(), ");
		
		while(st.hasMoreTokens()) {
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			
			graph[a][b] = value;
		}
		
		for(int [] row : graph) {
			System.out.println(Arrays.toString(row));
		}
		
		int sum = 0;
		// 2로 들어오는 가중치의 합은?
		for(int r=1; r<=6; r++) {
			if(graph[r][2] > 0) {
				sum+=graph[r][2];
			}
		}
		System.out.println(sum);
		
		// 2에서 나간 가중치의 합은?
		sum = 0;
		for(int c=1; c<=6; c++) {
			if(graph[2][c] > 0) {
				sum+=graph[2][c];
			}
		}
		System.out.println(sum);
	}
	
	private static void matrixBiDir() {
		// 인접행렬, 양방향 그래프
		boolean [][] graph = new boolean[v+1][v+1];
		StringTokenizer st = new StringTokenizer(src,"(), ");
		
		while(st.hasMoreTokens()) {
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			// 양방향 그래프 - 서로가 정보를 갖는다.
			graph[a][b] = true;
			graph[b][a] = true;
		}
		
		for(boolean [] row : graph) {
			System.out.println(Arrays.toString(row));
		}
	}
	
	private static void matrixUniDir() {
		// 인접행렬, 단방향 그래프
		boolean [][] graph = new boolean[v+1][v+1];
		StringTokenizer st = new StringTokenizer(src,"(), ");
		
		while(st.hasMoreTokens()) {
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			// 단방향 그래프 - 서로가 정보를 갖는다.
			graph[a][b] = true;
		}
		
		for(boolean [] row : graph) {
			System.out.println(Arrays.toString(row));
		}
	}
	
	static class LinkNode{
		int val;
		LinkNode preSibling;
		int weight;
		
		public LinkNode(int val, LinkNode preSibling) {
			this.val = val;
			this.preSibling = preSibling;
		}
		
		public LinkNode(int val, LinkNode preSibling, int weight) {
			this.val = val;
			this.preSibling = preSibling;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "LinkNode [val=" + val + ", preSibling=" + preSibling + ", weight=" + weight + "]";
		}
		
		
		
	}

}
