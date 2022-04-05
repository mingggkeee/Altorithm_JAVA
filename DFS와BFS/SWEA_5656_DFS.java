package DFS와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * SWEA_5656_벽돌 깨기
 * @author mingggkeee
 * DFS
 */

public class SWEA_5656_DFS {

	static int T, N, R, C;
	static int answer;
	static int[][] map;
	static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			
			map = new int[R][C];
			answer = R*C;
			for(int r=0; r<R; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c=0; c<C; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			permu(0);
			
			sb.append("#"+t+" "+answer+"\n");
		}
		
		System.out.println(sb.toString());
		
	}
	
	static void permu(int cnt) {
		if(cnt == N) {
			blockCount();
			return;
		}
		
		for(int i=0; i<C; i++) {
			
			int[][] temp = new int[R][C];
            for (int r = 0; r < R; r++) {
                if (C >= 0) System.arraycopy(map[r], 0, temp[r], 0, C);
            }
			findBlock(i);
			blockDown();
			permu(cnt+1);
            for (int r = 0; r < R; r++) {
                if (C >= 0) System.arraycopy(temp[r], 0, map[r], 0, C);
            }
		}
	}
	
    static void blockCount() {
    	int cnt = 0;
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				if(map[r][c] != 0) {
					cnt++;
				}
			}
		}
        answer = Math.min(answer, cnt);
    }
    
    static void blockDown() {
		for(int r=R-2; r>=0; r--) {
			for(int c=0; c<C; c++) {
				
				if(map[r][c] != 0) {
					int nr = r;
					int value = map[r][c];
					while(true) {
						nr++;
						if(nr>=R) {
							break;
						}
						if(map[nr][c] != 0) {
							break;
						}
						map[nr-1][c] = 0;
						map[nr][c] = value;		
					}
				}
			}
		}
    }
	
	static void findBlock(int c) {
		
		int r = 0;
		while(r < R && map[r][c] == 0) {
			r++;
		}
		if(r == R) {
			return;
		}
		
		crushBlock(r, c, map[r][c]-1);

	}
	
	static void crushBlock(int startR, int startC, int power) {
		
        map[startR][startC] = 0;
        while (power > 0) {
            for (int i = 0; i < 4; i++) {
                int nr = startR + dir[i][0] * power;
                int nc = startC + dir[i][1] * power;
                if (nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] != 0) {
                    if (map[nr][nc] > 1) {
                    	crushBlock(nr, nc, map[nr][nc] - 1);
                    }
                    map[nr][nc] = 0;
                }
 
            }
            power--;
        }

	}
	
	
}
