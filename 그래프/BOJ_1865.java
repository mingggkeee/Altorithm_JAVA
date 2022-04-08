package 그래프;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * BOJ_1865_G3_웜홀
 * @Author mingggkeee
 * @Date 2022. 4. 8.
 * @Category : 벨만-포드
 */

public class BOJ_1865 {
	
	static class Road{
		int end;
		int weight;
		
		public Road(int end, int weight) {
			this.end = end;
			this.weight = weight;
		}
		
	}

	static int T;
	static int N, M, W;
	static int[] distance;
	static List<ArrayList<Road>> list;
	static final int INF = 987654321;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(br.readLine());
		
		while(T-->0) {
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			
			distance = new int[N+1];
			list = new ArrayList<>();
			for(int i=0; i<=N; i++) {
				list.add(new ArrayList<>());
			}
			
			for(int i=0; i<M+W; i++) {
				
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				
				// 일반도로는 양방향
				if(i < M) {
					list.get(start).add(new Road(end, weight));
					list.get(end).add(new Road(start, weight));
				} 
				// 웜홀은 단방향
				else {
					list.get(start).add(new Road(end, -weight));
				}
				
			}
			
			boolean isMinus = false;
			for(int i=1; i<=N; i++) {
				if(bellmanFord(i)) {
					isMinus = true;
					sb.append("YES\n");
					break;
				}
			}
			
			if(!isMinus) {
				sb.append("NO\n");
			}
			
			
		}
		
		System.out.println(sb.toString());
		
	}
	
	static boolean bellmanFord(int start) {
		
		Arrays.fill(distance, INF);
		distance[start] = 0;
		boolean update = false;
		
		for(int i=1; i<N; i++) {
			update = false;
			
			for(int j=1; j<=N; j++) {
				for(Road road : list.get(j)) {
					if(distance[j] != INF && distance[road.end]> distance[j] + road.weight) {
						distance[road.end]= distance[j] + road.weight;
						update = true;
					}
				}
			}
			
			if(!update) {
				break;
			}
		}
		
		if(update) {
            for (int i = 1; i <= N; i++) {
                for (Road road : list.get(i)) {
                    if (distance[i] != INF && distance[road.end] > distance[i] + road.weight) {
                        return true;
                    }
                }
            }
		}
		
		return false;
		
		
	}
	
}
