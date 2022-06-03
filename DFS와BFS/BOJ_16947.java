package DFS와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BOJ_16947_G3_서울 지하철 2호선
 * @Author mingggkeee
 * @Date 2022. 6. 3.
 * @Category : BFS, DFS
 */
public class BOJ_16947 {
	
	static int N;
	static int[] distance;
	static boolean[] isVisited;
	static boolean isCycle;
	static Queue<Integer> queue = new LinkedList<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		isVisited = new boolean[N+1];
		distance = new int[N+1];
		Arrays.fill(distance, -1);
		
		List<Integer> subway[] = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			subway[i] = new ArrayList<>();
		}
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			subway[n1].add(n2);
			subway[n2].add(n1);
		}
		
		dfs(subway, 0, 1);
		
		bfs(subway);
		
		for(int i=1; i<=N; i++) {
			System.out.print(distance[i]+" ");
		}
		
		
	}
	
	static void bfs(List<Integer>[] subway) {
		int count = 1;
		while(!queue.isEmpty()) {
			int len = queue.size();
			for(int i=0; i<len; i++) {
				int temp = queue.poll();
				for(int d : subway[temp]) {
					if(distance[d] != -1)
						continue;
					distance[d] = count;
					queue.add(d);
				}
			}
			count++;
		}
	}
	
	static void dfs(List<Integer>[] subway, int pre, int now) {
		isVisited[now] = true;
		
		for(int i : subway[now]) {
			if(isVisited[i] && i != pre) {
				isCycle = true;
				distance[i] = 0;
				queue.add(i);
				break;
			} else if(!isVisited[i]) {
				dfs(subway, now, i);
				if(isCycle) {
					if(distance[i] == 0) {
						isCycle = false;
					} else {
						distance[i] = 0;
						queue.add(i);
					}
					return;
				}
			}
		}
	}

}
