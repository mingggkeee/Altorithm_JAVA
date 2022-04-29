package 분리집합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BOJ_24391_G4_귀찮은 해강이
 * @Author mingggkeee
 * @Date 2022. 4. 29.
 * @Category : 분리집합
 */

public class BOJ_24391 {

	static void makeSet() {
		for(int i=0; i<=N; i++){
			parents[i] = i;
		}
	}
	
	static int find(int a) {
		if(a == parents[a]) {
			return a;
		}
		
		return parents[a] = find(parents[a]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) {
			return false;
		}
		
		parents[bRoot] = aRoot;
		return true;
	}
	
	static int N, M;
	static int count;
	static int[] parents;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		parents = new int[N+1];
		
		makeSet();
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			union(a, b);
		}
		
		st = new StringTokenizer(br.readLine());
		
		Queue<Integer> queue = new LinkedList<>();
		while(st.hasMoreTokens()) {
			queue.add(Integer.parseInt(st.nextToken()));
		}
		
		int a = queue.poll();
		int b = 0;
		
		while(!queue.isEmpty()) {
			
			b = a;
			a = queue.poll();
			
			if(find(a) != find(b)) {
				count++;
			}
			
		}
		
		System.out.println(count);
		
		
	}
	
}
