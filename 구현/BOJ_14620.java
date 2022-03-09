package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * BOJ_14620_S2_꽃길
 * @author : mingggkeee
 * 구현
 */

public class BOJ_14620 {

    static int N;
    static int[][] map;
    static boolean[][] isVisited;
    static int[][] dir ={{1,0},{-1,0},{0,1},{0,-1}};
    static int answer = Integer.MAX_VALUE;
    static Flower[] selected = new Flower[3];
    static Flower[] candi;

    static class Flower{
        int r;
        int c;

        public Flower(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public String toString() {
            return "Flower{" +
                    "r=" + r +
                    ", c=" + c +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        map = new int[N][N];
        isVisited = new boolean[N][N];
        candi = new Flower[(N-2)*(N-2)];

        for(int r=0; r<N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++){
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        // 후보
        int idx = 0;
        for(int r=1; r<N-1; r++) {
            for (int c = 1; c < N - 1; c++) {
                candi[idx++] = new Flower(r, c);
            }
        }

        // 탐색
        combi(0,0);

        System.out.println(answer);

    }

    static void combi(int start, int cnt){
        if(cnt == 3){
            sum(selected);
            return;
        }

        for(int i=start; i<candi.length; i++){
            selected[cnt] = candi[i];
            combi(i+1, cnt+1);
        }
    }

    static boolean sum(Flower[] selected){

        isVisited = new boolean[N][N];
        int sum = 0;
        for(int k=0; k<3; k++){
            Flower now = selected[k];
            sum += map[now.r][now.c];
            isVisited[now.r][now.c] = true;
            for(int i=0; i<4; i++) {
                int nr = now.r + dir[i][0];
                int nc = now.c + dir[i][1];
                if (isVisited[nr][nc]) {
                    return false;
                }
                sum += map[nr][nc];
                isVisited[nr][nc] = true;
            }

        }
        answer = Math.min(sum, answer);

        return true;

    }
}
