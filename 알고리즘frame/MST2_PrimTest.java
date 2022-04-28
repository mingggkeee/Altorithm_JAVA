package 알고리즘frame;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class MST2_PrimTest {
	static int N;
	static int[][] adjMatrix;
	static int [] minEdge;
	static boolean[] isVisited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		adjMatrix = new int[N][N];
		minEdge = new int[N];	// 타 정점에서 자신으로의 간선 비용중 최소 비용을 저장
		isVisited = new boolean[N];
		
		for(int r=0;r<N;r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0;c<N;c++) {
				adjMatrix[r][c] = Integer.parseInt(st.nextToken());
			}
			minEdge[r] = Integer.MAX_VALUE;	// 충분이 큰 값으로 최소값 초기화
		}
		
		primPQ();
		
	}
	
	static void prim() {
		int result = 0;	// MST 비용
		minEdge[0] = 0;	// 임의로 0번부터 시작
		
		// N개의 정점을 모두 연결
		for(int c=0;c<N;c++) {
			// 신장트리에 연결되지 않은 정점 중 가장 유리한 비용의 정점을 선택
			int min = Integer.MAX_VALUE;
			int minVertex = -1;
			
			for(int i=0; i<N; i++) {
				if(!isVisited[i] && min > minEdge[i]) {
					min = minEdge[i];
					minVertex = i;
				}
			}
			
			// 선택된 정점을 신장트리에 포함시킴
			isVisited[minVertex] = true;
			result += min;
			
			// 선택된 정점 기준으로 신장트리에 포함되지 않은 다른 정점으로의 간선 비용을 따져보고 최소값 갱신
			for(int i=0;i<N;i++) {
				if(!isVisited[i] && adjMatrix[minVertex][i] != 0 && minEdge[i] > adjMatrix[minVertex][i]) {
					minEdge[i] = adjMatrix[minVertex][i];
				}
			}
		}
		
		System.out.println(result);
	}
	
	static void primPQ() {
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		int result = 0;	// MST 비용
		pq.offer(new Node(0, 0));	// 임의로 0번부터 시작
		
		// 방문한 노드의 개수를 관리하기 위한 변수
		int nodeCnt = 0;
		
		// N개의 정점을 모두 연결
		while(!pq.isEmpty()) {
			// 최소 비용의 정점은 누구?
			Node minCostVertex = pq.poll();
			
			if(isVisited[minCostVertex.no]) {
				continue;
			}
			
			// 선택된 정점을 신장트리에 포함시킴
			isVisited[minCostVertex.no] = true;
			result += minCostVertex.cost;
			nodeCnt++;
			if(nodeCnt==N) {
				break;
			}
			
			// 선택된 정점 기준으로 신장트리에 포함되지 않은 다른 정점으로의 간선 비용을 따져보고 최소값 갱신
			for(int i=0;i<N;i++) {
				if(!isVisited[i] && adjMatrix[minCostVertex.no][i] != 0) {
					pq.offer(new Node(i, adjMatrix[minCostVertex.no][i]));
				}
			}
		}
		
		System.out.println(result);
	}
	
	static class Node implements Comparable<Node>{
		int no;		// 정점의 번호
		int cost;	// MST 그룹의 어떤 정점에서 이 노드 까지의 최소 비용
		public Node(int no, int cost) {
			this.no = no;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.cost-o.cost;
		}
	}

}
