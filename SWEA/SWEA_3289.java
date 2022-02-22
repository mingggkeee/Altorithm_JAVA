package SWEA;

import java.io.*;
import java.util.StringTokenizer;

/**
 * SWEA_3289_D4_서로소 집합
 * @author mingggkeee
 *
 */

public class SWEA_3289 {
	
	static int T, N, M;
	static int[] parents;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			bw.write("#"+t+" ");
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			makeSet();
			
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int command = Integer.parseInt(st.nextToken());
				
				// 0이면 합친다. 1이면 같은 집합 포함여부 확인
				if(command == 0) {
					int a = Integer.parseInt(st.nextToken());
					int b = Integer.parseInt(st.nextToken());
					union(a,b);
				} else {
					int a = Integer.parseInt(st.nextToken());
					int b = Integer.parseInt(st.nextToken());
					int com1 = findSet(a);
					int com2 = findSet(b);
					if(com1==com2) {
						bw.write("1");
					}else {
						bw.write("0");
					}
				}
			}
			
			bw.write("\n");
			
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	
	// 단위 집합 생성
	public static void makeSet() {
		parents = new int[N+1];
		// 자신의 부모노드를 자신의 값으로 세팅
		for(int i=1; i<=N; i++) {
			parents[i] = i;
		}
		
	}
	
	// a의 집합 찾기 : a의 대표자 찾기
	public static int findSet(int a) {
		if(a==parents[a]) {
			return a;
		}
		
		return parents[a] = findSet(parents[a]);
	}
	
	// a,b 두 집합 합치기
	public static boolean union(int a, int b) {
		
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot == bRoot)
			return false;
		
		parents[bRoot] = aRoot;
		return true;
	}
}
