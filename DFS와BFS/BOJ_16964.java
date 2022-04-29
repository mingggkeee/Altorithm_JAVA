package DFS와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ_16964_G4_DFS 스페셜 저지
 * @Author mingggkeee
 * @Date 2022. 4. 29.
 * @Category : DFS
 */

public class BOJ_16964 {
	
	static boolean[] isVisited;
	static int[][] map;
	static int N;
	static StringTokenizer st;
	static int now;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N+1][N+1];
		isVisited = new boolean[N+1];
		
		for(int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			
			map[n1][n2] = 1;
			map[n2][n1] = 1;
		}
		
		st = new StringTokenizer(br.readLine());
		now = Integer.parseInt(st.nextToken());
		boolean chk = dfs(1, 0);
		
		if(chk) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}
	
	static boolean dfs(int i, int cnt) {
		
		if(i != now) {
			System.out.println(i);
			return false;
		}
		
		isVisited[i] = true;
		
		if(cnt == N) {
			return true;
		}
		
		now = Integer.parseInt(st.nextToken());
		System.out.println(now);

		if(!isVisited[now] && map[i][now] == 1) {
				dfs(now, cnt+1);
		} else {
			return false;
		}

		
		return false;
	}
	
}
