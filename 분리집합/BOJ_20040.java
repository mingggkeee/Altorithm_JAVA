package 분리집합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ_20040_G4_사이클 게임
 * @Author mingggkeee
 * @Date 2022. 4. 15.
 * @Category : 분리집합
 */
public class BOJ_20040 {

	static int n, m, cycle;
	static int[] parents;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		parents = new int[n];
		makeSet();
		
		for(int i=1; i<=m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(!union(a,b)) {
				cycle = i;
				break;
			}
		}
		
		System.out.println(cycle);
		
	}
	
	static void makeSet() {
		for(int i=0; i<n; i++) {
			parents[i] = i;
		}
	}
	
	static int findSet(int a) {
		if(a == parents[a]) {
			return a;
		}
		return parents[a]= findSet(parents[a]);
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
	
}
