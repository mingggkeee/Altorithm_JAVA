package 알고리즘frame;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class DijkstraTest2_PQ {
	
	static class Vertex implements Comparable<Vertex>{
		int no;
		int minDistance;
		
		public Vertex(int no, int minDistance) {
			this.no = no;
			this.minDistance = minDistance;
		}

		@Override
		public int compareTo(Vertex o) {
			// TODO Auto-generated method stub
			return this.minDistance - o.minDistance;
		}
		
		 
		
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int V = Integer.parseInt(br.readLine());
		
		int[][] adjMatrix = new int[V][V];
		int start = 0;	// 출발 정점
		
		StringTokenizer st;
		for(int r=0; r<V; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<V; c++) {
				adjMatrix[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] distance = new int[V];			// 출발지에서 자신으로 오는 최소비용
		boolean[] isVisited = new boolean[V];	// 최소비용 확정여부
		PriorityQueue<Vertex> pq = new PriorityQueue<>();
		
		
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0;	// 시작점 0으로
		pq.offer(new Vertex(start, distance[start]));
		
		
		while(!pq.isEmpty()) {
			// 단계1 : 최소비용이 확정되지 않은 정점중 최소비용의 정점 선택
			Vertex current = pq.poll();
			
			if(isVisited[current.no]) 
				continue;
			
			
			isVisited[current.no] = true;
			
			// 단계2 : 선택된 정점을 경유지로 하여 아직 최소비용이 확정되지 않은 다른정점의 최소비용을 고려
			for(int j=0; j<V; j++) {
				if(!isVisited[j] && adjMatrix[current.no][j] != 0 && distance[j] > distance[current.no] + adjMatrix[current.no][j]) {
					distance[j] = distance[current.no] + adjMatrix[current.no][j];
					pq.offer(new Vertex(j, distance[j]));
				}
			}
			
		}
		
		System.out.println(Arrays.toString(distance));
		
	}
}
