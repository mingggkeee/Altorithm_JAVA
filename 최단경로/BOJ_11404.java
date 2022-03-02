package 최단경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ_11404_G4_플로이드
 * @author mingggkeee
 * 플로이드-와샬
 */
public class BOJ_11404 {
	static int V, E;
	static int[][] distance;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		V = Integer.parseInt(br.readLine());
		E = Integer.parseInt(br.readLine());
		
		// 플로이드 초기 거리 테이블 초기화
		distance = new int[V+1][V+1];
		for(int i=1; i<=V; i++) {
			for(int j=1; j<=V; j++) {
				// 자기 자신으로 가는 길은 최소 비용이 0이다.
				if(i==j) {
					distance[i][j] = 0;
					continue;
				}
				// 자기 자신으로 가는 경우를 제외하고는 매우 큰 값(N개의 노드를 모두 거쳐서 가더라도 더 큰 값).
				distance[i][j] = 10000000;
			}
		}
		
		for(int i=0; i<E; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			// 가는 경로가 하나가 아닐 수 있다. 따라서 그 중 최소 비용을 저장해두면 된다.
			distance[start][end] = Math.min(distance[start][end], weight);
		}
		
		// 플로이드 워셜 알고리즘
		// 노드를 1개부터 N개까지 거쳐가는 경우를 모두 고려한다.
		for(int k=1; k<=V; k++) {
			// 노드 i에서 j로 가는 경우.
			for(int i=1; i<=V; i++) {
				for(int j=1; j<=V; j++) {
					// k번째 노드를 거쳐가는 비용이 기존 비용보다 더 작은 경우 갱신
					// 또는 연결이 안되어있던 경우(INF) 연결 비용 갱신.
					distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
				}
			}
		}
		
		// 출력
		for (int i = 1; i <= V; i++) {
			for (int j = 1; j <= V; j++) {
				// 연결이 안되어 있는 경우
				if (distance[i][j] >= 10000000) {
					System.out.print("0 ");
				} else {
					System.out.print(distance[i][j] + " ");
				}
			}
			System.out.println();
		}
	}

}
