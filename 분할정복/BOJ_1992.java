package 분할정복;

import java.io.*;

/**
 * BOJ_1992_S1_쿼드트리
 * @author mingggkeee
 * 분할정복, 재귀
 */

public class BOJ_1992 {
	
	static int N;
	static int[][] map;
	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException{
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		
		for(int r=0; r<N; r++) {
			String input = br.readLine();
			for(int c=0; c<N; c++) {
				map[r][c] = input.charAt(c)-'0';
			}
		}
		
		quadTree(0, 0, N);
		System.out.println(sb.toString());
	}
	
	public static void quadTree(int r, int c, int size){
		
		// 안나눠도 된다면
		if(isPossible(r, c, size)) {
			sb.append(map[r][c]);
			return;
		}
		
		// 나눠야한다면
		int size2 = size / 2;
		
		sb.append("(");
		// 4분할
		quadTree(r,c,size2);
		quadTree(r,c+size2,size2);
		quadTree(r+size2,c,size2);
		quadTree(r+size2,c+size2,size2);
		
		sb.append(")");

	}
	
	public static boolean isPossible(int r, int c, int size) {
		int nums = map[r][c];
		
		for(int i=r; i<r+size; i++) {
			for(int j=c; j<c+size; j++) {
				if(nums != map[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
}
