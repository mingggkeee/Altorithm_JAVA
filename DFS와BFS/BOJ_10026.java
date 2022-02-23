package DFS와BFS;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

/**
 * BOJ_10026_G5_적록색약
 * @author mingggkeee
 * BFS
 */

public class BOJ_10026 {
	
	static int N;
	static char[][] map;
	static int count;
	static boolean [][] isVisited;
	static int[][] dir = {{0,1}, {0,-1}, {1,0}, {-1,0}};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		
		for(int r=0; r<N; r++) {
			String input = br.readLine();
			for(int c=0; c<N; c++) {
				map[r][c] = input.charAt(c);
			}
		}
		
		// 적록색약이 아닌사람
		count = 0;
		isVisited = new boolean[N][N];
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(!isVisited[r][c]) {
					count++;
					bfs(r,c);
				}
			}
		}
		System.out.print(count+" ");
		
		// 적록색약인 사람
		count = 0;
		isVisited = new boolean[N][N];
		// 빨간색을 초록색으로 바꾸기
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(map[r][c] == 'R') {
					map[r][c] = 'G';
				}
			}
		}
		
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(!isVisited[r][c]) {
					count++;
					bfs(r,c);
				}
			}
		}
		System.out.print(count+" ");
		System.out.println();
		
		br.close();
	}
	
	public static void bfs(int r, int c) {
		Queue<int []> queue = new LinkedList<int[]>();
		isVisited[r][c] = true;
		queue.offer(new int[] {r,c});
		char compare = map[r][c];
		
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			for(int i=0; i<4; i++) {
				int nr = now[0] + dir[i][0];
				int nc = now[1] + dir[i][1];
				
				if(nr>=0 && nc>=0 && nr<N && nc<N && map[nr][nc] == compare && !isVisited[nr][nc]) {
					isVisited[nr][nc] = true;
					queue.offer(new int[] {nr,nc});
				}
			}
			
			
		}
		
	}

}
