package 분리집합;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * BOJ_1976_G4_여행 가자
 * @author mingggkeee
 * 서로소, 분리집합
 */

public class BOJ_1976 {
	
	static int[][] map;
	static int N, M;
	static int[] parents;
	
	static void makeSet() {
		parents = new int[N+1];
		for(int i=1; i<=N; i++) {
			parents[i] = i;
		}
	}
	
	static int findSet(int a) {
		if(a==parents[a]) {
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
		
		parents[bRoot] = aRoot;
		return true;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		map = new int[N+1][N+1];
		
		makeSet();
		
		for(int r=1; r<=N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=1; c<=N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if(map[r][c] == 1) {
					union(r,c);
				}
			}
		}
		
		Set<Integer> set = new HashSet<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			int temp = Integer.parseInt(st.nextToken());
			set.add(findSet(temp));
		}
		
		if(set.size()==1) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
		
		
		
	}

}
