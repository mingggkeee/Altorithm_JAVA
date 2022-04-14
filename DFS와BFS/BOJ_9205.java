package DFS와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BOJ_9205_S1_맥주 마시면서 걸어가기
 * @Author mingggkeee
 * @Date 2022. 4. 13.
 * @Category : BFS
 * 맨헤튼 거리 1000m 정점 이어주기
 */

public class BOJ_9205 {

	static class Location{
		int r;
		int c;
		
		public Location(int r, int c) {
			this.r = r;
			this.c = c;
		}
		
	}
	
	static int T, n;
	static boolean[][] isVisited;
	static String answer;
	static StringTokenizer st;
	static List<Location> list;
	static List<ArrayList<Integer>> graph;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			n = Integer.parseInt(br.readLine());
			
			list = new ArrayList<>();
			
			for(int i=0; i<n+2; i++) {
				st = new StringTokenizer(br.readLine());
				int n1 = Integer.parseInt(st.nextToken());
				int n2 = Integer.parseInt(st.nextToken());
				list.add(new Location(n1, n2));
			}
			
			graph = new ArrayList<>();
			for(int i=0; i<n+2; i++) {
				graph.add(new ArrayList<>());
			}
			
			for(int i=0; i<n+2; i++) {
				for(int j=i+1; j<n+2; j++) {
					if(Manhatten(list.get(i), list.get(j)) <= 1000) {
						graph.get(i).add(j);
						graph.get(j).add(i);
					}
				}
			}
			
			answer = bfs();
			
			System.out.println(answer);
			
		}
	}
	
	static int Manhatten(Location l1, Location l2) {
		return Math.abs(l1.r - l2.r) + Math.abs(l1.c - l2.c); 
	}
	
	static String bfs() {
		
		Queue<Integer> queue = new LinkedList<>();
		queue.add(0);
		
		boolean[] isVisited = new boolean[n+2];
		isVisited[0] = true;
		
		while(!queue.isEmpty()) {
			
			int now = queue.poll();
			
			if(now == n+1) {
				return "happy";
			}
			
			for(int nextLoc : graph.get(now)) {
				if(!isVisited[nextLoc]) {
					isVisited[nextLoc] = true;
					queue.offer(nextLoc);
				}
			}
			
		}
		
		return "sad";
	}
	
}
