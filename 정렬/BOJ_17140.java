package 정렬;

import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ_17140_G4_이차원 배열과 연산
 * @author mingggkeee
 * 정렬, 시뮬레이션
 */

public class BOJ_17140 {
	
	static int r,c,k;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken())-1;
		c = Integer.parseInt(st.nextToken())-1;
		k = Integer.parseInt(st.nextToken());
		int[][] map = new int[100][100];
		for(int i = 0;i<3;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<3 ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int time = 0; 
		int R =3, C = 3;
		while(map[r][c]!=k && time<=100) {
			if(R>=C) {
				int max = 0; 
				for(int i = 0; i<R; i++) {
					int[] count = new int[101];
					for( int j = 0; j<C;j++) {
						count[map[i][j]]++;
					}
					int l = 0; 
					for(int j =1; j<=C && l<100; j++) {
						for(int z = 1; z<101;z++) {
							if(count[z]==j) {
								map[i][l++] = z;
								map[i][l++] = j;
							}
						}
					}
					for(int j = l;j<=C && j<100;j++) {
						map[i][j] = 0;
					}
					max = l> max? l:max;
				}
				C = max;
			}else {
				int max = 0; 
				for(int j = 0; j<C ;j++) {
					int[] count = new int[101];
					for(int i = 0; i<R;i++) {
						count[map[i][j]]++;
					}
					int l = 0; 
					for(int i = 1 ; i<=R;i++) {
						for(int z= 1;z<101; z++) {
							if(count[z]==i) {
								map[l++][j] = z;
								map[l++][j] = i;
							}
						}
					}
					for(int i = l;i<=R && i<100; i++) {
						map[i][j] = 0;
					}
					max = l>max?l:max;
				}
				R = max;
			}
			time++;
		}
		
		System.out.println(time>100?-1:time);
	}
	
}
