package 분할정복;

import java.io.*;
import java.util.StringTokenizer;
/**
 * BOJ_1780_S2_종이의 개수
 * @author mingggkeee
 * 재귀, 분할정복
 */
public class BOJ_1780 {
	
	static int N;
	static int [][] map;
	static StringTokenizer st;
	static int count1,count2,count3;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		search(0,0,N);
		
		System.out.println(count1);
		System.out.println(count2);
		System.out.println(count3);
		
	}
	
	public static void search(int r, int c, int size) {
		
		// 안나눠도 된다면
		if(isPossible(r, c, size)) {
			if(map[r][c] == -1) {
				count1++;
			} else if(map[r][c] == 0) {
				count2++;
			} else {
				count3++;
			}
			return;
		}
				
		// 나눠야한다면
		int size2 = size / 3;
		
		// 9분할
		search(r,c,size2);
		search(r,c+size2,size2);
		search(r,c+2*size2,size2);
		search(r+size2,c,size2);
		search(r+size2,c+size2,size2);
		search(r+size2,c+2*size2,size2);
		search(r+2*size2,c,size2);
		search(r+2*size2,c+size2,size2);
		search(r+2*size2,c+2*size2,size2);
	}
	
	
	public static boolean isPossible(int r, int c, int size) {
		
		int compare = map[r][c];
		
		for(int i=r; i<r+size; i++) {
			for(int j=c; j<c+size; j++) {
				if(map[i][j]!=compare) {
					return false;
				}
			}
		}
		
		
		return true;
	}

}
