package 알고리즘frame;

import java.util.Arrays;
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

// 무향 그래프
public class AdjMatrixTest {
	
	static int N;
	static int[][] adjMatrix;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();		// 정점 수
		int C = sc.nextInt();	// 간선 수
		
		adjMatrix = new int[N][N];
		
		for(int i=0; i<C; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			
			// 무향이므로 간선 하나로 양방향 처리
			adjMatrix[from][to] = 1;
			adjMatrix[to][from] = 1;
		}
		
		for(int[] row : adjMatrix) {
			System.out.println(Arrays.toString(row));
		}
		
		bfs(0);
		System.out.println("===============");
		dfs(0, new boolean[N]);
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
			for(int j=0; j<N; j++) {
				if(!isVisited[j] && adjMatrix[current][j] != 0) {
					isVisited[j] = true;
					queue.offer(j);
				}
				
			}
			
			
		}
	}
	
	public static void dfs(int start, boolean[] isVisited) {
		System.out.println(start);
		isVisited[start] = true;
		
		for(int i=0; i<adjMatrix[start].length; i++) {
			if(!isVisited[i] && adjMatrix[start][i] != 0) {
				dfs(i, isVisited);
			}
		}
		
	}
	
	
}
