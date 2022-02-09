package SWEA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * SWEA_1210_D4_Ladder1
 * @author mingggkeee
 * 구현
 */


public class SWEA_1210 {
	
	static int[][] map;
	// static int[] dx = {1, 0, 0};
	// static int[] dy = {0, -1, 1};
	// static int dir = 0;	// 방향
	static int answer;	// 정답 x좌표
	static int x,y;
	
	public static void ladder(int[][] map) {
		// 시작점
		for(int i=0; i<100; i++) {
			if(answer==2) {
				break;
			}
			// 사다리 시작점
			if(map[0][i] == 1) {
				boolean [][] isVisited = new boolean[100][100];
				x = 0;
				y = i;
				while(x<99) {
					// 오른쪽으로 갈 수 있을 때
					if(y+1<100 && map[x][y+1]==1 && !isVisited[x][y+1]) {
						isVisited[x][y+1] = true;
						// dir = 2;
						// x = x + dx[dir];
						y++;
					} else if(y-1>=0 && map[x][y-1]==1 && !isVisited[x][y-1]) { // 왼쪽으로 갈 수 있을 때
						isVisited[x][y-1] = true;
						// dir = 1;
						// x = x + dx[dir];
						y--;
					}else { // 아래로 가야할 때
						isVisited[x+1][y] = true;
						// dir = 0;
						x++;
						// y = y + dy[dir];
					}
				}
				
				// 2면 걸린거
				if(map[x][y] == 2) {
					answer = i;
				}
				
				
			} else {
				continue;
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st;
		map = new int[100][100];
		
		// 10번 입력받는다구했다.
		for(int i=0; i<10; i++) {
			int t = Integer.parseInt(br.readLine()); // 테케 번호 입력
			for(int r=0; r<100; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c=0; c<100; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			ladder(map);
			bw.write("#"+t+" "+answer+"\n");
		}
		
		bw.flush();
		bw.close();
		br.close();

	}
	

}
