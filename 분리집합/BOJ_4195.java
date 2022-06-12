package 분리집합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * BOJ_4195_G2_친구 네트워크
 * @Author mingggkeee
 * @Date 2022. 6. 12.
 * @Category : 맵, 유니온파인드
 */

public class BOJ_4195 {
	
	static int[] parent;
	static int[] depth;
	
	static int find(int x) {
		if(x == parent[x]) {
			return x;
		}
		return parent[x] = find(parent[x]);
	}
	
	static int union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a!=b) {
			parent[b] = a;
			depth[a] += depth[b];
			
			depth[b] = 1;
		}
		
		return depth[a];
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		while(T-->0) {
			int N = Integer.parseInt(br.readLine());
			
			parent = new int[N*2];
			depth = new int[N*2];
			
			for(int i=0; i<N*2; i++) {
				parent[i] = i;
				depth[i] = 1;
			}
			
			int idx = 0;
			Map<String, Integer> map = new HashMap<String, Integer>();
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				String a = st.nextToken();
				String b = st.nextToken();
				
				if(!map.containsKey(a)) {
					map.put(a, idx++);
				}
				
				if(!map.containsKey(b)) {
					map.put(b, idx++);
				}
				
				System.out.println(union(map.get(a), map.get(b)));
			}
		}
	}
	
}
