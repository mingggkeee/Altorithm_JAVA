package 알고리즘frame;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


public class BellmanFordTest {
	
	static class Bus{
		int start;
		int end;
		int weight;
		public Bus(int start,int end, int weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
	}
	
	static int n,m;
	static Bus[] edgeList;
	static long[] distance;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		edgeList = new Bus[m];
		
		// 1. 출발 노드 설정
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			edgeList[i] = new Bus(start,end,weight);
		}
		
		// 2. 최단거리 테이블 초기화
		distance = new long[n+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		// 벨만포드 알고리즘 실행 (true: 음수 순환 존재, false: 음수 순환 존재x)
		if(bellmanford(1)) { // 음수 순환 존재하면 -1 출력 
			System.out.println(-1);
		}
		else {
			// 1번 노드를 제외한 다른 모든 노드로 가기 위한 최단거리 출력 
			for(int i=2; i<n+1; i++) {
				if(distance[i] == Integer.MAX_VALUE) {// 도달할 수 없으면 -1 
					System.out.println("-1");
				}
				else { // 최단 거리 출력 
					System.out.println(distance[i]);
				}
			}
		}
		
	}
	static boolean bellmanford(int start){
		
		distance[start] = 0;
		
		// n번 반복 (음수 간선 순환 체크안하려면 n-1번 반복)
		for(int i=0; i<n; i++) {
			// 매 반복마다 모든 간선을 확인 
			for(int j=0; j<m; j++) {
				int cur = edgeList[j].start;
				int next = edgeList[j].end;
				int cost = edgeList[j].weight;
						
				if(distance[edgeList[j].start] == Integer.MAX_VALUE) 
					continue;
				// 현재 간선을 거쳐서 다른 노드로 이동하는 거리가 짧은 경우 
				if(distance[next] > (distance[cur] + cost)) {
					distance[next] = distance[cur] + cost;
							
					// n번째 라운드에서 값이 갱신된다면 음수 순환 존재 
					if (i == n-1) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	
}
