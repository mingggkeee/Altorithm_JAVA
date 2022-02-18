package 구현;

import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ_15863_G5_감시
 * @author mingggkeee
 * 시뮬, 구현
 * 1번 cctv는 한방향, 2번 cctv는 2방향인데 서로 반대, 3번 cctv는 서로 수직, 4번 cctv는 3방향, 5번 cctv는 4방향, 6번은 벽
 */
 
public class BOJ_15683 {
 
    static int R,C;
    static int cnt;
    static int min = Integer.MAX_VALUE;
    static CCTV[] cctv = new CCTV[8];
    static int[][] dir = {
        {},
        {1},
        {1,3},
        {0,1},
        {0,1,3},
        {0,1,2,3}
    };
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};
    static int[][] map;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        map = new int[R][C];
        
        for (int r = 0; r < R; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < C; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
                if(map[r][c] >= 1 && map[r][c] <= 5) {
                    cctv[cnt++] = new CCTV(r, c, map[r][c]);
                }
            }
        }
        
        solve(0, map);
        System.out.println(min);
    }
    
    static void solve(int idx, int[][] map) {
        if(idx == cnt) {
            int res = 0;
            for (int r = 0; r < R; r++) {
                for (int c = 0; c < C; c++) {
                    if(map[r][c] == 0)
                        res++;
                }
            }
            min = Math.min(min, res);
            return ;
        }
        CCTV node = cctv[idx];
        
        // 왼쪽으로 4번 돌린다.
        for (int d = 0; d < 4; d++) {
            int[][] arr = copy(map);
            
            // 해당 CCTV가 감시하는 모든 방향에 대해 체크 한다.
            // 1,2,3,4  방향이 될 수 있다.
            for (int i = 0; i < dir[node.c].length; i++) {
                int nd = (dir[node.c][i]-d + 3) % 4;
                int nx = node.x;
                int ny = node.y;
                
                while(true) {
                    nx += dr[nd];
                    ny += dc[nd];
                    if(!isRange(nx, ny) || arr[nx][ny] == 6) break;
                    arr[nx][ny] = 7;
                }
            }
            solve(idx+1, arr);
        }
    }
    
    static boolean isRange(int x, int y) {
        if(x < 0 || x >= R || y < 0 || y >= C) return false;
        return true;
    }
    
    static int[][] copy(int[][] arr) {
        int[][] map = new int[R][C];
        
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                map[i][j] = arr[i][j];
            }
        }
        return map;
    }
}
 
class CCTV {
    int x;
    int y;    
    int c;    // cctv
    
    CCTV (int x, int y, int c) {
        this.x = x;
        this.y = y;
        this.c = c;
    }
}
