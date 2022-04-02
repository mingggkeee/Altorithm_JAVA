package 백트래킹;

import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ_1799_G1_비숍
 * @author mingggkeee
 * 백트래킹
 */

public class BOJ_1799 {
    static int N;
    static int map[][];
    static boolean isVisited[][];
    static boolean isBlacked[][];
    static int result[];

    static int[] dr = {-1, -1};
    static int[] dc = {1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        isVisited = new boolean[N][N];
        isBlacked = new boolean[N][N];
        // 0은 검정칸, 1은 흰칸의 max값
        result = new int[2];

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());

            for (int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());

                isBlacked[r][c] = (r % 2 != 0 && c % 2 != 0) || r % 2 == 0 && c % 2 == 0;
            }
        }

        //검정칸 탐색
        search(-1, true, 0);
        //흰칸 탐색
        search(-1, false, 0);

        System.out.println(result[0] + result[1]);
    }

    private static void search(int index, boolean isSearchBlack, int count) {
        for (int i = index + 1; i < N * N; i++) {
            int r = i / N;
            int c = i % N;

            if (isBlacked[r][c] != isSearchBlack || map[r][c] == 0 || !isValid(r, c)) {
                continue;
            }

            isVisited[r][c] = true;
            search(i, isSearchBlack, count + 1);
            isVisited[r][c] = false;
        }

        int resultIndex = isSearchBlack ? 0 : 1;
        result[resultIndex] = Math.max(result[resultIndex], count);
    }

    private static boolean isValid(int x, int y) {
        // 좌측 하단부터 우측 하단순으로 탐색하므로 윗 대각선의 비숍만 체크한다.
        for (int i = 0; i < 2; i++) {
            int nr = x;
            int nc = y;

            while (true) {
                if (nr >= N || nc >= N || nr < 0 || nc < 0) {
                    break;
                }
                if (isVisited[nr][nc]) {
                    return false;
                }

                nr += dr[i];
                nc += dc[i];
            }
        }

        return true;
    }
}
