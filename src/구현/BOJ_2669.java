package 구현;

import java.util.*;
import java.io.*;

/**
 * BOJ_2669_B1_직사각형 네개의 합집합의 면적 구하기
 * @author mingggkeee
 * 구현
 */

public class BOJ_2669 {
	static int [][] map = new int[100][100];
	static int x1,x2,y1,y2;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int i=0; i<4; i++) {
			st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			for(int r = x1; r<x2; r++) {
				for(int c=y1; c<y2; c++) {
					map[r][c] = 1;
				}
			}
		}
		
		int count = 0;
		for(int r=0; r<100; r++) {
			for(int c=0; c<100; c++) {
				if(map[r][c] == 1)
					count++;
			}
		}
		
		System.out.println(count);

	}

}
