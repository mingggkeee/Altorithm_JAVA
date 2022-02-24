package 분리집합;

import java.util.*;
import java.io.*;

/**
 * BOJ_11724_S2_연결 요소의 개수
 * @author mingggkeee
 * BFS DFS 서로소
 */

// DFS, BFS 이용한 풀이
/*
public class BOJ_11724 {
	
	static int N, M;
	static int[][] map;
	static boolean[] isVisited;
	static int count;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		map = new int[N+1][N+1];
		isVisited = new boolean[N+1];
		
		for(int i=0; i<M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			map[a][b] = 1;
			map[b][a] = 1;
		}
		
		for(int r=1; r<=N; r++) {
			if(!isVisited[r]) {
				count++;
				// bfs(r);
				dfs(r);
			}
		}
		
		System.out.println(count);
		sc.close();
	}
	
	public static void dfs(int r) {
		isVisited[r] = true;
		
		for(int i=1; i<=N; i++) {
			if(map[r][i] == 1 && !isVisited[i]) {
				dfs(i);
			}
		}
		
	}
	
	
	public static void bfs(int r) {
		isVisited[r] = true;
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(r);
		
		while(!queue.isEmpty()) {
			int temp = queue.poll();
			
			for(int i=1; i<=N; i++) {
				if(map[temp][i] == 1 && !isVisited[i]) {
					isVisited[i] = true;
					queue.offer(i);
				}
			}
			
		}
		
	}
	

}
*/

// 서로소 이용한 풀이
public class BOJ_11724 {
	static int[] parent;
	static int N,M;
	
	static void makeSet() {
		parent = new int[N + 1];
		for (int i = 1; i <= N; i++)
			parent[i] = i;
	}
	
	static int find(int x) {
		if (parent[x] == x)
			return x;
		return parent[x] = find(parent[x]);
	}

	static void union(int a, int b) {
		int aRoot = find(parent[a]);
		int bRoot = find(parent[b]);
		if (aRoot == bRoot)
			return;
		parent[bRoot] = aRoot;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		makeSet();
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			union(a, b);
		}
		
		Set<Integer> set = new HashSet<>();
		for (int i = 1; i <= N; i++)
			set.add(find(parent[i]));
		System.out.println(set.size());
	}
}
