package 구현;

import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ_18808_G3_스티커 붙이기
 * @author mingggkeee
 * 시뮬레이션 , 구현
 */

public class BOJ_18808 {
    static int N, M, K;
    static int[][] note = new int[42][42];
    static int R, C; 
    static int[][] paper = new int[12][12]; 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for(int k=0; k<K; k++) {
            st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            for (int i = 0; i < R; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < C; j++) {
                    paper[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            //붙이면 다음으로, 못붙이면 90도 돌리기.
            check :
            for (int rot = 0; rot < 4; rot++) {
                for (int r = 0; r <= N - R; r++) { // n = 7, r = 5인 상황 상상가능.
                    for (int c = 0; c <= M - C; c++) {
                        if (postable(r, c)) {
                            break check;
                        }
                    }
                }
                rotate(); // rot = 3 일때 rotate 실행시키면 안되지만 복잡도 그렇게 크게 증가 x
            }
        }
        int count = 0;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                count += note[r][c];
            }
        }
        System.out.println(count);
    }

    static boolean postable(int r, int c) {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (note[r + i][c + j] == 1 && paper[i][j] == 1) {
                    return false;
                }
            }
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (paper[i][j] == 1) {
                    note[r + i][c + j] = 1;
                }
            }
        }
        return true;
    }

    static void rotate() {
        int[][] temp = new int[12][12];

        for (int i = 0; i < R; i++) System.arraycopy(paper[i], 0, temp[i], 0, C);

        for (int i = 0; i < C; i++) {
            for (int j = 0; j < R; j++) {
                paper[i][j] = temp[R - 1 - j][i];
            }
        }
        int tmp = R;
        R = C;
        C = tmp;
    }
}
