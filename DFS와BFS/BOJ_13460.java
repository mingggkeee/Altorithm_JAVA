package DFS와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BOJ_13460_G1_구슬 탈출 2
 * @author mingggkeee
 * BFS
 */
public class BOJ_13460 {
	
	static class Location{
		int redR;
		int redC;
		int blueR;
		int blueC;
		int cnt;
		
		public Location(int redR, int redC, int blueR, int blueC, int cnt) {
			this.redR = redR;
			this.redC = redC;
			this.blueR = blueR;
			this.blueC = blueC;
			this.cnt = cnt;
		}
	}
	
	static int R, C;
	static char[][] map;
	static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
	static Queue<Location> queue = new LinkedList<>();
	static int endR, endC;
	static boolean[][][][] isVisited;
	static Location red, blue;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		isVisited = new boolean[R][C][R][C];
		
		for(int r=0; r<R; r++) {
			String input = br.readLine();
			for(int c=0; c<C; c++) {
				map[r][c] = input.charAt(c);
				if(map[r][c] == 'B') {
					blue = new Location(0,0,r,c,0);
				}
				else if(map[r][c] == 'R') {
					red = new Location(r, c, 0, 0, 0);
				}
				else if(map[r][c] == 'O') {
					endR = r;
					endC = c;
				}
			}
		}
		
		System.out.println(bfs());
		
	}
	
	static int bfs() {
		
		queue.offer(new Location(red.redR, red.redC, blue.blueR, blue.blueC, 1));
		isVisited[red.redR][red.redC][blue.blueR][blue.blueC] = true;
		
		while(!queue.isEmpty()) {
			
			Location now = queue.poll();
			
			int redR = now.redR;
			int redC = now.redC;
			int blueR = now.blueR;
			int blueC = now.blueC;
			
			if(now.cnt > 10) {
				return -1;
			}
			
			for(int i=0; i<4; i++) {
				int redNr = redR;
				int redNc = redC;
				int blueNr = blueR;
				int blueNc = blueC;
				
				boolean redHole = false;
				boolean blueHole = false;
				
				// 빨간 이동
				while(map[redNr + dir[i][0]][redNc + dir[i][1]] != '#') {
					redNr += dir[i][0];
					redNc += dir[i][1];
					
					// 구멍 만난 경우
					if(redNr == endR && redNc == endC) {
						redHole = true;
						break;
					}
				}
				
				// 파란 이동
				while(map[blueNr + dir[i][0]][blueNc + dir[i][1]] != '#') {
					blueNr += dir[i][0];
					blueNc += dir[i][1];
					
					// 구멍 만난경우
					if(blueNr == endR && blueNc == endC) {
						blueHole = true;
						break;
					}
				}
				
				if(blueHole) {
					continue;
				}
				
				if(redHole) {
					return now.cnt;
				}
				
				// 둘다 이동한 위치가 같을경우..
				if(redNr == blueNr && redNc == blueNc) {
					if(i == 0) { // 오른쪽으로 기울이기 
						// 더 작은 y값을 가지는 구슬이 뒤로 감 
						if(redC < blueC) redNc -= dir[i][1];
						else blueNc -= dir[i][1];
					} else if(i == 1) { // 왼쪽으로 기울이기 
						// 더 큰 y값을 가지는 구슬이 뒤로 감 
						if(redC > blueC) redNc -= dir[i][1]; 
						else blueNc -= dir[i][1];	
					} else if(i == 2) { // 아래쪽으로 기울이기 
						// 더 작은 x값을 가지는 구슬이 뒤로 감 
						if(redR < blueR) redNr -= dir[i][0]; 
						else blueNr -= dir[i][0];
					} else { // 위쪽으로 기울이기 
						// 더 큰 x값을 가지는 구슬이 뒤로 감 
						if(redR > blueR) redNr -= dir[i][0]; 
						else blueNr -= dir[i][0];
					}
				}
				
				// 두 구슬이 이동할 위치가 처음방문하는 것만 이동 할것
				if(!isVisited[redNr][redNc][blueNr][blueNc]) {
					isVisited[redNr][redNc][blueNr][blueNc] = true;
					queue.offer(new Location(redNr, redNc, blueNr, blueNc, now.cnt+1));
				}
				
				
			}
			
		}
		
		return -1;
		
	}

}
