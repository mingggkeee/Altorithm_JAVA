package 재귀;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * BOJ_2447_S1_별 찍기 - 10
 * @author mingggkeee
 * 분할정복, 재귀
 */


 
public class BOJ_2447 {
	static char[][] map;
	static int N;
 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
 
		map = new char[N][N];
        
		makeStar(0, 0, N, false);
 
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(map[i][j]);
			}
			sb.append('\n');
		}
		System.out.print(sb);
	}
 
	static void makeStar(int r, int c, int N, boolean check) {
 
		// 공백칸일 경우
		if (check) {
			for (int i = r; i < r + N; i++) {
				for (int j = c; j < c + N; j++) {
					map[i][j] = ' ';
				}
			}
			return;
		}
 
		// 더이상 쪼갤 수 없는 블록일 때
		if (N == 1) {
			map[r][c] = '*';
			return;
		}
 
		/*
		   N=27 일 경우 한 블록의 사이즈는 9이고, 
		   N=9 일 경우 한 블록의 사이즈는 3이듯
		   해당 블록의 한 칸을 담을 변수를 의미 size
           
		   count는 별 출력 누적을 의미
		 */
 
		int size = N / 3;
		int count = 0;
		for (int i = r; i < r + N; i += size) {
			for (int j = c; j < c + N; j += size) {
				count++;
				if (count == 5) { // 공백 칸일 경우
					makeStar(i, j, size, true);
				} else {
					makeStar(i, j, size, false);
				}
			}
		}
	}
}