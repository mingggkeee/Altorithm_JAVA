package 분리집합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BOJ_16562_G3_친구비
 * @author mingggkeee
 * 분리집합
 */

public class BOJ_16562 {
	
	static int N;
	static int[] parents;
	static int M, money;
	static int answer;
	static int[] cost;
	static int[] rank;
	
	static void makeSet() {
		parents = new int[N+1];
		for(int i=1; i<=N; i++) {
			parents[i] = i;
		}
	}
	
	static int findSet(int a) {
		if(a == parents[a]) {
			return a;
		}
		
		return parents[a] = findSet(parents[a]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		if(aRoot == bRoot) {
			return false;
		}
		
		if(rank[aRoot] < rank[bRoot]) {
			parents[aRoot] = bRoot;
		} else {
			parents[bRoot] = aRoot;
			
			if(rank[aRoot] == rank[bRoot]) {
				rank[aRoot]++;
			}
		}
		return true;
		
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		money = Integer.parseInt(st.nextToken());
		
		makeSet();
		
		rank = new int[N+1];
		cost = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=1; i<=N; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			union(a,b);
		}
		
		
		int[] minCost = new int[N+1];
		Arrays.fill(minCost, Integer.MAX_VALUE);
		
		for(int i=1; i<=N; i++) {
			int group = findSet(i);
			minCost[group] = minCost[group] > cost[i] ? cost[i] : minCost[group];
		}
		
		for(int i=1; i<=N; i++) {
			if(minCost[i] != Integer.MAX_VALUE) {
				answer += minCost[i];
			}
		}
		
		if(answer > money) {
			System.out.println("Oh no");
		}
		else {
			System.out.println(answer);
		}
		
	}

}
