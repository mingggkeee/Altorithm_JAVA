package DFS와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BOJ_1113_G1_수영장 만들기
 * @Author mingggkeee
 * @Date 2022. 6. 19.
 * @Category : BFS
 */

public class BOJ_1113 {
	
	static class Pool{
		int r;
		int c;
		
		public Pool(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	static int N, M, answer, maxH;
	static int[][] map;
	static Queue<Pool> queue;
	static boolean check;
	static boolean[][] isVisited;
	static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
	
	static int calc(int val) {
		int size = 1;
		while(!queue.isEmpty()) {
			Pool now = queue.poll();
			
			for(int i=0; i<4; i++) {
				int nr = now.r + dir[i][0];
				int nc = now.c + dir[i][1];
				
				if(nr < 0 || nc < 0 || nr > N-1 || nc > M-1) {
					check = true;
					continue;
				}
				else if(!isVisited[nr][nc] && map[nr][nc] < val) {
					isVisited[nr][nc] = true;
					queue.add(new Pool(nr, nc));
					size++;
				}
			}
		}
		if(check) {
			size = 0;
		}
		return size;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		maxH = -987654321;
		map = new int[N][M];
		queue = new LinkedList<>();
		
		for(int r=0; r<N; r++) {
			String input = br.readLine();
			for(int c=0; c<M; c++) {
				map[r][c] = input.charAt(c)-'0';
				if(maxH < map[r][c])
					maxH = map[r][c];
			}
		}
		
		for(int t=2; t<=maxH; t++) {
			isVisited = new boolean[N][M];
			for(int r=1; r<N-1; r++) {
				for(int c=1; c<M-1; c++) {
					check = false;
					if(map[r][c] < t && !isVisited[r][c]) {
						isVisited[r][c] = true;
						queue.add(new Pool(r, c));
						answer += calc(t);
					}
				}
			}
		}
		
		System.out.println(answer);
	}
	
}
