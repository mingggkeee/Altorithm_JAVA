package SWEA;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * SWEA_7465_D4_창용 마을 무리의 개수
 * @author mingggkeee
 * 서로소, 분리 집합
 */

public class SWEA_7465 {
	
	static int T;
	static int count;
	static int N, M;
	static int[] parents;
	static Set<Integer> list;
	
	public static void makeSet() {
		parents = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			parents[i] = i;
		}
	}
	
	public static int findSet(int a) {
		if(a==parents[a]) {
			return a;
		}
		
		return parents[a] = findSet(parents[a]);
	}
	
	public static boolean union(int a, int b) {
		
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
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			count = 1;
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			makeSet();
			
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				union(start, end);
			}
			
			// 여부 확인
			list = new HashSet<>();
			for(int i=1; i<=N; i++) {
				list.add(findSet(i));
			}
			
			
			bw.write("#"+t+" "+list.size()+"\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
}
