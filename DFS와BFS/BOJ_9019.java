package DFS와BFS;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BOJ_9019_G4_DSLR
 * @author mingggkeee
 * BFS
 */

public class BOJ_9019 {
	
	static class DLSR{
		int num;
		String command;
		
		public DLSR(int num, String command) {
			this.num = num;
			this.command = command;
		}
	}

	static int T;
	static int start, target;
	static boolean[] isVisited;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken());
			target = Integer.parseInt(st.nextToken());
			System.out.println(bfs(start, target));
		}
		
	}
	
	static String bfs(int start, int target) {
		
		isVisited = new boolean[10000];
		
		Queue<DLSR> queue = new LinkedList<>();
		
		isVisited[start] = true;
		queue.offer(new DLSR(start, ""));
		
		while(!queue.isEmpty()) {
			
			DLSR now = queue.poll();
			
			if(now.num == target) {
				return now.command;
			}
			
			// D
			int d = now.num * 2 % 10000;
			if(!isVisited[d]) {
				isVisited[d] = true;
				queue.offer(new DLSR(d, now.command+"D"));
			}
			// S
			int s = (now.num==0) ? 9999 : now.num - 1;
			if(!isVisited[s]) {
				isVisited[s] = true;
				queue.offer(new DLSR(s, now.command+"S"));
			}
			// L
			int l = (now.num % 1000) * 10 + now.num/1000;
			if(!isVisited[l]) {
				isVisited[l] = true;
				queue.offer(new DLSR(l, now.command+"L"));
			}
			// R
			int r = (now.num % 10)*1000 + now.num/10;
			if(!isVisited[r]) {
				isVisited[r] = true;
				queue.offer(new DLSR(r, now.command+"R"));
			}
		}
		
		return "";
		
	}
	
}
